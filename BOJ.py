# BOJ 1662 fail
import sys
# a = sys.stdin.readline()
# a = "33(562(71(9)))"
# a = "3(3(3(2(2)2(2))))"  # 108
# a = "9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(111))))))))))))))))))))))))"
# a = "123(3)"
# a = "10342(76)"
# a = "0(0)"
# board = a.split('(')
# stack = []
# intstack = []
#
# for string in board:
#     stack.append(string)
#
# if stack[-1].find(')') > -1:
#     word1 = stack.pop()
#     cursor = 0
#     for i in range(len(word1)):
#         if word1[cursor] == ')':
#             b = len(word1[:cursor])
#             break
#         cursor += 1
#     word2 = stack.pop()
#     pre = len(word2[:-1])
#     post = int(word2[-1])
#     stack.append(pre + str(post * b) + word1[cursor+1:])
#
# while len(stack) != 1:
#     if stack[-1].find(')') > -1:
#         word1 = stack.pop()
#         cursor = 0
#         for i in range(len(word1)):
#             if word1[cursor] == ')':
#                 b = int(word1[:cursor])
#                 break
#             cursor += 1
#         word2 = stack.pop()
#         pre = len(word2[:-1])
#         post = int(word2[-1])
#         stack.append(str(pre + (post * b)) + word1[cursor+1:])
#         print(stack)
#
#
# print(stack[0])

# 11720
# a = int(input())
#
# for i in range(a):
#     c += int(b[i])
# print(c)

# BOJ 1002
# 0 0 3 1 2 1
# import sys
#
# a = int(input())
# for i in range(a):
#     result = []
#     x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split())
#     for i in range(y1-r1, y2+r2+1):
#         for j in range(x1-r1, x2+r2+1):
#             if ((x1 - j)**2 + (y1 - i)**2)**0.5 == r1 and ((x2 - j)**2 + (y2 - i)**2)**0.5 == r2:
#                 result.append([i, j])
#     print(len(result), result)

# BOJ 17298
# 20
# 5 4 6  9  8 41 3 2 1 5 4 7  5  52 4 5  5  4 5  45
# 6 6 9 41 41 5  5 5 5 7 7 52 52 -1 5 5  5  5 45 -1
# 6 6 9 41 41 52 5 5 5 7 7 52 52 -1 5 45 45 5 45 -1

# a = int(input())
# input = list(map(int, input().split()))[::-1]
#
# stack = []
# output = []
# max = -1
# for i in range(a):
#     num = input[i]
#
#     if bool(stack):  # 스택이 안 비어 있으면
#         if num < stack[-1]:
#             max = stack[-1]
#             output.append(max)
#         else:
#             while bool(stack) and num >= stack[-1]:
#                 stack.pop()
#             if bool(stack):
#                 output.append(max)
#             else:
#                 output.append(-1)
#     else:  # 스택이 비어 있으면
#         output.append(-1)
#
#     stack.append(num)
#
# print(*output[::-1])

# 풀어준 것
# a = int(input())
# input_lst = list(map(int, input().split()))[::-1]
# stack = []
# output = []
# max_val = -1  # 함수를 변수명 X
#
# for i in range(a):
#     num = input_lst[i]
#     if stack:  # PEP8 기반
#         if num < stack[-1]:
#             max_val = stack[-1]
#             output.append(max_val)
#         else:
#             while stack and num >= stack[-1]:
#                 stack.pop()
#             if stack:
#                 # stack의 맨 뒤와 max_val중에 큰 값을 넣어줌
#                 output.append(max(max_val, stack[-1]))
#             else:
#                 output.append(-1)
#     else:  # 스택이 비어 있으면
#         output.append(-1)
#
#     stack.append(num)
#
# print(*output[::-1])

# 16967 BOJ
import sys

a, b, c, d = map(int, input().split())
board = []
for i in range(a + d):
    board.append(list(map(int, sys.stdin.readline().split())))

for i in range(a):
    for j in range(b):
        if i - c > -1 and j - d > -1:
            board[i][j] = board[i][j] - board[i - c][j - d]
        print(board[i][j], end=' ')
    print()


















