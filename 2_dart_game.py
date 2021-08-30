from typing import *
# 8.30. am. 21:30~

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
            num[-1] *= -1
        else:
            num[-1] = num[-1] * 10 + int(s)

        print(num)
    return sum(num)

print('result', dart_game('1S2D*3T'))