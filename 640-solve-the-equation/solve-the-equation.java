class Solution {
    public String solveEquation(String equation) {
        int sz = equation.length(), flg = 0;
        int x1 = 0, x2 = 0, val1 = 0, val2 = 0;

        int i=0;
        while(i < sz){
            int j=i, sign;
            String tmp = "";
            if(equation.charAt(j) == '='){
                j++; 
                if(equation.charAt(j) != '-') sign = 1;
                else{
                    sign = -1; j++;
                }
            }
            else{
                sign = i == 0 && equation.charAt(i) != '-' ? 1 : (equation.charAt(j++) == '+' ? 1 : -1);
            }
            while(j < sz && equation.charAt(j) != '+' && equation.charAt(j) != '-' && equation.charAt(j) != '='){
                tmp += equation.charAt(j++);
            }
            // System.out.println(tmp);
            if(tmp.charAt(tmp.length() - 1) == 'x'){
                if(tmp.length() == 1){
                    if(flg == 0) x1 += sign;
                    else x2 += sign;
                }
                else if(flg == 0) x1 += sign * Integer.valueOf(tmp.substring(0, tmp.length()-1));
                else x2 += sign * Integer.valueOf(tmp.substring(0, tmp.length()-1));
            }
            else{
                if(flg == 0) val1 += sign * Integer.valueOf(tmp);
                else val2 += sign * Integer.valueOf(tmp);
            }
            if(j < sz && equation.charAt(j) == '='){
                flg = 1;
            } 
            i = j;
        }

        // System.out.println(x1 + " " + val1);
        // System.out.println(x2 + " " + val2);

        if(x1 == x2 && val1 == val2) return "Infinite solutions";
        if(x1 == x2) return "No solution";

        int finalX, finalVal;

        finalX = x1 > x2 ? x1-x2 : x2 - x1;
        finalVal = x1 > x2 ? val2 - val1 : val1-val2;

        // System.out.println(finalX + " " + finalVal);

        if(finalX > 1) finalVal /= finalX;

        return "x=" + String.valueOf(finalVal);
    }
}