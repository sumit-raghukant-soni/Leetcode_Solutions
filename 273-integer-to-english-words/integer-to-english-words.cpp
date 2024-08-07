class Solution {
public:
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        vector<string> unit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        vector<string> ten = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        vector<string> tenE = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> curr = {"", "", "Hundred", "Thousand", "Hundred", "Million", "Hundred", "Billion"};

        string ans = "";
        int hflg = 0, pre = INT_MAX;

        while(num){
            long long tmp;
            if(hflg == 1 || hflg == 3 || hflg == 5){
                tmp = num%10;
                num /= 10;
            }
            else{
                tmp = num%100;
                num/=100;
            }
            hflg++;
            // cout << ans << " " << hflg << " " << tmp << " " << pre << endl;
            if(tmp <= 0){ pre = tmp; continue;}

            if(pre == 0 && (hflg == 4 || hflg == 6)){
                if(ans != "") ans = " " + ans;
                ans = curr[hflg-1] + ans;
            }
            if(hflg > 1 && ans != "") ans = " " + ans;
            ans = curr[hflg] + ans;

            if(ans != "") ans = " " + ans;
            if(tmp < 10) ans = unit[tmp-1] + ans;
            else if(tmp >= 10 && tmp <= 19) ans = tenE[tmp-10] + ans;
            else{
                if(tmp%10 > 0) ans = unit[(tmp%10)-1] + ans;
                if(tmp%10 > 0 && tmp/10 > 0) ans = " " + ans;
                if((tmp/10) > 0) ans = ten[(tmp/10)-2] + ans;
            }

            pre = tmp;
        }

        return ans;
    }
};