class Solution {
    public int findLucky(int[] arr) {
        int freq[] = new int[501];

        for(int i : arr){
            freq[i]++;
        }

        for(int i=500; i>=1; i--){
            if(freq[i] == i) return i;
        }

        return -1;
    }
}