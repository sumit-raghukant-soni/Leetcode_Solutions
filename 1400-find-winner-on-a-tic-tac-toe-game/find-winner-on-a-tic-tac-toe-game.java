class Solution {
    public String tictactoe(int[][] moves) {
        int[][] mat = new int[3][3];
        Boolean flg = true;

        for(int i=0; i<moves.length; i++){
            mat[moves[i][0]][moves[i][1]] = flg ? 1 : 2;
            if(check(mat, flg ? 1 : 2)) return flg ? "A" : "B";
            flg = !flg;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public Boolean check(int[][] mat, int val){
        if((mat[0][0] == mat[0][1] && mat[0][1] == mat[0][2] && mat[0][2] == val) ||
        (mat[1][0] == mat[1][1] && mat[1][1] == mat[1][2] && mat[1][2] == val) || 
        (mat[2][0] == mat[2][1] && mat[2][1] == mat[2][2] && mat[2][2] == val) || 
        
        (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2] && mat[2][2] == val) || 
        (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0] && mat[2][0] == val) || 

        (mat[0][0] == mat[1][0] && mat[1][0] == mat[2][0] && mat[2][0] == val) || 
        (mat[0][1] == mat[1][1] && mat[1][1] == mat[2][1] && mat[2][1] == val) || 
        (mat[0][2] == mat[1][2] && mat[1][2] == mat[2][2] && mat[2][2] == val)) return true;
        return false;
    }
}