/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

 //Moris Traversal
class Solution {
    TreeNode* first = nullptr;
    TreeNode* second = nullptr;
    TreeNode* prev = nullptr;

public:
    void recoverTree(TreeNode* root) {
        TreeNode* curr = root;
        
        while (curr) {
            if (!curr->left) {
                
                process(curr);
                curr = curr->right;
            } else {
                // Find the inorder predecessor
                TreeNode* pre = curr->left;
                while (pre->right && pre->right != curr) {
                    pre = pre->right;
                }
                
                if (!pre->right) {
                    
                    pre->right = curr;
                    curr = curr->left;
                } else {
                    
                    pre->right = nullptr;
                    
                    // Process current node
                    process(curr);
                    curr = curr->right;
                }
            }
        }
        
        // Swap the values 
        if (first && second) {
            std::swap(first->val, second->val);
        }
    }

private:
    void process(TreeNode* node) {
        if (prev && prev->val > node->val) {
            // Found a dip
            if (!first) first = prev; 
            second = node;                     }
        prev = node;
    }
};