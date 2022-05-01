import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ____BOJ_S4_2477_참외밭 {
    static StringTokenizer st;

    static int K;
    static int[][] disArr;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        K = Integer.parseInt(br.readLine());
//        disArr = new int[8][2];
//
//        int r = 0, c = Integer.MIN_VALUE;
//        for (int i = 0; i < 6; i++) {
//            st = new StringTokenizer(br.readLine());
//            int l = Integer.parseInt(st.nextToken());
//            disArr[i][0] = l;
//
//            int k = Integer.parseInt(st.nextToken());
//            disArr[i][1] = k;
//            r += k;
//            c = Math.max(c, k);
//            if (i < 2) {
//                disArr[i + 6][0] = l;
//                disArr[i + 6][1] = k;
//            }
//        }
//
//        int idx = 0;
//        for (int i = 0; i < 6; i++) {
//            if (disArr[i][0] == disArr[i + 2][0]) {
//                idx = i;
//                break;
//            }
//        }
//        r = r / 2 - c;
//        System.out.println(Arrays.deepToString(disArr));
//        System.out.println(idx);
//        System.out.println(r + " " + c);
//        System.out.println(((c * r) - disArr[idx + 1][1] * disArr[idx + 2][1]) * K);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int MaxWidthI = 0, MaxWidth = 0, MaxHeight = 0, MaxHeightI = 0, d;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            //가장 긴 가로의 길이와 위치 찾기
            if ((d == 1 || d == 2) && MaxWidth < arr[i]) {
                MaxWidth = arr[i];
                MaxWidthI = i;
            }
            //가장 긴 세로의 길이와 위치 찾기
            else if ((d == 3 || d == 4) && MaxHeight < arr[i]) {
                MaxHeight = arr[i];
                MaxHeightI = i;
            }
        }

        int right, left, minWidth, minHeight;

        if (MaxWidthI + 1 == 6) right = 0;
        else right = MaxWidthI + 1;

        if (MaxWidthI - 1 == -1) left = 5;
        else left = MaxWidthI - 1;
        //빈 사각형의 세로 길이
        minHeight = Math.abs(arr[right] - arr[left]);

        if (MaxHeightI + 1 == 6) right = 0;
        else right = MaxHeightI + 1;

        if (MaxHeightI - 1 == -1) left = 5;
        else left = MaxHeightI - 1;
        //빈 사각형의 가로 길이
        minWidth = Math.abs(arr[right] - arr[left]);
        System.out.println(MaxWidth + " " + MaxHeight + " " + minHeight + " " + minWidth);
        System.out.println(((MaxWidth * MaxHeight) - (minHeight * minWidth)) * N);
    }
}
