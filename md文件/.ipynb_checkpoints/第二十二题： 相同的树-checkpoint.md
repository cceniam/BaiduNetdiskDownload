# 第二十二题： 相同的树

## 题目：

- 给定两个二叉树
- 检验二叉树是否相同
  - 相同条件一：结构相同
  - 相同条件二：节点的值相同

## 思路：递归

- 结束条件：相同或不同
  - 节点结构
  - 节点值
- 递归左子树
- 递归右子树

## 算法：

```python

class Solution:
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """    
        # p and q are both None
        if not p and not q:
            return True
        # one of p and q is None
        if not q or not p:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.right, q.right) and \
               self.isSameTree(p.left, q.left)

作者：LeetCode
链接：https://leetcode-cn.com/problems/same-tree/solution/xiang-tong-de-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

- 时间复杂度：O(n),n为树的节点
- 空间复杂度：$O(log(n))$,最坏情况下$O(n)$