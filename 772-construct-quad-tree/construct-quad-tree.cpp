/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;
    
    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
public:
    Node* solve(vector<vector<int>>& grid, int row, int col, int sz){
        // cout << row << " " << col << " " << sz << endl;
        Node* root = new Node();
        if(sz == 1){
            root->val = grid[row][col];
            root->isLeaf = true;
            return root;
        }
        int one = 0, zero = 0;
        for(int i=row; i<row+sz; i++){
            for(int j=col; j<col+sz; j++){
                if(grid[i][j]) one++;
                else zero++;
            }
        }
        if(one + zero == max(one, zero)){
            root->val = one > zero ? true : false;
            root->isLeaf = true;
        }
        else{
            root->topLeft = solve(grid, row, col, sz/2);
            root->topRight = solve(grid, row, col + (sz/2), sz/2);
            root->bottomLeft = solve(grid, row + (sz/2), col, sz/2);
            root->bottomRight = solve(grid, row + (sz/2), col + (sz/2), sz/2);
        }
        // cout << root->val << ":" << root->isLeaf << endl;
        return root;
    }
    Node* construct(vector<vector<int>>& grid) {
        return solve(grid, 0, 0, grid.size());
    }
};