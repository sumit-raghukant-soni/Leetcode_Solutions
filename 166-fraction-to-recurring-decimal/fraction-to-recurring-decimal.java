class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder b = new StringBuilder(""), b2 = new StringBuilder("");
        long n = numerator, d = denominator, rem = 0;
        Map<Long, Integer> mp = new HashMap<>();


        if(n < 0 ^ d < 0) b.append("-");
        if(n < 0) n *= -1;
        if(d < 0) d *= -1;
        
        rem = n % d;
        b.append(String.valueOf( n / d ) );
        
        int cnt = 0;
        while(rem != 0){
            if(mp.containsKey(rem)){
                b2.insert(mp.get(rem), "(");
                b2.append(")");
                break;
            }
            mp.put(rem, cnt);
            cnt++;
            rem *= 10;
            b2.append(String.valueOf(rem/d));
            rem %= d;
        }
        
        if(!b2.isEmpty()) b.append( "." + b2.toString() );

        return b.toString();
    }
}