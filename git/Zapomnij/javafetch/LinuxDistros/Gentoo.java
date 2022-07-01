package git.Zapomnij.javafetch.LinuxDistros;

import java.util.Vector;

import git.Zapomnij.javafetch.Main;

public class Gentoo {
    public final String color = "\u001B[35m";
    private final String[] lines = {
        color + " ____        " + Main.reset,
        color + "/  _ \\       " + Main.reset,
        color + "\\ \\_\\ \\      " + Main.reset,
        color + "/     /      " + Main.reset,
        color + "\\____/       " + Main.reset,
    };

    public Gentoo() {}

    public Vector<String> construct_image_vector() {
        Vector<String> vec = new Vector<String>();

        for (String line : lines) {
            vec.add(line);
        }

        return vec;
    }

    public String getFullName() {
        return "Gentoo Linux";
    }
}
