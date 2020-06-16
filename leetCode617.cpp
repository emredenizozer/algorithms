#include <iostream>

using namespace std;

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
class Solution {
public:
    TreeNode* mergeTrees(TreeNode* tree1, TreeNode* tree2) {
    if (!tree1)
        return tree2;

    if (tree2)
    {
        tree1->val += tree2->val;
        tree1->right = mergeTrees(tree1->right, tree2->right);
        tree1->left = mergeTrees(tree1->left, tree2->left);
    }

    return tree1;
    }
};