"""
华氏温度转换为摄氏温度
"""

# f = int(input("请输入华氏温度"))
# print('华氏温度%d对应的摄氏温度为%d' % (f, (f - 32) / 1.8))

"""
缺点： 输入智能为整数
改进： 输入可以为浮点数
"""

f = float(input("请输入华氏温度"))
print('华氏温度%.1f对应的摄氏温度为%.1f' % (f, (f - 32) / 1.8))

