import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_B2_1408_24 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(":");
        String[] b = br.readLine().split(":");

        int aNum = Integer.parseInt(a[0]) * 3600 + Integer.parseInt(a[1]) * 60 + Integer.parseInt(a[2]);
        int bNum = Integer.parseInt(b[0]) * 3600 + Integer.parseInt(b[1]) * 60 + Integer.parseInt(b[2]);

        if (aNum > bNum) bNum += 24 * 3600;
        int ans = bNum - aNum;
        bw.append(String.format("%02d" + ":%02d" + ":%02d", ans/3600, (ans/60)%60, ans%60));
        bw.flush();
    }
}
