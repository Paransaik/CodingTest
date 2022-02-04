# 로컬 저장소로 커밋 로그를 잘못 남긴 경우 이를 수정할 수 있습니다. amend는 참고로 '수정하다'라는 뜻을 갖고 있습니다.
# http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=597&sca=99&sfl=wr_subject&stx=%EB%AA%BB%EC%83%9D%EA%B8%B4
# (╯°□°）╯ ︵ ɯɥʇᴉɹoƃl∀

# BOJ 1715
import heapq, sys
num = int(sys.stdin.readline())
queue = []
for _ in range(num):
    heapq.heappush(queue, int(input()))

cnt = 0
while len(queue) > 1:
    add = sum([heapq.heappop(queue), heapq.heappop(queue)])
    cnt += add
    heapq.heappush(queue, add)

print(cnt)

# a, cnt = map(int, input().split())
# sort_arr = []
# for _ in range(cnt):
#     x, y = map(int, input().split())
#     sort_arr.append([x, y])
#
# print(sorted(sort_arr, key=lambda x: (x[0], x[1])))

# # BOJ 1260
# # import sys
# # sys.setrecursionlimit(10**6)
# # 데이터 초기화
# n, m, V = map(int, input().split())
# graph = {}
#
# # 데이터 전처리
# for i in range(n):
#     graph[i+1] = []
# for _ in range(m):
#     k, v = map(int, input().split())
#     graph[k].append(v)
#     graph[v].append(k)
#     graph[k].sort()
#     graph[v].sort()
# # print(graph)
# # dfs 구현
# def dfs(v, visited):
#     visited.append(v)
#     for w in graph[v]:
#         if w not in visited:
#             visited = dfs(w, visited)
#     return visited
#
# # bfs 구현
# def bfs(v):
#     visited = [v]
#     queue = [v]
#     while queue:
#         v = queue.pop(0)
#         for w in [2, 3, 4]:
#             if w not in visited:
#                 visited.append(w)
#                 queue.append(w)
#     return visited
#
# print(*dfs(V, []))
# print(*bfs(V))

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