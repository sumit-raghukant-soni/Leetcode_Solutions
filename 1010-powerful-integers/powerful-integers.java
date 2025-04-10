class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        long a = 1, b = 1, bound2 = bound;
        
        for(long i=0; i<32; i++){
            b = 1;
            if(a >= Integer.MAX_VALUE) break;
            for(long j=0; j<32; j++){
                if((a+b) < Integer.MAX_VALUE && (a + b) <= bound2) st.add(Math.toIntExact(a+b));
                else break;
                b *= y;
            }
            a *= x;
        }

        ans.addAll(st);

        return ans;
    }
}