# from typing import *
# # .
#
# def news_clustering(arr1: List[str], arr2: List[str]) -> int:
#     time: str
#
#     return time
#
# print('result', news_clustering('FRANCE', 'french'))


def solution(numbers, target):
    answer = 0
    result = []
    prev_emulate = []

    def dfs(nums):
        # 종료 조건
        if len(nums) == 0:
            result.append(prev_emulate[:])

        # 반복 조건
        for e in nums:
            next_emulate = nums[:]
            next_emulate.remove(e)

            prev_emulate.append(e)
            dfs(next_emulate)
            prev_emulate.pop()

    dfs(numbers)
    print(result)
    return answer

print('result', solution([1,2,3,4,5], 3))
