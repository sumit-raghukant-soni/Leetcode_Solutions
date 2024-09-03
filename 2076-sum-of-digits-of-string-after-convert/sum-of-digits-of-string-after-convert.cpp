class Solution {
public:
    int getLucky(string s, int k) {
        int sz = s.length();
        int sum = 0, k2 = k;
        for(int i=0; i<sz; i++){
            int val = s[i] - 'a' + 1;
            while(val){
                sum += val%10;
                val /= 10;
            }
        }
        k2--;

        while(k2>0){
            k2--;
            int newSum = 0;
            while(sum){
                newSum += sum%10;
                sum /= 10;
            }
            sum = newSum;
            if(sum < 10) return sum;
        }


        return sum;
    }
};