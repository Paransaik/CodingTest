def nonspace(num):
    for i in range(num):
        print('*', end='')

def space(num):
    for i in range(num):
        print(' ', end='')

def big_space(num):
    for i in range(num//3):
        for j in range(num//3):

def tree(num):
    if num == 3:
        for i in range(num):
            for j in range(num):
                if i % 3 == 1 and j % 3 == 1:
                    space(num//3)
                else:
                    nonspace(num//3)
            print()
    else:
        for i in range(num):
            for j in range(num):
                if i % 3 == 1 and j % 3 == 1:
                    space(num//3)
                else:
                    tree(num//3)
            print()

a = 9
tree(a)
# for i in range(a//3):
#     for j in range(a//3):
#         if i % 3 == 1 and j % 3 == 1:
#             pass
#         else:
#             tree(a//3)