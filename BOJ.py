# # BOJ 1662 fail
#
# a = "15(22)13(92(1111)42(222))" # 60
# # a = "15(22)13(92(1111)42(222))123(1)45" #67
#
# a = input()
# board = a.split('(')
# stack = []
# for string in board:
#     stack.append(string)
#
# while len(stack) != 1:
#     if stack[-1].find(')') > 0:
#         word1 = stack.pop()
#         cursor = 0
#         for i in range(len(word1)):
#             if word1[cursor] == ')':
#                 b = word1[:cursor]
#                 print(b)
#                 print(stack)
#                 break
#             cursor += 1
#
#         word2 = stack.pop()
#         pre = word2[:-1]
#         post = int(word2[-1])
#         stack.append(pre + ((post * b) + word1[cursor+1:]))
#         print(stack)
#
# print(len(stack[0]))


# BOJ 17829
import sys

a = int(input())
board = []
for i in range(a):
    board.append(list(map(int, input().split())))

def CNN(board, a):
    row = []
    for i in range(0, a, 2):
        col = []
        for j in range(0, a, 2):
            sort_array = [board[i][j], board[i][j+1], board[i+1][j], board[i+1][j+1]]
            sort_array.sort()
            col.append(sort_array[2])
        row.append(col)
    if a == 2:
        return row

    return CNN(row, a//2)

print(CNN(board, a)[0][0])



















