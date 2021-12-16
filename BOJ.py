# BOJ 1662 fail
# import sys
# print(sys.getsizeof(9))
# print(sys.getsizeof("9"))

# a = input()
# a = "33(562(71(9)))"
a = "15(22)13(92(1111)42(222))" #60
# a = "15(22)13"
# a = "15(22)13(92(1111)42(222))123(1)45" #67
stack = []
board = a.split(')')
print(board)

for string in board:
    stack.append(string)

#     if c == ')':
#         word = stack.pop()
#         pre = word[:-1]
#         inor = word[-1]
#         post = string[pointer+1:]
#         q = string[:pointer]
#         stack.append(pre + int(inor) * q + post)
#     else:
#         pointer += 1
#     else:  # )가 없으면
#         stack.append(string)

