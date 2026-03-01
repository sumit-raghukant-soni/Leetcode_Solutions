class Solution {
    public int minPartitions(String n) {
        int sz = n.length();
        int maxi = 0, val;

        for(int i=0; i<sz; i++){
            val = n.charAt(i) - '0';
            maxi = maxi > val ? maxi : val;
        }

        return maxi;
    }
}