class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        
        def dfs(node):
            if not node:
                return
            
            dfs(node.left)       #left subtree
            result.append(node.val) #current node
            dfs(node.right)      #right subtree
            
        dfs(root)
        return result