def solution(n, info):
    answer = [0 for i in range(10)]
    nodop = []
    # Prunus = []

    compare_info = [0 for i in range(10)]
    compare_rion = [0 for i in range(10)]

    # 점수 구하기
    def sum_score(record):
        sum = 0
        shoot = 0
        while shoot < 10:
            for score in range(10, 0, -1):
                sum += record[shoot] * score
                shoot += 1
        return sum

    # 맞힌 화살 개수 비교하기
    def compare_count(Prunus, rion):
        for i in range(10):
            if Prunus[i] > rion[i]:
                compare_info[i] = Prunus[i]
                compare_rion[i] = 0
            elif Prunus[i] < rion[i]:
                compare_info[i] = 0
                compare_rion[i] = rion[i]
            else:
                compare_info[i] = 0
                compare_info[i] = 0

    # 머리로는 구현 되는데 어떤 알고리즘을 써야하는지 모르겠어요 ㅠㅠ
    for i in range(n):
        count = 0
        for i in range(10):
            if info[i] > answer[i] + 1:
                continue
            if info[i] < answer[i] + 1:
                answer[i] += 1
                count += 1
                if count == n:
                    break

        compare_count(info, answer)
        print(sum_score(compare_info), sum_score(compare_rion))
        if sum_score(compare_info) < sum_score(compare_rion):
            break
        #Prunus_score = sum_score(compare_info)
        #rion_score = sum_score(compare_rion)

    if nodop:
        return -1

    return answer


print(solution(5, [2,1,1,1,0,0,0,0,0,0,0]))  # [0,2,2,0,1,0,0,0,0,0,0]
# print(solution(1, [1,0,0,0,0,0,0,0,0,0,0],	[-1]))
# print(solution([9, 0,0,1,2,0,1,1,1,1,1,1],	[1,1,2,0,1,2,2,0,0,0,0]))
# print(solution([10, 0,0,0,0,0,0,0,0,3,4,3], [1,1,1,1,1,1,1,1,0,0,2]))