# # BOJ 1662
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
import numpy as np
aa = np.zeros((4, 5, 6, 7))  # (3254, 224, 224, 3)
print(aa.shape)
aa = np.argmax(aa, axis=1)
print(aa.shape)





















