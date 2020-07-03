# 第二十五题：Binary Tree Level Order Traversal II

## 题目：

给定一个二叉树， 按从叶子节点所在层到根节点所在层遍历，逐层从左向右遍历

## 思路

- 从根节点向叶节点遍历
- 将遍历结果逆序

## 代码

```python
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        ans = [root]
        target = []
        while ans:
            tmp,n = [],len(ans)
            for i in range(n):
                r = ans.pop(0)
                tmp.append(r.val)
                if r.left:
                    ans.append(r.left)
                if r.right:
                    ans.append(r.right)
            target.append(tmp)
        return target[::-1]

作者：pandawakaka
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/er-cha-shu-de-ceng-ci-bian-li-iipython3ceng-ci-bia/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

- 时间复杂度：O(n)
- 空间复杂度：最糟糕情况下退化为单链表，此时复杂度O(n)