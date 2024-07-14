class Solution {
public:
    void addPower(stack<pair<string, int>>& st, int count){
        if(st.empty()) return;
        if(st.top().first == "("){
            st.pop(); return;
        }

        pair<string, int> el = st.top();
        el.second *= count;
        st.pop();
        addPower(st, count);
        st.push(el);
    }
    string countOfAtoms(string formula) {
        int sz = formula.length(), count = 0;
        string ans = "", tmp;
        map<string, int> mp;
        stack<pair<string, int>> st;

        for(int i=0; i<sz; i++){
            if(formula[i] >= 'A' && formula[i] <= 'Z'){
                if(tmp != "") st.push({tmp, 1});
                tmp = string(1, formula[i]);
            }
            else if(formula[i] >= 'a' && formula[i] <= 'z'){
                tmp += formula[i];
            }
            else if(formula[i] >= '0' && formula[i] <= '9'){
                while(i < sz && formula[i] >= '0' && formula[i] <= '9'){
                    count = count*10 + int(formula[i] - '0');
                    i++;
                }
                if(tmp != ""){
                    st.push({tmp, count});
                    tmp = "";
                }
                else{
                    st.pop();
                    addPower(st, count);
                }
                i--;
                count = 0;
            }
            else{
                if(tmp != ""){
                    st.push({tmp, count == 0 ? 1 : count});
                    tmp = "";
                }
                st.push({string(1, formula[i]), -1});
            }
        }
        if(tmp != ""){
            st.push({tmp, 1});
        }

        while(!st.empty()){
            mp[st.top().first] += st.top().second;
            st.pop();
        }

        for(auto i : mp){
            if(i.first == ")" || i.first == "(") continue;
            ans += i.first;
            if(i.second > 1) ans += to_string(i.second);
        }

        return ans;
    }
};