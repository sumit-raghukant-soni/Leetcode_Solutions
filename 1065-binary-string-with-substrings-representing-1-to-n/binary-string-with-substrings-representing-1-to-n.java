class Solution {
    public boolean queryString(String s, int n) {
        int sz = s.length();
        Set<Integer> st = new HashSet<>();

        for(int i=0; i<sz; i++){
            long val = 0;
            for(int j=i; j<sz; j++){
                if(s.charAt(j) == '1') val++;
                if(val > Integer.MAX_VALUE) break;
                st.add((int) val);
                System.out.println(val + " from " + j + " to " + i );
                val <<= 1;
            }
        }

        for(int i=1; i<=n; i++){
            if(!st.contains(i)) return false;
        }

        System.out.println(st);

        return true;
    }
}