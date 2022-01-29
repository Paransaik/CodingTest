'''
# 1
import heapq
m = 10**6
result = [0, 1] + [0 for _ in range(m-1)]

hp = [[i*i, i] for i in range(1, m+1)]
heapq.heapify(hp)

t = 2
while t <= m:
    top, b = heapq.heappop(hp)

    if result[t-1] == top:
        continue

    result[t] = top
    heapq.heappush(hp, [top*b, b])
    t += 1

print(result[:20])
print(result[1])
print(result[4])
print(result[7])
print(result[100])
print(result[1000])
print(result[10000])
'''

'''
# 2
def solution(target, postions):
    result = 0
    for pos_x, pos_y in postions:
        score = 10
        for i in range(1, len(target)+1):  # target[t_idx]
            if pos_x**2 + pos_y**2 <= sum(target[:i])**2:
                result += score
                break
            score -= 2
    print(result)

solution([2, 2, 2, 2, 2], [[0, 0], [0, 1], [1, 1], [-3, 5], [7, 5], [10, 0], [-15, 22], [-6, -5], [3, 3], [5, -5]])
solution([2, 3, 4, 3, 2], [[0, 0], [0, 1], [1, 1], [-3, 5], [7, 5], [10, 0], [-15, 22], [-6, -5], [3, 3], [5, -5]])
'''

# 3
import sys
sys.setrecursionlimit(10**6)

def solution(ma, click):
    ma2 = [list(ma[i]) for i in range(len(ma))]
    ma = [list(ma[i]) for i in range(len(ma))]

    for i in range(len(ma2)):
        for j in range(len(ma2[i])):
            if ma2[i][j] != '*':
                ma2[i][j] = 0

    # 지뢰 개수 맵핑
    def search(i, j):
        if i < 0 or i >= len(ma2) or \
            j < 0 or j >= len(ma2[0]) or \
                ma2[i][j] == '*':
                return

        ma2[i][j] += 1

    for i in range(len(ma2)):
        for j in range(len(ma2[i])):
            if ma2[i][j] == '*':
                search(i + 1, j)
                search(i - 1, j)
                search(i, j + 1)
                search(i, j - 1)
    #######################

    # 사용자 클릭 시
    # ma = 사용자 맵
    # ma2 = 개발자 맵
    def dfs(k, h):
        if k < 0 or k >= len(ma2) or \
            h < 0 or h >= len(ma2[0]):
                return

        if ma2[k][h] != 0:
            # ma[k][h] = ma2[k][h]
            return

        ma[k][h] = 0
        ma2[k][h] = '_'

        dfs(k + 1, h)
        dfs(k - 1, h)
        dfs(k, h + 1)
        dfs(k, h - 1)


    #
    # for m in ma:
    #     print(*m)

    # for x, y in click:
    #     x, y = 0, 0
    #     if ma2[x][y] != 0:  # 0이 아니고 숫자일 때
    #         ma[x][y] = ma2[x][y]
    #         for m in ma:
    #             print(*m)
    #     else:  # 0일 때
    x, y = 0, 0
    dfs(x, y)
    print('사용자 맵')
    for m in ma:
        print(*m)

    print('개발자 맵')
    for m in ma2:
        print(*m)
solution(["____*____", "________*", "______*__", "_________", "__*_____*", "_________", "*_____*__", "___*_____", "*_____*__"],
         [[0, 0], [0, 5], [1, 6], [1, 7], [7, 8], [0, 6], [2, 8], [8, 4], [8, 3], [8, 2], [8, 1], [7, 2], [7, 1], [7, 0]])

'''
   //0,0 을 한번 눌렀을 때
    //vector<string> result = {
    //    "0001*____",
    //    "000112__*",
    //    "000001*__",
    //    "01110112_",
    //    "0110001*_",
    //    "12_10112_",
    //    "__111___*",
    //    "___*_____",
    //    "_________",
    //};


# "0001*101_",
# "00011212*",
# "000001*_1",
# "01110112_",
# "0110001__",
# "12_101121",
# "__11110__",
# "111*___10",
# "*1111_*10",
'''

# 2022.01.28.
'''
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=712&sca=2060
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=944&sca=2060
'''
'''
# http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=712&sca=2060
cnt = int(input())
coor = []
dur = []
for _ in range(cnt):
    a, b = map(int, input().split())
    coor.append([a, b])
    dur.append([a+10, b+10])

area = 0

for i, x, y in enumerate(coor):
    for j in range(i+1, len(coor)):
        if coor[j][0] < x and x < coor[j][0]+10 and coor[j][1] < y and y <coor[j][1]+10 or \

print(coor)
'''
'''
3 5 15, 13 15 25
7 2 7,  17 2 17
'''

# 2022.01.28. 모의코테
'''
# 1번, 아름다운 연도 구하기
def solution(P):
    p = P[:]
    while True:
        p = str(int(p)+1)
        lst = list(p)
        flag = 0
        for i in range(10):
            if lst.count(str(i)) > 1:
                flag = 1
                break
        if flag == 0:
            print(p)
            break
            
solution('1987')
solution('2015')
'''
'''
# 2번, PQ
def solution(n):
    pass

solution()
'''
































