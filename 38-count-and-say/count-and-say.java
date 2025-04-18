class Solution {
    public String countAndSay(int n) {
        n--;
        int sz, k;
        String tmp = "1", ans = "1";

        for(int i=0; i<n; i++){
            sz = tmp.length(); k = 0;
            ans = "";
            for(int j=0; j<sz; j++){
                while(k<sz && tmp.charAt(j) == tmp.charAt(k)) k++;
                ans += (char) (k-j + '0');
                ans += tmp.charAt(j);
                j = k-1;
            }
            tmp = ans;
            // System.out.println(tmp + " " + i);
        }

        return ans;
    }
}