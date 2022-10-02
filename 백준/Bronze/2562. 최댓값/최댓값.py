max,idx = 0, 0
for i in range(9):
    n = int(input())
    if n > max:
        max = n
        idx = i+1
print(max, idx)