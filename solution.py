# BOJ 2304
x = int(input())
board = [0 for i in range(1001)]
for _ in range(x):
    a, b = map(int, input().split())
    board[a] = b

volume = 0
left, right = 0, 1000
left_max, right_max = board[left], board[right]

while left < right:
    left_max, right_max = max(left_max, board[left]), max(right_max, board[right])

    if left_max <= right_max:
        volume += left_max
        left += 1
    else:
        volume += right_max
        right -= 1

volume += board[left]
print(volume)

# BOJ 14719