# 2021.10.16. 14~16, 4문제(프로그래밍3+SQL1)
# 2021 Dev-Matching: 웹 백엔드 개발자(하반기)

# def solution(registered_list, new_id):
#     answer = ''
#
#     def divis():  # 문자열 분리 함수
#
#         for w in registered_list:
#             if w == new_id:
#
#     return answer

# from collections import OrderedDict
# def solution(leave, day, holidays):
#     answer = 0
#     num = 0
#     h = ''
#     reslut = []
#
#     holiday = [False for i in range(1, 31)]
#     days = [['MON', False],
#             ['TUE', False],
#             ['WED', False],
#             ['THU', False],
#             ['FRI', False],
#             ['SAT', True],
#             ['SUN', True]]
#
#     # Cycle을 위한 몇번째 요일인지 구함
#     for m, w in days:
#         if day == m:
#             break
#         else:
#             num += 1
#
#     # 달력에 토, 일 표시
#     for i in range(30):
#         holiday[i] = days[(num + i) % 7][1]
#
#     # 달력에 연휴 표시
#     for h in holidays:
#         holiday[h-1] = True
#
#     for i in range(30):
#         if holiday[i] == True:
#             holiday[i] = 1
#         else:
#             holiday[i] = 0
#
#     def dfs(elements, start, leave):  # 조합 휴일이 아닌 수, leave
#         if leave == 0:
#             h = ''.join(map(str, holiday))
#             # print(holiday)
#             reslut.append(len(max(h.split('0'), key=len)))
#             return
#
#         for i in range(start, 30):
#             if holiday[i] == 0:
#                 holiday[i] = 1
#                 dfs(holiday, i+1, leave-1)
#                 holiday[i] = 0
#     dfs(holiday, 0, leave)
#
#     return sorted(reslut)[-1]
#
# print(solution(5, "FRI", [6, 21, 23, 27, 28]))  #10
# #print(solution(3, "SUN", [2, 6, 17, 29]))  #8

# 2751 번 문제
# 수 정렬하기 2

from sys import stdin

# BOJ 10828

# import sys
#
# stack = []
#
# def push(x):
#     stack.append(x)
#
# def pop():
#     if not bool(stack):
#         print(-1)
#     else:
#         print(stack.pop())
#
# def size():
#     print(len(stack))
#
# def empty():
#     if bool(stack):
#         print(0)
#     else:
#         print(1)
#
# def top():
#     if not bool(stack):
#         print(-1)
#     else:
#         print(stack[-1])
#
# a = sys.stdin.readline()
#
# for i in range(int(a)):
#     b = sys.stdin.readline().split()
#     if b[0] == "push":
#         push(b[1])
#     elif b[0] == "pop":
#         pop()
#     elif b[0] == "size":
#         size()
#     elif b[0] == "empty":
#         empty()
#     elif b[0] == "top":
#         top()

# 2869
# import sys
# import math
# a, b, c = map(int, sys.stdin.readline().split())
# print(math.ceil((c - a)/(a - b)) + 1)

#