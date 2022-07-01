package git.Zapomnij.javafetch;

import java.util.Vector;

import git.Zapomnij.javafetch.LinuxDistros.*;
import git.Zapomnij.javafetch.lib.*;

public class Main {
    public final static String reset = "\u001B[0m";
    public static String color = new String();

    public static void main(String[] args) {
        String distro = new String();
        if (args.length == 1) {
            distro = args[0];
        } else if (args.length == 0) {
            try {
                distro = GetDistro.getDistroID();
            }
            catch (Exception er) {
                er.printStackTrace();
            }
        }

        String fullname = new String();
        Vector<String> image = new Vector<String>();

        switch (distro) {
            case "artix":
                Artix at = new Artix();
                fullname = at.getFullName();
                image = at.construct_image_vector();
                color = at.color;
                break;
            case "gentoo":
                Gentoo ge = new Gentoo();
                fullname = ge.getFullName();
                image = ge.construct_image_vector();
                color = ge.color;
                break;
            case "arch":
                Arch ac = new Arch();
                fullname = ac.getFullName();
                image = ac.construct_image_vector();
                color = ac.color;
                break;
            case "devuan":
                Devuan dv = new Devuan();
                fullname = dv.getFullName();
                image = dv.construct_image_vector();
                color = dv.color;
                break;
            default:
                System.err.println("Unknown distro: " + distro);
                System.exit(1);
                break;
        }

        try {
            System.out.println("                    " + GetHostInfo.getHostString());
            System.out.println("    " + image.get(0) + color + "System: " + reset + fullname + " " + System.getProperty("os.arch"));
            System.out.println("    " + image.get(1) + color + "Kernel: " + reset + System.getProperty("os.name") + " " + System.getProperty("os.version"));
            System.out.println("    " + image.get(2) + color + "Pkgs:   " + reset + HowManyPackages.get(distro));
            System.out.println("    " + image.get(3) + color + "Shell:  " + reset + System.getenv("SHELL"));
            System.out.println("    " + image.get(4) + color + "WM:     " + reset + GetOutput.getOutput("wmname"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
