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

# 1193
import sys
input = int(sys.stdin.readline())

i, j = 1, 0
col = 1
count = 1

for k in range(count):
    if col % 2 == 0:
        i += 1
        for l in range(col):
            i += 1
            j -= 1
            count += 1
            if count == input:
                break
    else:
        j += 1
        for l in range(col):
            i -= 1
            j += 1
            count += 1
            if count == input:
                break
    col += 1

print('{}/{}'.format(i, j))
