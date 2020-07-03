#  第十八题： 只出现一次的数字

## 题目：

- 给定非空整数数组
- 仅有一个元素出现一次，其余元素均出现两次
- 算法应具有线性时间复杂度

## 思路

- 异或运算
  - 相同数字异或为0
  - 任意数字与0异或为本数字
  - $a \oplus b \oplus a = b \oplus a \oplus a = b \oplus ( a \oplus a ) = b \oplus 0 = b$
- 因此，对数组中的所有元素进行异或运算，得到的数字即为只出现一次的数字

## 代码

```java
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
```

## 复杂度分析

- 时间复杂度：O（n）
- 空间复杂度 ：O（1）