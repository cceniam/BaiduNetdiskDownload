"""
练习1：英制单位英寸和公制单位厘米互换  if语句的使用
"""

value = float(input("请输入数据大小"))
unit = input("请输入单位")
if value is not None:
    if unit == '英寸':
        value /= 2.54
    if unit == '厘米':
        value *= 2.54
    print(value)
else:
    print('数据或单位有误，请重新输入')
