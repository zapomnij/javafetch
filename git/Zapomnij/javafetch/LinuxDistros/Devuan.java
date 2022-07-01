package git.Zapomnij.javafetch.LinuxDistros;

import java.util.Vector;

import git.Zapomnij.javafetch.Main;

public class Devuan {
    public final String color = "\u001B[35m";
    private final String[] lines = {
        color + "--.       " + Main.reset,
        color + "`':.'.    " + Main.reset,
        color + "  _/ /    " + Main.reset,
        color + " .'.'     " + Main.reset,
        color + "'-'       " + Main.reset,
    };

    public Devuan() {}

    public Vector<String> construct_image_vector() {
        Vector<String> vec = new Vector<String>();

        for (String line : lines) {
            vec.add(line);
        }

        return vec;
    }

    public String getFullName() {
        return "Devuan GNU/Linux";
    }
}
