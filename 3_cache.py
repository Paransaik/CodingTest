from typing import *
import collections
# 8.31. am. 11:00~12:00

def cache(cacheSize: int, cities: List[str]) -> int:
    time: int = 0
    caches = collections.deque(maxlen=cacheSize)

    for c in cities:
        c = c.lower()
        if c in caches:
            caches.remove(c)
            caches.append(c)
            time += 1
        else:
            caches.append(c)
            time += 5

    return time

print('result', cache(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))  # 50
print('result', cache(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]))  # 21
print('result', cache(2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]))  # 60
print('result', cache(5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]))  # 52
print('result', cache(2, ["Jeju", "Pangyo", "NewYork", "newyork"]))  # 16
print('result', cache(0, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))  # 25
