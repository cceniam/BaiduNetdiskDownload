# 第八题： 删除排序数组中的重复项

## 题目：

给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

## 思路：

### 双指针法：

1. 使用慢指针$i$和快指针$j$，
2. 当$num[i]==num[j]$时，说明出现重复元素，这是给$j++$以跳过重复项
3. 当$num[i] != num[j]$时，说明重复项结束，这时将$num[i+1]=num[j]$
4. 然后递增$i$,直到j到达数组末尾

## 代码：

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            nums[++i] = nums[j];
        }
    }
    return i + 1;
}
```

## 复杂度分析：

- 时间复杂度：$O(n)$,$n$为数组长度
- 空间复杂度：$O(1)$



## 优化：

### 思路：

- 当$num[i] != num[j]$时，有两种可能：
  1. 数组中没有重复元素，按照上面的方法，每次比较时 `nums[i]` 都不等于 `nums[j]`，这时不必重复赋值
  2. 当$num[i] != num[j]$时，说明重复项结束，这时将$num[i+1]=num[j]$

## 代码：

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            if(j-i>1){
            nums[++i] = nums[j];
            }
            else{
                ++i;
            }
        }
    }
    return i + 1;
}
```

### 复杂度分析：

- 时间复杂度：$O(n)$,$n$为数组长度
- 空间复杂度：$O(1)$

