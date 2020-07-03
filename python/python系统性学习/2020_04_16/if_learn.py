"""
Python中没有用花括号来构造代码块而是使用了缩进的方式来表示代码的层次结构，
如果if条件成立的情况下需要执行多条语句，只要保持多条语句具有相同的缩进就可以了。
换句话说连续的代码如果又保持了相同的缩进那么它们属于同一个代码块，相当于是一个执行的整体。
缩进可以使用任意数量的空格，但通常使用4个空格，
建议大家不要使用制表键或者设置你的代码编辑工具自动将制表键变成4个空格。
"""

# 练习1：英制单位英寸与公制单位厘米互换。
# 一英尺=2.54厘米

value = float(input("input the value :"))
unit = input("input the unit:")

if value is not None and unit is not None:
    if unit == '英尺':
        print("%.2f厘米" % (value / 2.54))
    elif unit == '厘米':
        print("%.2f英尺" % (value * 2.54))
    else:
        print("please input the correct vlaue and unit")
