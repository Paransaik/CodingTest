from typing import *
# 8.30. pm. 21:30~23:00

def dart_game(arr1: List[int]) -> int:
    num: List[int] = [0]

    for s in arr1:
        if s == 'S':
            num.append(0)
            pass
        elif s == 'D':
            num[-1] = num[-1] ** 2
            num.append(0)
        elif s == 'T':
            num[-1] = num[-1] ** 3
            num.append(0)
        elif s == '*':
            num[-2] *= 2
            if len(num) > 2:
                num[-3] *= 2
        elif s == '#':
            num[-2] *= -1
        else:
            num[-1] = num[-1] * 10 + int(s)
        # print(num)
    return sum(num)

print('result', dart_game('1S2D*3T'))  # 27
print('result', dart_game('1D2S#10S'))  # 9
print('result', dart_game('1D2S0T'))  # 3
print('result', dart_game('1S*2T*3S'))  # 23
print('result', dart_game('1D#2S*3S'))  # 5
print('result', dart_game('1T2D3D#'))  # -4
print('result', dart_game('1D2S3T*'))  # 59