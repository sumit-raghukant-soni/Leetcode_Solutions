class Solution {
public:
    int getLength(int n){
        int cnt = 0;
        while(n > 0){
            cnt++; n /= 10;
        }
        return cnt;
    }
    vector<int> sequentialDigits(int low, int high) {
        vector<int> ans;
        int start = getLength(low), end = getLength(high), prev = low-1;

        for(int j=start; j<=end; j++){
            int num = 0, t = pow(10, j-1);
            // cout << pow(10, j-1) << endl;
            for(int i=0; i<9; i++){
                if(num >= t){
                    // cout << endl;
                    num = num % t;
                }
                num = (num * 10) + (i+1);
                // cout << num << ":";
                if(num > prev && num <= high){
                    ans.push_back(num);
                    prev = num;
                }
            }
        }

        return ans;
    }
};