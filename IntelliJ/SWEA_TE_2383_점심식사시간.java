import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_TE_2383_점심식사시간 {

    static class Person implements Comparable<Person> {
        // 행위치, 열위치, 내려가고 있는 계단 수
        int r, c, downCnt, status, time;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void init() {
            time = downCnt = 0;
            status = M;
        }

        @Override
        public int compareTo(Person o) {
            // 계단 입구까지 소요되는 시간이 빠른 순으로
            return this.time - o.time;
        }
    }

    // Move Wait Down Complete
    static final int M = 1, W = 2, D = 3, C = 4;

    // 한변의 길이, 모두 계단을 내려가는 최소 시간, 사람 수
    static int N, min, cnt;
    // 부분집합의 구현에서 사용할 선택 배열(선택되면 계단1, 선택이 안되면 계단2)
    static boolean[] selected;
    // 사람 리스트
    static ArrayList<Person> pList;
    static int[][] sList;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine().trim());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(in.readLine());
            StringTokenizer st = null;
            pList = new ArrayList<>();
            sList = new int[2][];
            min = Integer.MAX_VALUE;
            for (int i = 0, k = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    int c = Integer.parseInt(st.nextToken());
                    // 사람이면
                    if (c == 1) pList.add(new Person(i, j));
                    // 계단이면
                    else if (c > 1) sList[k++] = new int[]{i, j, c};
                }
            }
            // 사람 수
            cnt = pList.size();
            selected = new boolean[cnt];

            // 계단 배정하기
            divide(0);
            System.out.println("#" + tc + " " + min);
        }
    }

    // 부분집합을 이용해서 계단 배정
    // index: 처리할 사람의 인덱스
    public static void divide(int index) {
        if (index == cnt) {
            makeList();
            return;
        }

        // 부분집합에 포함: 계단 1에 배정
        selected[index] = true;
        divide(index + 1);
        // 부분집합에 비포함: 계단 2에 배정
        selected[index] = false;
        divide(index + 1);
    }

    // selected 상태에 따라 두 계단을 이용하는 각각의 리스트 생성
    public static void makeList() {
        ArrayList<Person> aList = new ArrayList<Person>();
        ArrayList<Person> bList = new ArrayList<Person>();

        for (int i = 0; i < cnt; i++) {
            Person p = pList.get(i);
            // time, downCnt, status 초기화
            p.init();
            if (selected[i]) {
                p.time = Math.abs(p.r - sList[0][0]) + Math.abs(p.c - sList[0][1]);
                aList.add(p);
            } else {
                p.time = Math.abs(p.r - sList[1][0]) + Math.abs(p.c - sList[1][1]);
                bList.add(p);
            }
        }
        // 두 계단리스트의 사람들이 모두 내려가는데 소요되는 시간
        int res = go(aList, bList);
        if (min > res) min = res;
    }

    public static int go(ArrayList<Person> aList, ArrayList<Person> bList) {
        int timeA = 0, timeB = 0;
        if (aList.size() > 0) timeA = goDown(aList, sList[0][2]);
        if (bList.size() > 0) timeB = goDown(bList, sList[1][2]);
        return Math.max(timeA, timeB);
    }

    public static int goDown(ArrayList<Person> list, int height) {
        // 계단 입구까지 도착하는데 소요되는 시간이 빠른 순으로 정렬
        Collections.sort(list);
        // 흘러가는 시간, 첫번째 사람의 계단입구 도착시간부터 처리
        int time = list.get(0).time;
        int size = list.size();
        // 내려가고 있는 사람 수, 다 내려간 사람 수
        int ingCnt = 0, cCnt = 0;
        while (true) {
            // 매 시간마다 사람들을 하나씩 꺼내어 상태를 처리
            for (int i = 0; i < size; i++) {
                Person p = list.get(i);
                if (p.status == C) continue;
                // 현재 시간이 사람의 계단 입구 도착시간과 같으면
                if (p.time == time) {
                    p.status = W;
                } else if (p.status == W && ingCnt < 3) {
                    p.status = D;
                    // 계단 수 1부터 출발
                    p.downCnt = 1;
                    // 내려가는 사람 수 증가
                    ++ingCnt;
                } else if (p.status == D) {
                    // 다 내려가지 못한 사람
                    if (p.downCnt < height) {
                        p.downCnt++;
                        // 다 내려간 사람
                    } else {
                        p.status = C;
                        ++cCnt;
                        --ingCnt;
                    }
                }
            }
            if (cCnt == size) break;
            ++time;
        }
        return time;
    }
}