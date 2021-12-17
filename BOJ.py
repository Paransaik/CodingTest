# BOJ 1662 fail

a = "15(22)13(92(1111)42(222))" #60
# a = "15(22)13(92(1111)42(222))123(1)45" #67

a = input()
board = a.split('(')
stack = []
for string in board:
    stack.append(string)

while len(stack) != 1:
    if stack[-1].find(')') > 0:
        word1 = stack.pop()
        cursor = 0
        for i in range(len(word1)):
            if word1[cursor] == ')':
                b = word1[:cursor]
                print(b)
                print(stack)
                break
            cursor += 1

        word2 = stack.pop()
        pre = word2[:-1]
        post = int(word2[-1])
        stack.append(pre + ((post * b) + word1[cursor+1:]))
        print(stack)

print(len(stack[0]))