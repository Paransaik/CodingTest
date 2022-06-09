public class PRO_L2_72411_메뉴리뉴얼 {
    public static void main(String[] args) {

    }

    class Solution {
        public String[] solution(String[] orders, int[] course) {

            String[] answer = {};
            return answer;
        }
    }
/*
[섹파고(ENTP)] [오후 6:28] List<int[]> 만들고
[섹파고(ENTP)] [오후 6:28] 저게 ans이면
[섹파고(ENTP)] [오후 6:28] ans.toArray(new int[ans.size()][0]);
* */
}

    /*from itertools import combinations
        from collections import Counter
        def solution(orders, course):
        result = []
        para = []
        for order in orders:
        lst = list(order)
        for cou in course:
        result += list(map(lambda x: ''.join(sorted(x)), list(combinations(lst, cou))))

        answer = Counter(result)
        answer = sorted(answer.items(), key=lambda x: (len(x[0]), -x[1]))

        for cou in course:
        lst = dict()
        for i in range(1, len(orders)+1):
        lst[i] = []
        for s, cnt in answer:
        if len(s) == cou:
        lst[cnt].append(s)

        for i in range(1, len(orders)+1):
        if len(lst[i]) == 0:
        del lst[i]
        if lst:
        pa = sorted(lst.items())[::-1][0]
        if pa[0] > 1:
        para += pa[1]

        return sorted(para)*/