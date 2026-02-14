class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int ind = 0, ans = 0, MOD = 1000000007;
        Set<Integer> stH = new HashSet<>(), stV = new HashSet<>();

        Arrays.sort(hFences);
        Arrays.sort(vFences);

        for(int i=0; i<hFences.length; i++){
            for(int j=i-1; j>=0; j--){
                stH.add(hFences[i] - hFences[j]);
            }
            stH.add(hFences[i] - 1);
            if(hFences[i] != m) stH.add(m - hFences[i]);
        }
        stH.add(m-1);

        for(int i=0; i<vFences.length; i++){
            for(int j=i-1; j>=0; j--){
                stV.add(vFences[i] - vFences[j]);
            }
            stV.add(vFences[i] - 1);
            if(vFences[i] != n) stV.add(n - vFences[i]);
        }
        stV.add(n-1);

        for(int i : stH){
            if(stV.contains(i)){
                ans = ans > i ? ans : i;
            }
        }

        // System.out.println(stH);
        // System.out.println(stV);

        return ans == 0 ? -1 : (int) ((1L * ans * ans) % MOD);
    }
}