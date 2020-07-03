"""
输入一个整数，判断他是不是素数
"""

"""
开根号法：从2到sqrt(n)均整除判断，时间复杂度O(sqrt(n))
原因：素数是因子为1和本身， 如果数c不是素数，则还有其他因子，其中的因子，
假如为a,b.其中必有一个大于sqrt(c) ，
一个小于sqrt(c) 。所以m必有一个小于或等于其平方根的因数，
那么验证素数时就只需要验证到其平方根就可以了。

即一个合数一定含有小于它平方根的质因子
"""
from math import  sqrt
num = int(input("please input the number :"))
is_pri = True

for number in range(2, int(sqrt(num) + 1)):
    if num % number == 0:
        is_pri = False
if is_pri:
    print("%d is prime" % num)
else:
    print("%s is not the prime" % num)


