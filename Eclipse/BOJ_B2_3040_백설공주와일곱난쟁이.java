package Eclipse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_B2_3040_백설공주와일곱난쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] arr = new int[9];
	static int sum;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 9; i++) {
			arr[i] = (Integer.parseInt(br.readLine()));
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		for (int j = 0; j < 8; j++) {
			sum -= arr[j];
			for (int k = j + 1; k < 9; k++) {
				sum -= arr[k];
				if (sum == 100) {
					for (int l = 0; l < 9; l++) {
						if (l != j && l != k) System.out.println(arr[l]);
					}
					return;
				}
				sum += arr[k];
			}
			sum += arr[j];
		}
	}
}