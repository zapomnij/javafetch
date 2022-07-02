package git.Zapomnij.javafetch.LinuxDistros;

import java.util.Vector;

public class Generic {
    private final String[] lines = {
        "  /  \\      ",
        " _\\  /_     ",
        "/  __  \\    ",
        "| |__| |    ",
        "\\______/    ",
    };

    public Generic() {}

    public Vector<String> construct_image_vector() {
        Vector<String> vec = new Vector<String>();

        for (String line : lines) {
            vec.add(line);
        }

        return vec;
    }
}
