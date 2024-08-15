class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int val5=0, val10=0, val20=0;

        for(int i : bills){
            // cout << i << ",";
            if(i == 5) val5++;
            else if(i == 10){
                if(val5 > 0) { val5--; val10++; }
                else return false;
            }
            else{
                if(val5 > 0 && val10 > 0) { val5--; val10--; val20++; }
                else if(val5 >= 3) { val5 -= 3; }
                else return false;
            }
        }

        return true;
    }
};