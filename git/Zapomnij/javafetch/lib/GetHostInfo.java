package git.Zapomnij.javafetch.lib;

import java.net.InetAddress;

import git.Zapomnij.javafetch.Main;

public class GetHostInfo {
    public static String getHostname() {
        String hostname = new String();
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e) {
            hostname = "unknown";
        }
        return Main.color + hostname + Main.reset;
    }

    public static String getUsername() throws Exception {
        String name = System.getProperty("user.name");
        if (name == null) throw new Exception("Username is equal to 'null'");

        return Main.color + name + Main.reset;
    }

    public static String getHostString() throws Exception {
        return getUsername() + '@' + getHostname();
    }
}
