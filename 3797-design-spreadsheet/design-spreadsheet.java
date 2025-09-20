class Spreadsheet {
    Map<String, Integer> mp = null;
    public Spreadsheet(int rows) {
        mp = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        mp.put(cell, value);
    }
    
    public void resetCell(String cell) {
        mp.put(cell, 0);
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

        // System.out.println(aflg + " " + a);
        // System.out.println(bflg + " " + b);

        if(aflg) v1 = mp.getOrDefault(a, 0);
        else v1 = Integer.valueOf(a);

        if(bflg) v2 = mp.getOrDefault(b, 0);
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