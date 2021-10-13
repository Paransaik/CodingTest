def solution(n, computers):
    def dfs(i, j):
        if i < 0 or i >= n or j < 0 or j >= n or computers[i][j] != 1 or i == j:
            return

        computers[i][j] = 0

        dfs(j, i)

    answer = 0
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                dfs(i, j)
                answer += 1
    return answer
print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))  # 2
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))  # 1