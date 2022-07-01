package git.Zapomnij.javafetch.LinuxDistros;

import java.util.Vector;

import git.Zapomnij.javafetch.Main;

public class Arch {
    public final String color = "\u001B[34m";
    private final String[] lines = {
        color + "    /\\        " + Main.reset,
        color + "   /  \\       " + Main.reset,
        color + "  / __ \\      " + Main.reset,
        color + " / /  \\ \\     " + Main.reset,
        color + "/__\\  /__\\    " + Main.reset,
    };

    public Arch() {}

    public Vector<String> construct_image_vector() {
        Vector<String> vec = new Vector<String>();

        for (String line : lines) {
            vec.add(line);
        }

        return vec;
    }

    public String getFullName() {
        return "Arch Linux";
    }
}
