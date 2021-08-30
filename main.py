from typing import *
# 8.30. am. 2:00~2:35
# 8.30. pm. 1:45~2:45
#

def secret_map(n: int, arr1: List[int], arr2: List[int]) -> List[int]:
    arr1_to_binary: List[int] = []
    arr2_to_binary: List[int] = []

    arr1_string: List[str] = []
    arr2_string: List[str] = []

    print(n)
    print(arr1)
    print(arr2)

    result: List[int] = []

    # n 값에 대한 예외 처리
    if n > 16 or 1 > n:
        False

    # 2진법으로 변환
    for i in range(n):
        arr1_str: List[int] = []
        arr2_str: List[int] = []

        while arr1[i] > 0:  # 문자열이 0이 될 때 가지
            arr1_str.append(arr1[i] % 2)
            arr1[i] = arr1[i] // 2  # 현재 수를 계속 2로 나눈 뒤 자기 자신으로 반환

        while arr2[i] > 0:  # 문자열이 0이 될 때 가지
            arr2_str.append(arr2[i] % 2)
            arr2[i] = arr2[i] // 2

        for _ in range(n - len(arr1_str)):
            arr1_str.append(0)

        for _ in range(n - len(arr2_str)):
            arr2_str.append(0)

        arr1_string.append("".join(map(str, arr1_str[::-1])))
        arr2_string.append("".join(map(str, arr2_str[::-1])))

    for i in range(n):
        result.append(str(int(arr1_string[i]) + int(arr2_string[i])))

    for i in range(n):
        result[i].replace('2', '1')
    # print(arr1_str[1])
    #     # 두 arr 를 더함
    #     result[i].append(arr1_to_binary[i] | arr2_to_binary[i])
    #
    #     # '01001' -> '.#..#' 변환
    #     result[i].replace('1', '#')
    #     result[i].replace('0', ' ')

    return result

print('result=', secret_map(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))

# n = 5
# arr1: List[int] = [9, 20, 28, 18, 11]
# arr2: List[int] = [30, 1, 21, 17, 28]
# ["#####", "# # #", "### #", "# ##", "#####"]
