"""
类似于 int float 这种类型，没有可以访问的内部结构
类似于 字符串 （str） 是结构化非标量类型 有一系列的属性方法
今天学习 list 列表 ：
"""

# list 有序 每个值可通过索引标识
import sys

list1 = [1, 2, 3, 4, 5, 6]
print(list1)

# 乘号表示重复的次数
list2 = ['hello'] * 3
print(list2)
list3 = list1 * 3
print(list3)

# len() 计算list长度
print(len(list3))

# 通过enumerate函数处理列表之后再遍历可以同时获得元素索引和值
for we, elem in enumerate(list3):
    print(we, elem)

# 添加元素
list3.append(30)

print(list3)

# 删除元素
list3.remove(3)

# 从指定位置删除元素
list3.pop(4)

# 清空列表
list3.clear()

"""
切片操作
"""
fruits = ['grape', 'apple', 'strawberry', 'waxberry']
fruits += ['pitaya', 'pear', 'mango']
# 列表切片
fruits2 = fruits[1:4]
print(fruits2)  # apple strawberry waxberry
# 可以通过完整切片操作来复制列表
fruits3 = fruits[:]
print(fruits3)  # ['grape', 'apple', 'strawberry', 'waxberry', 'pitaya', 'pear', 'mango']
fruits4 = fruits[-3:-1]
print(fruits4)  # ['pitaya', 'pear']
# 可以通过反向切片操作来获得倒转后的列表的拷贝
fruits5 = fruits[::-1]
print(fruits5)  # ['mango', 'pear', 'pitaya', 'waxberry', 'strawberry', 'apple', 'grape']

# 合并列表
list3.extend(list1)
print(list3)

# 列表排序
list3.sort(reverse=True)
sorted(list3)

#############################################################################

# 生成式和生成器
f = [x + y for x in 'ABCDE' for y in '1234567']
print(f)
f = [x for x in range(1, 10)]
print(f)
f = [x + y for x in 'ABCDE' for y in '1234567']
print(f)
# 用列表的生成表达式语法创建列表容器
# 用这种语法创建列表之后元素已经准备就绪所以需要耗费较多的内存空间
f = [x ** 2 for x in range(1, 1000)]
print(sys.getsizeof(f))  # 查看对象占用内存的字节数
print(f)
# 请注意下面的代码创建的不是一个列表而是一个生成器对象
# 通过生成器可以获取到数据但它不占用额外的空间存储数据
# 每次需要数据的时候就通过内部的运算得到数据(需要花费额外的时间)
f = (x ** 2 for x in range(1, 1000))
print(sys.getsizeof(f))  # 相比生成式生成器不占用存储数据的空间
print(f)
for val in f:
    print(val)
