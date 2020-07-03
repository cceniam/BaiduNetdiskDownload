# 二十三题： 对称二叉树

## 题目：

- 给定二叉树，确定其是否镜像对称
- 使用递归和迭代两种方法

## 思路一：递归

- 如果一个树左右对称，则这个数的左右子树是镜像的
- 两树互为镜像的条件
  - 根节点的val相等
  - 每个树的左子树与另一树的右子树镜像

##  代码

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        if not root:
            return True
        def dfs(left,right):
            if (left == None and right == None):
                return True
            if (left == None or right == None):
                return False
            if left.val!=right.val:
                return False
            return dfs(left.left,right.right) and \
            dfs(left.right,right.left)
        return dfs(root.left,root.right)
        
```

- 时间复杂度：O(n),n为树中结点的总数，因为遍历了整个树
- 空间复杂度： O(n),调用递归的深度受树的高度限制，最糟糕情况下树为线性高度为n，

## 思路二： 迭代

- 除了递归的方法外，我们也可以利用队列进行迭代。队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。

## 代码：

```java
public boolean isSymmetric(TreeNode root){
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while(!q.isEmpty()){
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
```

- 时间复杂度：O(n),n为结点的总数，因为遍历了整个树
- 空间复杂度： O(n)，搜索队列需要额外空间，最糟糕情况下应向队列中插入n个节点