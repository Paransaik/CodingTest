import java.io.*;
import java.util.*;

public class BOJ_S1_11723_집합 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Set<Integer> s = new HashSet<>();
        String oper;
        int num, tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            oper = st.nextToken();
            switch (oper){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    if(!s.contains(num)) s.add(num); break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    if(s.contains(num)) s.remove(num); break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (s.contains(num)) bw.append("1").append("\n");
                    else bw.append("0").append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (s.contains(num)) s.remove(num);
                    else s.add(num);
                    break;
                case "all":
                    for (int j = 1; j < 21; j++) {
                        s.add(j);
                    }
                    break;
                case "empty": s.clear(); break;
                default: break;
            }
        }
        bw.flush();
    }
}
