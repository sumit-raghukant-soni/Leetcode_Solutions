class Solution {
public:
    int myAtoi(string str) {
        long long ans = 0, sign = 1;
        int s=0, e=str.length()-1;
        while(s <= e && str[s] == ' ') s++;
        while(e >= s && str[e] == ' ') e--;
        if(s <= e && (str[s] == '+' || str[s] == '-')){
            sign = str[s] == '+' ? 1 : -1;
            s++;
        }
        while(s<=e){
            if(str[s] <= '9' && str[s] >= '0'){
                ans = ans*10 + str[s]-'0';
            }
            else break;
            if(ans >= INT_MAX && sign == 1) return INT_MAX;
            else if(ans >= 1LL*INT_MAX+1 && sign == -1) return INT_MIN;
            s++;
        }

        return ans * sign;
    }
};