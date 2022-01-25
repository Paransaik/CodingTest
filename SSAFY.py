'''
# 1
def solution(scores):
    scores = list(map(list, zip(*scores)))
    grade = []
    index = 0
    for score in scores:
        maxs, mins = max(score), min(score)
        if score[index] == maxs or score[index] == mins:
            if score.count(score[index]) == 1:
                score.remove(score[index])

        grade.append(sum(score) // len(score))
        index += 1

    for g in grade:
        if g >= 90: print('A', end='')
        elif g >= 80: print('B', end='')
        elif g >= 70: print('C', end='')
        elif g >= 50: print('D', end='')
        else: print('F', end='')
    print()

solution([
      [100, 90, 98, 88, 65],
      [50, 45, 99, 85, 77],
      [47, 88, 95, 80, 67],
      [61, 57, 100, 80, 65],
      [24, 90, 94, 75, 65]])
solution([
      [50, 90],
      [50, 87]])
solution([
      [70, 49, 90],
      [68, 50, 38],
      [73, 31, 100]])
'''

'''
# 2
def solution(sentence, keyeord, skips):
    lst = list(sentence)
    index = 0
    s_index = 0
    for i in range(len(skips)):
        index %= len(keyeord)
        search = ''.join(lst[s_index: s_index+skips[i]]).find(keyeord[index])
        if search > -1:  # 가다가 자기 문자를 찾으면 그 자리에 삽입
            lst.insert(s_index+search, keyeord[index])
            s_index += search + 1
        else:
            if len(lst) < s_index + skips[i]:
                break
            s_index += skips[i]
            lst.insert(s_index, keyeord[index])
        s_index += 1
        index += 1
    print(''.join(lst))

solution("i love coding", "mask", [0, 0, 3, 2, 3, 4])
solution("i love coding", "mode", [0, 10])
solution("abcde fghi", "xyz", [10, 0, 1])
solution("encrypt this sentence", "something", [0, 1, 3, 2, 1, 2, 0, 3, 0, 2, 4, 1, 3])
'''

'''
# 3번
from itertools import combinations
def solution(prices, d, k):
    result = 0
    if max(prices)-min(prices) <= d:
        result = sum(prices)//len(prices)  # 1번 case
    else:
        copy_prices = prices[:]
        copy_prices.remove(max(prices))
        copy_prices.remove(min(prices))
        if max(copy_prices) - min(copy_prices) <= d:  # 2번 case
            result = sum(copy_prices) // len(copy_prices)
        else:  # 3번 case
            flag = 0
            lst = sorted(list(combinations(prices, k)), key=lambda x: max(x) - min(x))
            for l in lst:
                if max(l) - min(l) <= d:
                    result = sum(l) // len(l)
                    flag = 1
                    break
            if flag == 0:
                if len(prices) % 2 == 1:
                    result = sorted(prices)[len(prices)//2]
                else:
                    result = min(sorted(prices)[len(prices)//2-1], sorted(prices)[len(prices)//2])
    print(result)

solution([4, 5, 6, 7, 8], 4, 3)
solution([4, 5, 6, 7, 8], 2, 1)
solution([4, 5, 6, 7, 8], 1, 2)
solution([8, 4, 5, 7, 6], 1, 3)
solution([1, 8, 1, 8, 1, 8], 4, 1)
'''

