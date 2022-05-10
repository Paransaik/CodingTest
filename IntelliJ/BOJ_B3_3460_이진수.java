import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_B3_3460_이진수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> l = new LinkedList<>();

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            l.clear();
            char[] binary = Integer.toBinaryString(Integer.parseInt(br.readLine())).toCharArray();

            for (int i = 0, len = binary.length; i < len; i++) {
                if(binary[i] == '1') l.add(len - i - 1);
            }
            Collections.sort(l);
            for (Integer integer : l) {
                bw.append(String.valueOf(integer)).append(" ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
