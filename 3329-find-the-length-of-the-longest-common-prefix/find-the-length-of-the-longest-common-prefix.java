class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int sz1 = arr1.length, sz2 = arr2.length, maxi = Integer.MIN_VALUE, ans = 0;
        Set<Integer> st = new HashSet<>();

        for(int i=0; i<sz1; i++) {
            int n = arr1[i];
            while(n > 0) {
                st.add(n);
                n /= 10;
            }
        }

        for(int i=0; i<sz2; i++){
            int n = arr2[i];
            while(n > 0) {
                if(st.contains(n)) {
                    maxi = maxi > n ? maxi : n;
                }
                n /= 10;
            }
        }

        while(maxi > 0) {
            ans++;
            maxi /= 10;
        }

        return ans;
    }
}