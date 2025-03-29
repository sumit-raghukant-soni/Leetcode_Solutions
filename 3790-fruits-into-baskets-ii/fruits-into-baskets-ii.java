class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int sz1 = fruits.length, sz2 = baskets.length, ans = 0;

        for(int i=0; i<sz1; i++){
            for(int j=0; j<sz2; j++){
                if(baskets[j] >= fruits[i]){
                    fruits[i] = baskets[j] = 0;
                    break;
                }
            }
        }

        for(int i=0; i<sz1; i++){
            if(fruits[i] != 0) ans++;
        }

        return ans;
    }
}