import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_2110_공유기설치 {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int distance;
        int left = 1, right = house[N - 1] - house[0];
        int ans = 0;

        while (left <= right) {
            int cnt = 1, mid = (left + right) / 2;
            int start = house[0];

            for (int i = 1; i < N; i++) {
                distance = house[i] - start;
                if (distance >= mid) {
                    cnt++;
                    start = house[i];
                }
            }

            if (cnt >= C) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
