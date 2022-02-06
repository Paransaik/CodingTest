from typing import *
# 8.30. am. 2:00~2:35
# 8.30. pm. 13:45~14:45
# 8.30. pm. 16:30~17:00

def secret_map(n: int, arr1: List[int], arr2: List[int]) -> List[int]:
    result: List[int] = []

    for i in range(n):
        result.append(bin(arr1[i] | arr2[i])[2:]
            .zfill(n)
            .replace('1', '#')
            .replace('0', ' '))

    return result

print('result=', secret_map(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))
print('result=', secret_map(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10]))
# n = 5
# arr1: List[int] = [9, 20, 28, 18, 11]
# arr2: List[int] = [30, 1, 21, 17, 28]
# ["#####", "# # #", "### #", "# ##", "#####"]
