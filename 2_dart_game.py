from typing import *
# 8.30. am. 21:30~

def dart_game(arr1: List[int]) -> int:
    result: int = 0
    current: List[int] = [0]

    for s in arr1:
        # if s == 'S':
        #     pass

        if s == 'D':
            pass

        if s == 'T':
            pass

        if s == '*':
            result -= current[-1]
            result += current[-1] * 2
            current.append(current[-1] * 2)

        if s == '#':
            pass

    return result

print('result', dart_game('1S2D*3T'))