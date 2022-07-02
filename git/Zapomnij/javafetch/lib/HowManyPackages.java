package git.Zapomnij.javafetch.lib;

public class HowManyPackages {
    private static long pacman() throws Exception {
        String output = GetOutput.getOutput("pacman -Qq | wc -l");

        return Long.parseLong(output);
    }

    private static long dpkg() throws Exception {
        String output = GetOutput.getOutput("dpkg -l | grep -c '^ii'");

        return Long.parseLong(output);
    }

    private static long rpm() throws Exception {
        String output = GetOutput.getOutput("rpm -qa | wc -l");

        return Long.parseLong(output);
    }

    public static long get(String distroID) throws Exception {
        switch (distroID) {
            case "artix":
                return pacman();
            case "gentoo":
                return -1;
            case "arch":
                return pacman();
            case "devuan":
                return dpkg();
            case "debian":
                return dpkg();
            case "fedora":
                return rpm();
            default:
                return 0;
        }
    }
}
