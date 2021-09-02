# from typing import *
# # .
#
# def news_clustering(arr1: List[str], arr2: List[str]) -> int:
#     time: str
#
#     return time
#
# print('result', news_clustering('FRANCE', 'french'))


#
def solution(begin, target, words):
    if begin == []:
        if target == 'cog':
            return 1
        else:
            return 0
    else:
        return solution(numbers[1:], target+numbers[0]) + solution(numbers[1:], target-numbers[0])

print(solution([1,1,1,1,1], 3))