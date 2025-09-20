class Spreadsheet {
    int[][] mp2 = null;
    public Spreadsheet(int rows) {
        mp2 = new int[rows+1][26];
    }
    
    public void setCell(String cell, int value) {
        mp2[Integer.valueOf(cell.substring(1))][cell.charAt(0) - 'A'] = value;
    }
    
    public void resetCell(String cell) {
        mp2[Integer.valueOf(cell.substring(1))][cell.charAt(0) - 'A'] = 0;
    }
    
    public int getValue(String formula) {
        int sz = formula.length(), v1 = 0, v2 = 0;
        int aRow = -1, bRow = -1, aCol = 0, bCol = 0;
        String a = "", b = "";
        boolean aflg = false, bflg = false, flg = false;

        for(int i=1; i<sz; i++){
            if(formula.charAt(i) == '+'){
                flg = true; continue;
            }
            if(flg){
                if(formula.charAt(i) >= 'A') bRow = formula.charAt(i) - 'A';
                else bCol = (bCol*10) + (formula.charAt(i) - '0');
                b += formula.charAt(i);
            }
            else {
                if(formula.charAt(i) >= 'A') aRow = formula.charAt(i) - 'A';
                else aCol = (aCol*10) + (formula.charAt(i) - '0');
                a += formula.charAt(i);
            }
        }

        // System.out.println(a + " " + aRow + " " + aCol);
        // System.out.println(b + " " + bRow + " " + bCol);

        if(aRow != -1){
            v1 = mp2[aCol][aRow];
        }
        else v1 = aCol;

        if(bRow != -1){
            v2 = mp2[bCol][bRow];
        }
        else v2 = bCol;


        return v1 + v2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */