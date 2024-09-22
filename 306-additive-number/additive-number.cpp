class Solution {
public:
    bool check(vector<long long unsigned> values){
        int sz = values.size();
        for(int i=2; i<sz; i++){
            // cout << values[i-2] + values[i-1] << " = " << values[i] << endl;
            if((values[i-2] + values[i-1]) != values[i]) return false;
        }
        // cout << "Here" << sz << endl;
        return true;
    }
    bool solve(string& num, int& sz, vector<long long unsigned>& values, int i){
        if(i == sz){
            if(values.size() > 2 && check(values)) return true;
            return false;
        }

        long long unsigned val = 0;
        for(int j=i; j<sz && j < (i + ((sz+1)/2)); j++){
            val = val*10 + (num[j] - '0');
            int sz2 = values.size();
            if(sz2 < 2 || (sz2 >= 2 && values[sz2-1] + values[sz2-2] == val)){
                values.push_back(val);
                if(solve(num, sz, values, j+1)) return true;
                else values.pop_back();
            }
            if(val == 0) break;
        }

        return false;
    }
    bool isAdditiveNumber(string num) {
        int sz = num.length();
        if(sz < 3) return false;
        vector<long long unsigned> values;
        return solve(num, sz, values, 0);
    }
};