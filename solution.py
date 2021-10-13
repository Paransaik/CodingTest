# BOJ 1662
a = "33(562(71(9)))"
result = ""
# 스택
board = list(a)

def recus(S):
    if len(S) == 0:
        return result

    for i, s in enumerate(board):
        if s == '(':
            # push [:i-1]
            Str = board[i+1:]
            recus(Str)
        elif s == ')':
            # pop = l
            # result = l[:-1] + l[-1] * board[:i-1]
            return result

print(recus(a))

#66	141	53.226%
#67	142	53.600%
#67	143	53.600%