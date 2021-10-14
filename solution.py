# BOJ 1662
a = "33(562(71(9)))"
result = ""
word = ""
# 스택
board = a.split('(')
# board = board[:-1] + board[-1].split(')')
print(board)
# def recursive(S):
#     if len(S) == 0:
#         return result
#
#     for i, s in enumerate(board):
#         if s == '(':
#             # push [:i-1]
#             Str = board[i+1:]
#
#         elif s == ')':
#             # pop = l
#             # result = l[:-1] + l[-1] * board[:i-1]
#             # return result
#             pass
#
#         word = word + s
#
# print(recursive(a))

#66	141	53.226%
#67	142	53.600%
#67	143	53.600%