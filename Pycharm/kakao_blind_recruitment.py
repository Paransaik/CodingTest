'''
'''
#
# import sys
# max = sys.maxsize

# from collections import Counter

# def solution(id_list, report, k):
#     answer = []
#     return answer
#
# print('reslut', solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2))  #[2, 1, 1, 0]
# print('reslut', solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3)) #[0, 0]

# 2
# def solution(n, k):
#     answer = 0
#
#     # 파이썬에서 에라토스테네스의 체를 사용시 런타임 오류 발생
#     # 소수 판별 함수
#     def cprime(num, k):
#         if num == 1:
#             return False
#         for i in range(2, (num//2+1)%k):
#             if num % i == 0:
#                 return False
#         return True
#
#     # https://velog.io/@code_angler/ 참고
#     # 진법 변환 함수
#     def base(number, bases):
#         base = ''
#         while number > 0:
#             number, mod = divmod(number, bases)
#             base += str(mod)
#         return base[::-1]
#
#     bs = base(n, k).split('0')
#
#     # 소수 개수 세기
#     for i in bs:
#         if i == '':
#             continue
#         if cprime(int(i), k):
#             answer += 1
#     return answer
def solution(n, k):
    answer = 0

    # 소수 판별 함수
    # 에라토스테네스의 체
    prime = [True] * 1000  # 1783661
    prime[1] = False  # 1은 소수가 아니기 때문에 생략
    m = int(1000 // 2)
    for i in range(2, m + 1):
        if prime[i] == True:
            for j in range(i + i, m, i):
                prime[j] = False

    # https://velog.io/@code_angler/ 참고
    # 진법 변환 함수
    def base(number, bases):
        base = ''
        while number > 0:
            number, mod = divmod(number, bases)
            base += str(mod)
        return base[::-1]

    # 00이 존재 할 경우 리스트에 ''이 저장 되므로 ''을 지움
    bs = base(n, k).split('0')

    #소수 개수 세기
    for i in bs:
        if i == '':
            continue
        if prime[int(i)]:
            answer += 1
    return answer

print(solution(437674, 3))  #3
print(solution(1000000, 10))  #2

# def solution(board, skill):
#     answer = 0
#
#     # 데미지, 회복 발동 시 발동되는 함수
#     def arouse_skill(sx, sy, ex, ey, st):
#         for x in range(sx, ex + 1):
#             for y in range(sy, ey + 1):
#                 board[x][y] += st
#         #[(board[x][y] + st) for x in range(sx, ex+1) for y in range(sy, ey+1)]
#
#     for player, start_x, start_y, end_x, end_y, stats in skill:
#         # 나쁜 플레이어 일 경우
#         if player == 1:
#             arouse_skill(start_x, start_y, end_x, end_y, -stats)
#         # 착한 플레이어 일 경우
#         if player == 2:
#             arouse_skill(start_x, start_y, end_x, end_y, stats)
#     print(board[1:3, 4:5])
#     # 파괴되지 않은 보드 수 세기
#     for i in range(len(board)):
#         for j in range(len(board[0])):
#             if board[i][j] > 0:
#                 answer += 1
#     return answer
#
# print(solution([[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]],
#       [[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]))
#print(solution([[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]],
#      [[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]))  #10

#print(solution([[1,2,3],[4,5,6],[7,8,9]], [[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]))  #6
#
# from collections import Counter
#
# def solution(info, edges):
#     answer = 0
#     print(Counter(edges[0]))
#     return answer
#
# print(solution([0,1,0,1,1,0,1,0,0,1,0], [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]))  #5
# #
# #









