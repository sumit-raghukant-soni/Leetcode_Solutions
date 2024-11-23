class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length, col = box[0].length;
        char ans[][] = new char[col][row];

        for(int i=0; i<row; i++){
            int lastBlank = col-1;
            for(int j=col-1; j>=0; j--){
                if(box[i][j] == '#'){
                    box[i][j] = '.';
                    box[i][lastBlank] = '#';
                    lastBlank--;
                }
                else if(box[i][j] == '*') lastBlank = j-1;
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans[j][row-1-i] = box[i][j];
            }
        }

        return ans;
    }
}