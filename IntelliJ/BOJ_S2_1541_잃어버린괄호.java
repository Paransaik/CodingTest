import java.io.*;
import java.util.*;

public class BOJ_S2_1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] num = s.split("(-|\\+)");
        String[] opr = s.split("[0-9]+");

        List<Integer> l = new LinkedList<>();
        for (int i = 0, len = opr.length; i < len; i++) {
            if (opr[i].equals("+")) {
                l.add(Integer.parseInt(String.valueOf(l.remove(l.size() - 1))) + Integer.parseInt(num[i]));
            } else l.add(Integer.parseInt(num[i]));
        }

        int ans = (l.isEmpty()) ? Integer.parseInt(s) : l.remove(0);
        for (Integer integer : l) ans -= integer;
        System.out.println(ans);
    }
}