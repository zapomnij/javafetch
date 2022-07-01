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

    public static long get(String distroID) throws Exception {
        switch (distroID) {
            case "Artix":
                return pacman();
            case "Gentoo":
                return -1;
            case "Arch":
                return pacman();
            case "Devuan":
                return dpkg();
            case "Debian":
                return dpkg();
            default:
                return -2;
        }
    }
}
