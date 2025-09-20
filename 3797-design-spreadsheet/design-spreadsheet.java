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
        String a = "", b = "";
        boolean aflg = false, bflg = false, flg = false;

        for(int i=1; i<sz; i++){
            if(formula.charAt(i) == '+'){
                flg = true; continue;
            }
            if(flg){
                if(formula.charAt(i) >= 'A') bflg = true;
                b += formula.charAt(i);
            }
            else {
                if(formula.charAt(i) >= 'A') aflg = true;
                a += formula.charAt(i);
            }
        }

        if(aflg){
            v1 = mp2[Integer.valueOf(a.substring(1))][a.charAt(0) - 'A'];
        }
        else v1 = Integer.valueOf(a);

        if(bflg){
            v2 = mp2[Integer.valueOf(b.substring(1))][b.charAt(0) - 'A'];
        }
        else v2 = Integer.valueOf(b);


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