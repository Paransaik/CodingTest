import java.util.Arrays;
import java.util.Scanner;

public class ____BOJ_G3_4256_트리 {
	static int[] nodes;
	static int SIZE, lastIndex;
//	static void dfsByPreOrder(int current) {
//		if (current > lastIndex)
//			return;
//		// 현재 노드 방문
//		System.out.print(nodes[current] + " ");
//		// 현재 노드의 자식 노드들 방문
//		dfsByPreOrder(current * 2);
//		dfsByPreOrder(current * 2 + 1);
//	}
//
//	static void dfsByInOrder(int current) {
//		if (current > lastIndex)
//			return;
//		// 현재 노드의 자식 노드들 방문
//		dfsByInOrder(current * 2);
//		// 현재 노드 방문
//		System.out.print(nodes[current] + " ");
//		dfsByInOrder(current * 2 + 1);
//	}

	static void dfsByPostOrder(int current) {
		if (current > lastIndex)
			return;
		// 현재 노드의 자식 노드들 방문
		dfsByPostOrder(current * 2);
		dfsByPostOrder(current * 2 + 1);
		// 현재 노드 방문
		System.out.print(nodes[current] + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			SIZE = sc.nextInt();
			nodes = new int[SIZE + 1]; // 1 인덱스부터 사용하므로 +1 크기로 잡기

			for (int i = 0; i < SIZE; i++) {
				nodes[++lastIndex] = sc.nextInt();
			}

			System.out.println(Arrays.toString(nodes));

//			System.out.println("dfsByPreOrder");
//			dfsByPreOrder(1);
//			System.out.println();
//			System.out.println("dfsByInOrder");
//			dfsByInOrder(1);
//			System.out.println();
			System.out.println("dfsByPostOrder");
			dfsByPostOrder(1);
			System.out.println();
		}

	}
}