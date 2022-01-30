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
# 2번
def solution(n):
    print(int(str(bin(n)[2:]), 3))
solution(10**9)
'''

# 3번

































