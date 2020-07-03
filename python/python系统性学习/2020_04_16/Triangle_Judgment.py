"""
题目三： 判断三边是否构成三角形
Determine whether three sides form a triangle
练习内容： 分支结构
"""
a = float(input("please input the frist value"))
b = float(input("please input the second value"))
c = float(input("please input the third value"))

if a + b > c and a + c > b and b + c > a:
    print('周长: %f' % (a + b + c))
    p = (a + b + c) / 2
    area = (p * (p - a) * (p - b) * (p - c)) ** 0.5
    print('面积: %f' % area)
else:
    print('不能构成三角形')
