# 로컬 저장소로 커밋 로그를 잘못 남긴 경우 이를 수정할 수 있습니다. amend는 참고로 '수정하다'라는 뜻을 갖고 있습니다.
# (╯°□°）╯ ︵ ɯɥʇᴉɹoƃl∀
# 골드5일 때: 골드4~5 8점, 실버1 6점(37), 실버2 6점(31), 실버4 3점(28->25), 실버5 4...?(21)

# https://programmers.co.kr/learn/courses/30/lessons/72411?language=python3
# 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼
from itertools import combinations
from collections import Counter
def solution(orders, course):
    result = []
    para = []
    for order in orders:
        lst = list(order)
        for cou in course:
            result += list(map(lambda x: ''.join(sorted(x)), list(combinations(lst, cou))))

    answer = Counter(result)
    answer = sorted(answer.items(), key=lambda x: (len(x[0]), -x[1]))

    for cou in course:
        lst = dict()
        for i in range(1, len(orders)+1):
            lst[i] = []
        for s, cnt in answer:
            if len(s) == cou:
                lst[cnt].append(s)

        for i in range(1, len(orders)+1):
            if len(lst[i]) == 0:
                del lst[i]
        if lst:
            pa = sorted(lst.items())[::-1][0]
            if pa[0] > 1:
                para += pa[1]

    return sorted(para)

# print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]))
# print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]))
# print(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]))
# print(solution(["ABCDE", "AB", "CDAB", "ABDE", "XABYZ", "ABXYZ", "ABCD", "ABCDE", "ABCDE", "ABCDE", "AB", "AB", "AB", "AB", "AB", "AB", "AB", "AB", "AB", "AB"], [2]))

'''
[N,M],c=eval('map(int,input().split()),'*2);from itertools import*;print(max(i for i in map(sum,combinations(c,3))if i<=M))
'''
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