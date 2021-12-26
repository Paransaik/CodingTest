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

# BOJ 4949
import sys
a = ''
while a != '.':
    stack = []
    flag = 0
    a = sys.stdin.readline().rstrip()
    for w in a:
        if w == '(':
            stack.append('(')
        elif w == ')':
            if bool(stack) and stack[-1] == '(':
                stack.pop()
            else:
                flag = 1
                break
        if w == '[':
            stack.append('[')
        elif w == ']':
            if bool(stack) and stack[-1] == '[':
                stack.pop()
            else:
                flag = 1
                break

    if flag == 0 and a != '.' and len(stack) == 0:
        print("yes")
    elif a != '.':
        print("no")