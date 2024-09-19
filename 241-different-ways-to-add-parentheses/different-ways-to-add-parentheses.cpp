class Solution {
public:
    int cal(int a, int b, char ch){
        if(ch == '+') return a + b;
        else if(ch == '-') return a - b;
        return a * b;
    }
    vector<int> diffWaysToCompute(string expression) {
        int sz = expression.size();
        vector<int> ans;

        for(int i=0; i<sz; i++){
            if(expression[i] < '0' || expression[i] > '9'){
                vector<int> left = diffWaysToCompute(expression.substr(0, i)), right = diffWaysToCompute(expression.substr(i+1));
                for(int j : left){
                    for(int k : right){
                        ans.push_back(cal(j, k, expression[i]));
                    }
                }
            }
        }

        if(ans.empty()) return {stoi(expression)};
        return ans;
    }
};