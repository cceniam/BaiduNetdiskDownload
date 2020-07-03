"""
输入两个正整数计算它们的最大公约数和最小公倍数
"""

x = int(input("input x :"))
y = int(input("input y :"))

for num in range(min(x, y), 1, -1):
    if x % num == 0 and y % num == 0:
        print('%d和%d的最大公约数是%d' % (x, y, num))
        print('%d和%d的最小公倍数是%d' % (x, y, x * y // num))
        break
