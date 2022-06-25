import java.util.*;

public class PRO_L3_42579_베스트앨범 {

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, int[]> m = new HashMap<>();
            List<Sing> l = new ArrayList<>();
            int len = genres.length;

            // 장르 종류를 알기 위한 Set 생성
            Set<String> set = new HashSet<>(Arrays.asList(genres).subList(0, len));

            // 장르 횟수, 총 재생 횟수를 알기 위한 Map 초기화
            for (String s : set) m.put(s, new int[]{0, 0});

            // 해당 장르의 총 재생 횟수
            for (int i = 0; i < len; i++) {
                String genre = genres[i];
                int[] cnt = m.get(genre);
                m.put(genre, new int[]{cnt[0] + 1, cnt[1] + plays[i]});
            }

            // list에 Sing 객체 추가
            for (int i = 0; i < len; i++) {
                String genre = genres[i];
                int[] cnt = m.get(genre);
                l.add(new Sing(i, genre, cnt[0], cnt[1], plays[i]));
            }

            Collections.sort(l);

            List<Integer> ans = new ArrayList<>();
            String genre = l.get(0).genre;
            int cnt = 0;
            // 2개씩 Ans에 담기
            for (Sing sing : l) {
                if (cnt < 2 && genre.equals(sing.genre)) {
                    ans.add(sing.idx);
                    cnt++;
                } else if (!genre.equals(sing.genre)) {
                    genre = sing.genre;
                    ans.add(sing.idx);
                    cnt = 1;
                }
            }

            int aLen = ans.size();
            int[] answer = new int[aLen];
            for (int i = 0; i < aLen; i++) {
                answer[i] = ans.get(i);
            }
            return answer;
        }
    }

    static class Sing implements Comparable<Sing> {
        int idx; // 고유번호
        String genre; // 장르
        int cntGenre; // 장르 개수
        int sumPlayNo; // 장르 총 플레이 수
        int playNo; // 단일 플레이 수

        public Sing(int idx, String genre, int cntGenre, int sumPlayNo, int playNo) {
            this.idx = idx;
            this.genre = genre;
            this.cntGenre = cntGenre;
            this.sumPlayNo = sumPlayNo;
            this.playNo = playNo;
        }

        // 1. 장르 2. 장르내에 재생횟수 3. 고유번호
        /*
        * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        * */
        @Override
        public int compareTo(Sing o) {
            if (this.sumPlayNo == o.sumPlayNo) {
                return (this.playNo == o.playNo) ? this.idx - o.idx : o.playNo - this.playNo;
            }
            return o.sumPlayNo - this.sumPlayNo;
        }

        @Override
        public String toString() {
            return "Sing{" +
                    "idx=" + idx +
                    ", genre='" + genre + '\'' +
                    ", cntGenre=" + cntGenre +
                    ", sumPlayNo=" + sumPlayNo +
                    ", playNo=" + playNo +
                    '}';
        }
    }
}