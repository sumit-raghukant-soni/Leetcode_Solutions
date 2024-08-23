class Solution {
public:
    string fractionAddition(string exp) {
        int sz = exp.size();
        string val = "";
        vector<int> num, den;

        for(int i=0; i<sz; i++){
            // cout << val << endl;
            if(exp[i] == '/'){
                // cout << "num " << val << endl;
                num.push_back(stoi(val));
                val = "";
            }
            else if(val != "" && exp[i] == '-' || exp[i] == '+'){
                // cout << "den " << val << endl;
                den.push_back(stoi(val));
                val = exp[i];
            }
            else{
                val += exp[i];
            }
        }
        den.push_back(stoi(val));

        int lcm = den[0], tmp = den[0];
        sz = den.size();
        for(int i=1; i<sz; i++){
            tmp = __gcd(tmp, den[i]);
            lcm = (lcm * den[i])/tmp;
        }

        for(int i=0; i<sz; i++){
            num[i] *= (lcm/den[i]);
        }

        int top = 0;
        for(int i=0; i<sz; i++){
            top += num[i];
            // cout << num[i] << " / " << den[i] << endl;
        }

        if(top == 0) return "0/1";

        int gcd = __gcd(lcm, abs(top));

        // cout << top << "/" << lcm;

        lcm /= gcd, top /= gcd;

        return to_string(top) + "/" + to_string(lcm);
    }
};