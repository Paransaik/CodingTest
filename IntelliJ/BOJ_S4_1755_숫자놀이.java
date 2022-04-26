import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S4_1755_숫자놀이 {
    // 숫자 -> 문자열 변환 배열
    static String[] itgToString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb;

        // M, N 입력
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // Itg을 담을 list 생성
        ArrayList<Itg> list = new ArrayList<>();

        // M 이상 N 이하의 정수
        for (int i = M; i <= N; i++) {
            // 입력 받는 숫자를 문자형 배열로 변환
            char[] itgToChar = Integer.toString(i).toCharArray();

            // 숫자->문자열로 바꿀 때 문자열 연산을 위한 sb 객체 생성
            sb = new StringBuilder();
            // 해당 숫자의 각 자리수에 해당하는 영어 문자 삽입
            for (char c : itgToChar) {
                // sb객체에 영어 문자 삽입
                // 해당하는 숫자의 Char를 숫자값으로 변환한 뒤 공백을 추가
                sb.append(itgToString[c - '0']).append(" ");
            }
            // list에 숫자와 숫자를 문자열로 변환한 객체 추가
            list.add(new Itg(i, sb.toString()));
        }

        // 문자열을 사전 순으로 Comparator와 람다식을 이용하여 리스트 정렬
        list.sort(Comparator.comparing(l -> l.str));

        // 출력형식에 맞춰서 출력
        int n = 0;
        for (Itg i : list) {
            bw.append(String.valueOf(i.num)).append(" ");
            if (++n % 10 == 0) bw.append("\n");
        }
        // 출력
        bw.flush();
    }

    public static class Itg {
        // 변환하기 전 정수
        int num;
        // 문자열로 변환 된 정수
        String str;

        // 생성자
        Itg(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}



