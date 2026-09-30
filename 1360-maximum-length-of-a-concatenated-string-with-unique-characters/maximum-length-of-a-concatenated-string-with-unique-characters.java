class Solution {
    int sz;
    // String str = "";
    public int maxLength(List<String> arr) {
        sz = arr.size();
        int ans = 0, tmp, tmp2;
        long fq[] = new long[sz];

        for(int i=0; i<sz; i++) {
            tmp = 0;
            for(char ch : arr.get(i).toCharArray()) {
                tmp2 = 1 << (ch - 'a');
                // System.out.println(tmp2 + " " + fq[i]);
                if( (fq[i] & tmp2) > 0 || fq[i] == Long.MAX_VALUE) {
                    fq[i] = Long.MAX_VALUE;
                }
                else fq[i] += tmp2;
                // System.out.println(fq[i]);
            }
        }

        return solve(arr, fq, 0, 0);
    }

    private int solve(List<String> arr, long fq[], int i, long tmp2) {
        // System.out.println(str + " " + i + " " + sz);
        if(i >= sz) return 0;
        int tmp, ans = 0;

        if(fq[i] == Long.MAX_VALUE) return solve(arr, fq, i+1, tmp2);
        tmp = 0;
        for(int j=i; j<sz; j++) {
            if( (tmp2 & fq[j]) == 0 && fq[j] != Long.MAX_VALUE) {
                // str += arr.get(j);
                ans = Math.max(arr.get(j).length() + solve(arr, fq, j+1, tmp2 | fq[j]), ans);
                // str = str.substring(0, str.length() - arr.get(j).length());
            }
            else {
                ans = Math.max(solve(arr, fq, j+1, tmp2), ans);
            }
        }

        return ans;
    }
}