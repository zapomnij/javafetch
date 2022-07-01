package git.Zapomnij.javafetch.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetOutput {
    public static String getOutput(String command) throws Exception {
        String shell = System.getenv("SHELL");
        if (shell == null) {
            throw new Exception("SHELL environment variable is not set. Unable to execute '" + command + "'");
        }

        ProcessBuilder pb = new ProcessBuilder(shell, "-c", command);
        Process pid = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(pid.getInputStream()));
        
        String buf = br.readLine();

        if (buf == null) {
            throw new Exception("'" + command + "'' command haven't returned output");
        }

        return buf;
    }
}
