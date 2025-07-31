class Solution {
    int vis[] = null;
    boolean flg = true;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int cnt = 0;
        vis = new int[n];
        int tmp[] = new int[n];

        for(int i=0; i<n; i++){
            if(leftChild[i] != -1) tmp[leftChild[i]]++;
            if(rightChild[i] != -1) tmp[rightChild[i]]++;
        }

        for(int i=0; i<n; i++){
            if(tmp[i] == 0){
                solve(i, leftChild, rightChild);
                break;
            }
        }

        for(int i : vis) cnt += i;

        return flg ? n == cnt : false;
    }

    private void solve(int n, int[] leftChild, int[] rightChild){
        if(!flg) return;
        vis[n] = 1;

        if(leftChild[n] != -1){
            if(vis[leftChild[n]] == 1) flg = false;
            else solve(leftChild[n], leftChild, rightChild);
        }
        if(rightChild[n] != -1){
            if(vis[rightChild[n]] == 1) flg = false;
            else solve(rightChild[n], leftChild, rightChild);
        }
    }
}