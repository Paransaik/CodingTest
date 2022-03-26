import java.util.*;

public class TESTT {

    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        StringTokenizer st;
//        num_teams       // 팀의 개수
//        remote_tasks    // 재택 업무
//        office_tasks    // 출근 업무
//        employees       // 사원 정보

//        int[] a = new int[4];

        ArrayList<Integer>[] l = new ArrayList[num_teams + 1];
        ArrayList<Integer>[] p = new ArrayList[num_teams + 1];
        for (int i = 1; i <= num_teams; i++) {
            l[i] = new ArrayList<>();
            p[i] = new ArrayList<>();
        }
        int len = employees.length;
        for (int i = 1; i <= len; i++) {
            boolean flag = true;
            st = new StringTokenizer(employees[i-1]);
//            System.out.println(employees[i-1]);
            int person = Integer.parseInt(st.nextToken());
            l[person].add(i);
            while(st.hasMoreTokens()) {
                String office = st.nextToken();
                for (int k = 0; k < office_tasks.length; k++) {
                    if (office.equals(office_tasks[k])) {
                        flag = false;
                    }
                }
            }
            if(flag) p[person].add(i);
        }
        for (int i = 1; i <= num_teams; i++) {
            if(l[i].size() == p[i].size()){
                Collections.sort(p[i]);
                p[i].remove(0);
            }
        }

        int cnt = 0;
        for (ArrayList<Integer> integers : p) {
            if(integers != null) cnt += integers.size();
        }
        int[] answer = new int[cnt];

        int point = 0;
        for (ArrayList<Integer> integers : p) {
            if(integers != null) {
                for (Integer integer : integers) {
                    answer[point++] = integer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(3,
                new String[]{"development", "marketing", "hometask"},
                new String[]{"recruitment", "education", "officetask"},
                new String[]{"1 development hometask", "1 recruitment marketing", "2 hometask", "2 development marketing hometask", "3 marketing", "3 officetask", "3 development"})));
//        System.out.println(solution(new int[]{6, 2, 2, 6}, new int[]{4, 4, 4, 2}));
    }
}












