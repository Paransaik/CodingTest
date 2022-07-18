import java.util.Arrays;
import java.util.PriorityQueue;

public class ____PRO_L3_42627_디스크컨트롤러 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][]{{2, 6}, {1, 9}, {0, 3}, {1, 3}}));
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1]);
//        Collections.addAll(q, jobs);
        Arrays.sort(jobs, (o1, o2) -> (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0]);

        int time = jobs[0][0], end = jobs[0][1], len = jobs.length, ans = 0;
        for (int i = 1; i < len; i++) {
            if (end > jobs[i][0]) {
                q.offer(new int[]{jobs[i][0], jobs[i][1]});
            }
        }

        while (!q.isEmpty()) {
            int[] program = q.poll();
            if (time < program[0]) time = program[0];
            ans += (time - program[0]) + program[1];
            time += program[1];
        }

        return ans / jobs.length;
    }
}