# 로컬 저장소로 커밋 로그를 잘못 남긴 경우 이를 수정할 수 있습니다. amend는 참고로 '수정하다'라는 뜻을 갖고 있습니다.
# $ git commit --amend
# http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=597&sca=99&sfl=wr_subject&stx=%EB%AA%BB%EC%83%9D%EA%B8%B4
# (╯°□°）╯ ︵ ɯɥʇᴉɹoƃl∀

# BOJ 1018
m, n = map(int, input().split())
board = [list(input()) for _ in range(m)]
cnn = [[0 for _ in range(n-7)] for _ in range(m-7)]

def filling(x, y, color):
    cnt = 0
    toggle = ord(color)
    copy_board = []
    for b in board:
        copy_board.append(b[:])
    for i in range(x, x+8):
        for j in range(y, y+8):
            copy_board[i][j] = chr(toggle)
            toggle ^= 21
            if copy_board[i][j] != board[i][j]:
                cnt += 1
        toggle ^= 21
    return cnt

for c_i in range(m-7):
    for c_j in range(n-7):
        cnn[c_i][c_j] = min(filling(c_i, c_j, 'W'), filling(c_i, c_j, 'B'))

print(min(list(map(lambda x: min(x), cnn))))
'''
# a = "10342(76)"  # 8
# a = "0(0)"  # 0
# a = "33(562(71(9)))"  # 19
# a = "3(3(3(2(2)2(1))))"  # 108
# a = "123(3)"  # 5
# a = "123"
# a = "1()66(5)"  # 7
# a = "9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(111))))))))))))))))))))))))"
# a = 3(5)  # 3
# a = 3(5)1  # 4
# a = 3(5(1))  # 15
# a = 3(5(1))1  # 16
# a = 4(3(5(1)))  # 60
# a = 4(3(5(1)))1  # 61
# a = 15(22)13(92(1111)42(222))  #60
# a = 15(22)13(92(1111)42(222))123(1)45  # 67
# '''
# '''
# for string in board:
#     stack.append(string)
# while len(stack) != 1:
#     if stack[-1].find(')') > -1:
#         print(stack)
#         word1 = stack.pop()
#         cursor = 0
#         for i in range(len(word1)):
#             if word1[cursor] == ')':
#                 b = word1[:cursor]  # b 는 )앞 숫자들
#                 break
#             cursor += 1
#         word2 = stack.pop()
#         pre = word2[:-1]  # 곱할 숫자를 제외한 수
#         post = int(word2[-1])  # 곱할 숫자
#
#         stack.append(str(pre + (post * b)) + word1[cursor+1:])
#
# print(len(stack[0]))
'''
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
'''