class Solution {
public:
    int update(int num){
        if(num < 10) return num;
        int sum = 0;
        while(num){
            sum += (num%10);
            num/=10;
        }
        return sum;
    }
    int countLargestGroup(int n) {
        map<int, int> num;
        int threshold = 0, lim = 1;
        for(int i=1; i<=n; i++){
            if(i%10 == 0){
                threshold = update(i/10);
            }
            if(i < 10) num[i]++;
            else num[(i%10) + threshold]++;
        }
        int cnt = 0, maxi = 0;
        for(auto i : num){
            if(i.second > maxi){
                maxi = i.second;
                cnt = 1;
            }
            else if(i.second == maxi) cnt++;
        }
        return cnt;
    }
};