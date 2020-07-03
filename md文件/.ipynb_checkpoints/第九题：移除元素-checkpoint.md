# 第九题：移除元素

## 题目：

- 给定数组$$nums$$和一个值val
- 原地移除数组中所有值等于val的元素
- 元素顺序可以更改

## 思路：双指针

1. 给定长短指针$i,j$,同时指向首元素
2. 当长指针指向元素值不为val时，将长指针指向元素放入短指针指向元素。
3. 短直针++
4. 遍历整个数组，返回短直针+1

##  代码：

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int j =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val&&i-j>1)
            nums[j++]=nums[i];
        }
        return j;
    }
}
```

## 复杂度分析：

- 时间复杂度： $O(n)$,$n​$为数组长度。
- 空间复杂度$O(1)$。

## 其他解法：

```java
class Solution {
   public int removeElement(int[] nums, int val) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == val) { // 如果nums[i]=val, 则相当于把nums[i]的值和最后一个元素交换，然后len--
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            } 
        }
        return len;
    }
}
```

- 缺点：删除val后的数组元素顺序被逆转。
- ==在不考虑顺序的情况下，此方法更加合适，尤其是在元素中与val相等的值较少的情况下==`
