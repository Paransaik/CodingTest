# def pibo(n):
#     if n == 0:
#         return 0
#     if n == 1:
#         return 1
#     return pibo(n-1) +pibo(n-2)
# a = int(input())
# print(pibo(a))
# 72MS 62, 133 53.913%

# a = int(input())
# b = [0, 1]
# for i in range(a):
#     b.append(b[-1]+b[-2])
# print(b[-2])
# 68MS 63 134 53.846%
# 68MS 64 135 54.237%
# 88MS 65 136 54.622%

# 공백 출력 함수
def non_space(num):
    for i in range(num//3):
        for j in range(num//3):
            print('*', end='')

def space(num):
    for i in range(num//3):
        for j in range(num//3):
            print(' ', end='')

def thre(num):
    if num == 3:
        for i in range(num):
            for j in range(num):
                if i % 3 == 1 and j % 3 == 1:
                    space(num)
                else:
                    non_space(num)
    else:
        for i in range(num):
            for j in range(num):
                thre(num//3)
            print()
            
print(thre(3))