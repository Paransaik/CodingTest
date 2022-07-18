import java.util.*;

public class ____PRO_L3_81303_표편집 {
    public static void main(String[] args) {
//        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    static int idx;
    static List<Integer> l;

    public static String solution(int n, int k, String[] cmd) {
        idx = k;
        l = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) l.add(i);

        for (String s : cmd) {
            String[] oper = s.split(" ");

            switch (oper[0]) {
                case "D":
                    idx += Integer.parseInt(oper[1]);
                    break;
                case "U":
                    idx -= Integer.parseInt(oper[1]);
                    break;
                case "C":
                    stack.add(new int[]{idx, l.remove(idx)});
                    if (idx == l.size()) idx--;
                    break;
                case "Z":
                    int[] node = stack.pop();
                    if (node[0] >= idx) idx++;
                    l.add(node[0], node[1]);
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