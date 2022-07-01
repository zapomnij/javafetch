package git.Zapomnij.javafetch.lib;

import java.io.File;
import java.io.FileReader;

public class GetDistro {
    public static String getDistroID() throws Exception {
        String distro = new String();

        {
            String allbuf = new String();
            {
                StringBuilder str = new StringBuilder();

                FileReader fd = new FileReader(new File("/etc/lsb-release"));
                int buf;
                while ((buf = fd.read()) != -1) {
                    str.append((char) buf);
                }

                allbuf = str.toString();
            }

            String[] split = allbuf.split("\\s+");
            for (String item : split) {
                if (item.startsWith("DISTRIB_ID")) {
                    String[] arr = item.split("\"");
                    distro = arr[1];
                    break;
                }
            }
        }

        return distro;

    }
}
