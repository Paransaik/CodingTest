import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ____BOJ_G4_6493_Slurpys {
    static String slump = "([DE]F+)+G?$";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int tc = Integer.parseInt(br.readLine());
        bw.append("SLURPYS OUTPUT").append("\n");
        System.out.println(recursiveSlimp(br.readLine()));
//        while (tc-- > 0) {
//            String s = br.readLine();
//            char[] word = s.toCharArray();
//            int mid = s.length() - 1;
//            while (word[mid] != 'C' && word[mid] != 'H') mid--;
//            recursiveSlimp(s.substring(0, mid + 1));
//            bw.append((Pattern.matches(slump, s.substring(mid + 1))
//                    && recursiveSlimp(s.substring(0, mid + 1)) ? "YES" : "NO")).append("\n");
//        }
        bw.append("END OF OUTPUT");
        bw.flush();
    }

    public static boolean recursiveSlimp(String s) {
        String[] words = s.split("A");
        System.out.println(Arrays.toString(words));
        for (String word : words) {
            if (word.equals("")) continue;
            switch (word.charAt(0)) {
                case 'H':
                    break;
                case 'B':
                    if (word.charAt(1) == 'A') {
                        if (!recursiveSlimp(word.substring(1))) return false;
                    }
                    break;
                case 'D':
                case 'E':
                    if (!Pattern.matches(slump + "C", word)) return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}