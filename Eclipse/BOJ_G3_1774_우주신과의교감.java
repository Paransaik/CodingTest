package Eclipse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_1774_우주신과의교감 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		double[][] adjMatrix = new double[N][N];
		double[] minEdge = new double[N];
		boolean[] visited = new boolean[N];
		int[][] coor = new int[N][2];

		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			coor[i][0] = x;
			coor[i][1] = y;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				adjMatrix[i][j] = adjMatrix[j][i] = Math.sqrt(Math.pow(coor[i][0] - coor[j][0], 2)
						+ Math.pow(coor[i][1] - coor[j][1], 2));
			}
			minEdge[i] = Double.MAX_VALUE;
		}

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;
			adjMatrix[from][to] = 0;
			adjMatrix[to][from] = 0;
		}

		double result = 0;
		minEdge[0] = 0;
		for (int c = 0; c < N; c++) {
			double min = Double.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			visited[minVertex] = true;
			result += min;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && minVertex != i && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.printf("%.2f", result);
	}
}