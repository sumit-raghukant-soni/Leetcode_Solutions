class Solution {
    private int sz;
    private int[] arr;
    public int minimumSubstringsInPartition(String s) {
        sz = s.length();

        arr = new int[sz];
        Arrays.fill(arr, -1);
        
        return solve(s, 0);
    }
    private int solve(String s, int i) {
        if(i == sz) return 0;
        if(arr[i] != -1) return arr[i];

        int fq[] = new int[26], min, max;
        int cnt = 1000, ind;

        for(int j=i; j<sz; j++) {
            ind = s.charAt(j) - 'a';
            fq[ind]++;
            max = 0;
            min = 1000;
            for(int k : fq) {
                if(k == 0) continue;
                min = Math.min(min, k);
                max = Math.max(max, k);
            }
            if(min == max) cnt = Math.min(cnt, 1 + solve(s, j+1));
        }

        return arr[i] = cnt;
    }
}