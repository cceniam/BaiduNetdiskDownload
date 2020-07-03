# 第十九题: x的平方根

## 题目：

- 实现`int sqrt()`函数
- 结果只保留整数部分

## 思路一：牛顿法

- ![1590200151691](C:\Users\12876\AppData\Roaming\Typora\typora-user-images\1590200151691.png)

- ![1590200230596](C:\Users\12876\AppData\Roaming\Typora\typora-user-images\1590200230596.png)

## 代码：

```java
class Soulation{
    public int mysqrt(int x){
        if(x) = 0
            return 0;
        
        double c = x,x0 = x;
        whlie(true){
            double xi =(0.5*(x0+c/x0));
            if(Math.abs(xi-x0)<1e-7){
                break;
            }
            x0=xi;
        }
        return (int)x0;
    }
}
```
- 时间复杂度O($logx$)
- 空间复杂度O(1)

## 思路二：二分查找

- ![1590201532712](C:\Users\12876\AppData\Roaming\Typora\typora-user-images\1590201532712.png)

## 代码：

```python
class Solution:
    def mySqrt(self, x: int) -> int:
        l, r, ans = 0, x, -1
        while l <= r:
            mid = (l + r) // 2
            if mid * mid <= x:
                ans = mid
                l = mid + 1
            else:
                r = mid - 1
        return ans
```

- 时间复杂度$O(log x)$ 比牛顿法稍慢，因为牛顿法是二次收敛，较二分查找较快
- 空间复杂度$O(1)$