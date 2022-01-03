# BOJ 6504
fibo = [1, 2]
for i in range(2, 23):
    fibo.append(fibo[i-1] + fibo[i-2])

num = int(input())
for j in range(num):
    kilo = int(input())
    count = 22
    mile = 0
    while count > 0:
        if kilo >= fibo[count]:
            kilo -= fibo[count]
            mile += fibo[count-1]
        count -= 1
    print(mile)


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

# BOJ 6571
# import sys
#
# while True:
#     fibo_arr = [1, 2]
#     flag = -1
#     a, b = map(int, sys.stdin.readline().split())
#
#     if a == 0 and b == 0:
#         break
#
#     if a == 1 and b == 1:
#         print(1)
#     else:
#         i = 2
#         while fibo_arr[i - 1] + fibo_arr[i - 2] <= b:
#             fibo_arr.append(fibo_arr[i - 1] + fibo_arr[i - 2])
#             i += 1
#
#         for j in range(len(fibo_arr)):
#             if fibo_arr[j] >= a:
#                 flag = j
#                 print(len(fibo_arr[j:]))
#                 break
#
#         if flag == -1:
#             print(0)
#     print(fibo_arr)
'''
3493827783278132472795118534792436411824758913075845874536712506137457934145864669574566460569796217 5232725881766318663707145706630526825549417008984358815494640501889902249884614854823774085327870926
3669394456101013134813511923950571346407839477093107591022102825977912183250144481696508875379795373 9227040812969132398311105306880751811433118226169691080171033425546019455326744298957968802075192551
183821317441271587009504180648092048504719884026941734414026969655488220301640801594907377988772555 9985426008211197715118511469235825322765978872830551732487276955300577348805449948574411009635137849
350328490463123653111485373330519454596416947915947019001254902775400300883251338711339873031464106 5992105262377639630254443140177962733345604369604143274714485110366469391947040273784319109997306670
1409590937758996923768899913541862048060008338753687785265736886433592624125526045970624453099471881 2906564956067975730039349828712861301549025523575420093745752904114202577791569504500157426677254493
3517110245324146068842402161183875461168651334829791558177580676435786005932362276505761229827922750 5725830053363248159101044818148569148827312981571956495520638767592851315589317880689955312553832511
624981406670098237145733852700123629943006517822102283477806457799288989450655730325012060043349364 3969526005862664772958870442388189147470976128404645476599563025895981714971724110065260486334906310
8115498315363272481938698922867447447540495095084763723330300442151169721244847425766854670314322833 9977968882488537245754962566540713192411424458276765503698623299001633802642972597695783509498317156
7120173264166200447341031676879822985911048856417796988186888833122877410146972014072371597829804869 8144503087348566694885604318751717790167543368468531493118313793412417656482722843319153050694310553
4369415704822180569005477006361489554316455451765125313894589090270932641843054782016142990133724688 8123609269705723215191701477768805636973046372374980500772572981827610126522689500678231584600510212
'''

