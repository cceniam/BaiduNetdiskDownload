# 第十题： 实现strSTR()

## 题目：

- 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

- 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

  对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

## 思路：

- 如果needle为空则返回0
- 如果haystack为空则返回-1

- 设置快慢指针I，J指向haystack，
- 从快指针所在位置向后匹配needle字符串，
  - 匹配成功返回慢指针下标
  - 匹配失败则慢指针加一，将慢指针赋给快指针，继续进行匹配
    - 慢指针指向haystack结尾则返回-1

## 代码：


```java
class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L == 0) return 0;

    int pn = 0;
    while (pn < n - L + 1) {
      // find the position of the first needle character
      // in the haystack string
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

      // compute the max match string
      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      // if the whole needle string is found,
      // return its start position
      if (currLen == L) return pn - L;

      // otherwise, backtrack
      pn = pn - currLen + 1;
    }
    return -1;
  }
}
```

## 复杂度分析：

- 时间复杂度：$O((N-L)L)$其中$ N$ 为$ haystack $字符串的长度，$L$ 为 $needle $字符串的长度。内循环中比较字符串的复杂度为$ L$，总共需要比较 $(N - L) $次。
- 空间复杂度：$O(1)$

## 其他思路：

- 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较
 ```java
class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();

    for (int start = 0; start < n - L + 1; ++start) {
        //substring() :截取指定下标子串
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;
  }
}
 ```

- 时间复杂度：$O((N-L)L)$其中$ N$ 为$ haystack $字符串的长度，$L$ 为 $needle $字符串的长度。内循环中比较字符串的复杂度为$ L$，总共需要比较 $(N - L) $次。
- 空间复杂度：$O(1)$

### 思路三：

- 由于只会出现小写的英文字母，因此可以将字符串转化成值为 0 到 25 的整数数组： `arr[i] = (int)S.charAt(i) - (int)'a'`
- 转换公式：$h _ { 0 } = 0 \times 26 ^ { 3 } + 1 \times 26 ^ { 2 } + 2 \times 26 ^ { 1 } + 3 \times 26 ^ { 0 }$,
  - 通式：$\left. \begin{array} { c } { h _ { 0 } = c _ { 0 } a ^ { L - 1 } + c _ { 1 } a ^ { L - 2 } + \ldots + c _ { i } a ^ { L - 1 - i } + \ldots + c _ { L - 1 } a ^ { 1 } + c _ { L } a ^ { 0 } } \\ { h _ { 0 } = \sum _ { i = 1 } ^ { L - 1 } c _ { i } a ^ { L - 1 - i } } \end{array} \right.$
- 窗口滑动：计算公式：$h _ { 1 } = ( h _ { 0 } - 0 \times 26 ^ { 3 } ) \times 26 + 4 \times 26 ^ { 0 }$
  - 通式：$h _ { 1 } = ( h _ { 0 } a - c _ { 0 } a ^ { L } ) + c _ { L + 1 }$
- 可能是一个很大的数字，因此需要设置数值上限来避免溢出。设置数值上限可以用取模的方式，即用 `h % modulus` `来代替原本的哈希值。理论上，modules 应该取一个很大数，但具体应该取多大的数呢? 详见[这篇文章](<https://en.wikipedia.org/wiki/Linear_congruential_generator#Parameters_in_common_use>)对于这个问题来说$2 ^ { 31 }$就足够了。


### 算法：

- 计算子字符串 haystack.substring(0, L) 和 needle.substring(0, L) 的哈希值。 

- 从起始位置开始遍历：从第一个字符遍历到第 N - L 个字符。
  - 根据前一个哈希值计算滚动哈希。
  - 如果子字符串哈希值与 needle 字符串哈希值相等，返回滑动窗口起始位置。

- 返回 -1，这时候 haystack 字符串中不存在 needle 字符串。

### 代码;

```java
class Solution {
  // function to convert character to integer
  public int charToInt(int idx, String s) {
    return (int)s.charAt(idx) - (int)'a';
  }

  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L > n) return -1;

    // base value for the rolling hash function
    int a = 26;
    // modulus value for the rolling hash function to avoid overflow
    long modulus = (long)Math.pow(2, 31);

    // compute the hash of strings haystack[:L], needle[:L]
    long h = 0, ref_h = 0;
    for (int i = 0; i < L; ++i) {
      h = (h * a + charToInt(i, haystack)) % modulus;
      ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
    }
    if (h == ref_h) return 0;

    // const value to be used often : a**L % modulus
    long aL = 1;
    for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

    for (int start = 1; start < n - L + 1; ++start) {
      // compute rolling hash in O(1) time
      h = (h * a - charToInt(start - 1, haystack) * aL
              + charToInt(start + L - 1, haystack)) % modulus;
      if (h == ref_h) return start;
    }
    return -1;
  }
}
```

### 复杂度分析：

- 时间复杂度：$O(N)$，计算 needle 字符串的哈希值需要 $O(L)$时间，之后需要执行$ (N - L)$次循环，每次循环的计算复杂度为常数。

- 空间复杂度：$O(1)$。


