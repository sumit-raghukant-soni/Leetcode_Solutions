class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        int a = 1, b = 1, bound2 = bound;
        
        for(long i=0; i<32; i++){
            b = 1;
            for(long j=0; j<32; j++){
                if((1L*a+b) < Integer.MAX_VALUE && (a + b) <= bound2) st.add(a+b);
                else break;
                b *= y;
            }
            if((1L * a * x) <= Integer.MAX_VALUE) a *= x;
            else break;
        }

        ans.addAll(st);

        return ans;
    }
}