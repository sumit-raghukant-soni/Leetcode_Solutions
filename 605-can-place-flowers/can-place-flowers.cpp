class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if(n == 0) return true;
        
        int num = n, sz = flowerbed.size();
        for(int i=0; i<sz; i++){
            if(flowerbed[i] == 0){
                bool flg = true;
                if(i-1 >= 0 && flowerbed[i-1] == 1) flg = false;
                if(i+1 < sz && flowerbed[i+1] == 1) flg = false;
                if(flg){
                    num--;
                    i++;
                }
            }
            if(num == 0) break;
        }
        return num == 0;
    }
};