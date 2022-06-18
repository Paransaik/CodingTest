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

            for (Sing sing : l) {
                System.out.println(sing);
            }
            System.out.println();
            Collections.sort(l);
            for (Sing sing : l) {
                System.out.println(sing);
            }

            List<Integer> ans = new ArrayList<>();
            // 2개씩 Ans에 담기
            String genre = l.get(0).genre;
            int cnt = 0;
            boolean pass = false;
            for (Sing sing : l) {

                if (cnt < 2 && !pass) {
                    if(genre != sing.genre) continue;
                    genre = sing.genre;
                    ans.add(sing.idx);
                    cnt++;
                } else if(pass){
                    continue;
                }
//
//                // Pass가 True면 Pass
//                if(pass) continue;
//                if(genre != sing.genre) pass = false;
//                // 2개를 담았으면 Pass true
//                if(cnt >= 2) pass = true;
//
//                if(cnt < 2 && !pass){
//                    genre = sing.genre;
//                    cnt++;
//                }
            }

            return answer;
        }
    }

    static class Sing implements Comparable<Sing> {
        int idx;
        String genre;
        int cntGenre;
        int sumPlayNo;
        int playNo;

        public Sing(int idx, String genre, int cntGenre, int sumPlayNo, int playNo) {
            this.idx = idx; // 고유번호
            this.genre = genre; // 장르
            this.cntGenre = cntGenre; // 장르 개수
            this.sumPlayNo = sumPlayNo; // 장르 총 플레이 수
            this.playNo = playNo; // 단일 플레이 수
        }

        // 1. 장르 2. 장르내에 재생횟수 3. 고유번호
        @Override
        public int compareTo(Sing o) {
            if (this.cntGenre == o.cntGenre) {
                return (this.playNo == o.playNo) ? this.idx - o.idx : o.playNo - this.playNo;
            }
            return o.cntGenre - this.cntGenre;
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