public class PRO_L1_72410_신규아이디추천 {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.solution("...!@BaT#*..y.abcdefghijklm");
    }

    public static class Solution {
        /*
        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
             만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        */
        public String solution(String new_id) {
            System.out.println("0 " + new_id);

            String answer = "";
            // 1
            new_id = new_id.toLowerCase();
            System.out.println("1 " + new_id);

            // 2
            char[] process = new_id.toCharArray();
            for (int i = 0; i < process.length; i++) {
                char c = process[i];
                if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                    answer += c;
                }
            }
            System.out.println("2 " + answer);

            // 3 4
            answer = answer.replaceAll(".{2,}", "."); //.replaceAll("^.", ".").replaceAll(".$", "");
            System.out.println("3 " + answer);

            // 5
            if(answer.equals("")) answer += "a";

            // 6
//            if (answer.length() >= 16) {
//                answer =
//            }
            return answer;
        }
    }
}
