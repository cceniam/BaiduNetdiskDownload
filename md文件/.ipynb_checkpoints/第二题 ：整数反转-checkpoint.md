# 第二题 ：整数反转

## 题目：

- 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
- 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

## 思路：

- 标签：数学

- 本题如果不考虑溢出问题，是非常简单的。解决溢出问题有两个思路，第一个思路是通过字符串转换加try catch的方式来解决，第二个思路就是通过数学计算来解决。

- 由于字符串转换的效率较低且使用较多库函数，所以解题方案不考虑该方法，而是通过数学计算来解决。
  通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
  溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop，ans=ans*10+pop。

- ==从ans * 10 + pop > MAX_VALUE这个溢出条件来看==
  ==当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出==
  ==当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数==

- ==从ans * 10 + pop < MIN_VALUE这个溢出条件来看==
  ==当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出==
  ==当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位==

  ## 代码

  ```java
  class Solution {
      public int reverse(int x) {
          int ans = 0;
          while (x != 0) {
              int pop = x % 10;
              if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                  return 0;
              if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                  return 0;
              ans = ans * 10 + pop;
              x /= 10;
          }
          return ans;
      }
  }
  ```

  ### 逆序函数(==不进行溢出判断==)

  ```
  public int reverse(int x) {
      int ans = 0;
      while(x!=0){
          int pop = x % 10;
          ans=ans*10+pop;
          x/=10;
      }
      return ans;
  }
  ```

  ## 复杂度分析

  - 时间复杂度： O($$ \log_{10}(x)$$),x中有$$log_{10}(x)$$位数字
  - 空间复杂度： O(1)



## 讨论：

- 我觉得官方的代码有多余，因为int类型最大数和最小数开头的数字只能是1或2，所以如果有最后一次循环的话，pop的值一定为1或2，所以(rev == INT_MAX / 10 && pop > 7)和(rev == INT_MIN / 10 && pop < -8)判断可以省略。本人已测。
- 在不知道最大正数是2147683647的情况，可以用数学归纳法知道2的31次方个位数是8，从而最大正数 INT_MAX 个位数是7。但是怎么知道 INT_MAX最大位是2？换句话说如果题目把整数范围限定在-2^21,2^21-1怎么知道开头数字是多少
- 确实，如果已知int类型范围的开头数字，这样还能省去判断pop值的步骤，但如果换为其他类型的还是需要像官方这样判断pop的，只能说你这样是这种题型的最优解了

