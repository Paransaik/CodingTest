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

# 10162
a = int(input())
b, c, d = 0, 0, 0

while a > 0:
    if a >= 300:
        a -= 300
        b += 1
    elif a >= 60:
        a -= 60
        c += 1
    else:
        a -= 10
        d += 1

if a != 0:
    print(-1)
else:
    print('{} {} {}'.format(b, c, d))



