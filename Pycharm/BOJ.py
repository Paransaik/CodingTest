# 로컬 저장소로 커밋 로그를 잘못 남긴 경우 이를 수정할 수 있습니다. amend는 참고로 '수정하다'라는 뜻을 갖고 있습니다.
# (╯°□°）╯ ︵ ɯɥʇᴉɹoƃl∀
a, b = map(int, input().split())
print(abs(a-b))

# import time start = time.time() # 시작시간 # 코드 작성 end = time.time() # 종료시간 print("time :", end - start) # 실핼시간 = 종료시간 - 시작시간
# # BOJ 2309
# from itertools import combinations
# lst = sorted([x for x in list(combinations([int(input()) for _ in range(9)], 7)) if sum(x) == 100])

# from itertools import combinations
#
# def solution(number, k):
#     ln = len(number)
#     lst = list(number)
#     answer = max(list(map(lambda x: ''.join(x), combinations(lst, ln-k))))
#     return answer
#
# print(solution("1924", 2))
# print(solution("1231234", 3))
# print(solution("4177252841"	, 4))

# 라인 5번
# import heapq
# pq = []
# def solution(abilities, k):
#     answer = 0
#     if len(abilities) % 2 == 1: abilities.append(0)
#     abilities = sorted(abilities)[::-1]
#     you = []
#     me = []
#
#     for i in range(len(abilities)):
#         if i % 2 == 0: you.append(abilities[i])
#         else: me.append(abilities[i])
#
#     # 같은 경우 answer에 넣고, 다른 경우 pq에 넣어 k개수만큼 뽑기 위한 전처리
#     for i, (y, m) in enumerate(zip(you, me)):
#         if y == m: answer += m
#         else: heapq.heappush(pq, (m-y, i))
#
#     # k개수 만큼 pq에서 pop함
#     for _ in range(k): answer += you[heapq.heappop(pq)[1]]
#     # 남은 원소 다 더 함
#     while pq: answer += me[heapq.heappop(pq)[1]]
#
#     return answer
# print(solution([2, 8, 3, 6, 1, 9, 1, 9], 2))
# print(solution([7, 6, 8, 9, 10], 1))


# 라인 1번
# log_key = ["team_name", "application_name", "error_level", "message"]
# def checked_log(arrs):
#     for i, arr in enumerate(arrs):
#         for lo in arr:
#             ck = ord(lo)
#             if ck < 32 or (32 < ck and ck < 65) or (ck > 90 and ck < 95) or ck == 96 or ck > 122:
#                 return False
#         if i == 0:
#             if arr != log_key[0]: return False
#         if 0 < i and i < 4:
#             ar = arr.split(" ")
#             if(len(ar)) != 2: return False
#             if ar[1] == log_key[i]: # 키 정상 확인
#                 if ar[0].upper() or ar[0].lower(): # 대문자, 소문자 확인
#                     if ar[1] != log_key[i]: return False
#                 else: return False
#             else: return False
#         if i > 4: return False
#     return True
#
# def solution(logs):
#     answer = 0
#     for log in logs:
#         if len(log) >= 100:
#             answer += 1
#             continue
#         lst = log.split(" : ")
#         if not checked_log(lst):
#             answer += 1
#     return answer

# print(solution(["team_name : recommend application_name : recommend error_level : info message : RecommendSucces11",
#                 "team_name : recommend application_name : recommend error_level : info message : Success!"]))


# print(solution(["team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange",
#                 "no such file or directory",
#                 "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11",
#                 "team_name : recommend application_name : recommend error_level : info message : Success!",
#                 "   team_name : db application_name : dbtest error_level : info message : test",
#                 "team_name     : db application_name : dbtest error_level : info message : test",
#                 "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"])) #

# def solution(arr, brr):
#     answer = -1
#     for i, ar in enumerate(arr):
#         arr
#     return answer
#
#
# print(solution([3, 7, 2, 4], [4, 5, 5, 2]))













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
