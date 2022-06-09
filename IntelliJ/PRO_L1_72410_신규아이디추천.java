public class PRO_L1_72410_신규아이디추천 {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        s.solution("...!@BaT#*..y.abcdefghijklm");
        s.solution("z-+.^.");
        s.solution("=.=");
        s.solution("123_.def");
        s.solution("abcdefghijklmn.p");
    }

    public static class Solution {
        public String solution(String new_id) {
            String answer = "";
            new_id = new_id.toLowerCase();
            char[] process = new_id.toCharArray();
            for (char c : process) {
                if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                    answer += c;
                }
            }
            answer.replaceAll("[.]{2,}", ".").replaceAll("^[.]", "").replaceAll("[.]$", "");
            if (answer.equals("")) answer += "a";
            if (answer.length() >= 16) answer = answer.substring(0, 15).replaceAll("[.]$", "");
            while (answer.length() < 3) answer += answer.substring(answer.length() - 1);
            return answer;
        }
    }
}
