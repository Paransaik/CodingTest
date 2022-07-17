import java.util.*;

public class PRO_L3_81303_표편집 {
    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    static int idx;
    static List<Integer> l;

    public static String solution(int n, int k, String[] cmd) {
        idx = k;
        l = new LinkedList<>();
        Deque<String> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) l.add(i);

        int cnt = 0;
        for (int i = cmd.length - 1; i > -1; i--) {
            if (cnt > 0 && cmd[i].equals("C")) {
                cnt--;
                continue;
            } else if (cmd[i].equals("Z")) {
                cnt++;
                continue;
            }
            q.addFirst(cmd[i]);
        }

        for (String s : q) {
            String[] oper = s.split(" ");

            switch (oper[0]) {
                case "D":
                    idx += Integer.parseInt(oper[1]);
                    break;
                case "U":
                    idx -= Integer.parseInt(oper[1]);
                    break;
                case "C":
                    l.remove(idx);
                    if (idx == l.size()) idx--;
                    break;
                default:
                    break;
            }
        }

        char[] ans = new char[n];
        Arrays.fill(ans, 'X');
        for (Integer integer : l) {
            ans[integer] = 'O';
        }

        StringBuilder sb = new StringBuilder();
        for (char an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }
}
