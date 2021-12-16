# # BOJ 1662 fail
# # import sys
# # print(sys.getsizeof(9))
# # print(sys.getsizeof("9"))
#
# # a = input()
# # a = "33(562(71(9)))"
# a = "15(22)13(92(1111)42(222))" #60
# # a = "15(22)13(92(1111)42(222))123(1)45" #67
# stack = []
#
# board = a.split('(')
#
# for i in range(len(board)):
#     stack.append(board[i])
# # print(stack)
#
# board = stack.pop().split(')')
# print(stack)
# print(board)
# result = len(board[0])
#
# for i in range(1, len(board)):
#     last_word = str(stack.pop())
#     # print(last_word, len(last_word[:-1]), result, int(last_word[-1]), len(board[i]))
#     result = len(last_word[:-1]) + result * int(last_word[-1]) + len(board[i])
#
# print(result)
#
# #66	141	53.226%
# #67	142	53.600%
# #67	143	53.600%
#
# # BOJ 2606
#
# a = 4# int(input())  # 노드 개수
# b = 5# int(input())  # 간선 개수
#
# dic = {}
# for i in range(a):
#     dic[i+1] = ""
# print(dic)
# print(dic[1])
#
# for i in range(b):
#     pass  # 딕셔너리 선언
# import numpy as np
# aa = np.zeros((4, 5, 6, 7))  # (3254, 224, 224, 3)
# print(aa.shape)
# aa = np.argmax(aa, axis=1)
# print(aa.shape)

# 1193
# a, b = 1, 1
# c = 3
#
# while(c > 1):
#     if c % 2 == 0:
#
#     else:
#
#     c -= 1
#
# print(str(a) + '/' + str(b))

# T = int(input()) # 입력 데이터의 수 나타내는 정수 T
# stack = [] #스택 리스트 생성
#
# for i in range(T): # 이후 괄호 문자열이 한 줄에 주어짐.
#     kr = input() #문자열 하나 입력받음
#
#     for i in kr:  # 문자열 반복 조건
#         if i == '(':
#             stack.append(i) # 스택 열린괄호일때 스택에 추가
#         elif i == ')' and bool(stack): #닫힌 괄호일 때 조건
#             stack.pop()
#
#     print(stack)
#     if len(stack) == 0:
#         print("YES")
#     else:
#         print("NO")

# 1874

a = int(input())
input_list = []
stack = []

for i in range(a):
    input_list.append(int(input()))

pointer = 0
for i in range(a):
    if input_list[pointer] != i:
        print("+")
        stack.pop()
        print("-")
        break;
    else:
        print("+")
        stack.append(i)

print(stack)