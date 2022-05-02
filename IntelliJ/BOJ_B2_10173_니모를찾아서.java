import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_B2_10173_니모를찾아서 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.contains("EOI")) {
                break;
            }
            if (input.toUpperCase().contains("NEMO")) bw.append("Found");
            else bw.append("Missing");
            bw.append("\n");
        }
        bw.flush();
    }
}
