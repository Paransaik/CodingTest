import java.util.Arrays;
import java.util.StringTokenizer;

public class PRO_L2_72412_순위검색 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(
                new String[]{"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"});
    }

    static class Solution {
        public int[] solution(String[] info, String[] query) {
            // 데이터 전처리
            StringTokenizer st;
            int len = info.length;
            String[][] map = new String[len][5];
            for (int i = 0; i < len; i++) {
                String line = info[i];
                st = new StringTokenizer(line);
                for (int j = 0; j < 5; j++) {
                    map[i][j] = st.nextToken();
                }
            }

            len = query.length;
            String[][] qry = new String[len][8];
            for (int i = 0; i < len; i++) {
                String line = query[i];
                st = new StringTokenizer(line);
                // 0 2 4 6 7
                for (int j = 0; j < 8; j++) {
                    qry[i][j] = st.nextToken();
                }
            }


            int[] answer = {};
            return answer;
        }
    }
}

/*
[섹파고(ENTP)] [오후 6:28] List<int[]> 만들고
[섹파고(ENTP)] [오후 6:28] 저게 ans이면
[섹파고(ENTP)] [오후 6:28] ans.toArray(new int[ans.size()][0]);
* */