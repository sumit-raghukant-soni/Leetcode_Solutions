class Solution {
public:
    int numTeams(vector<int>& rating) {
        int sz = rating.size(), ans = 0;
        vector<int> asc(sz, 0), des(sz, 0);
        set<int> st;

        for(int i=0; i<sz; i++){
            asc[i] = distance(st.begin(), st.lower_bound(rating[i]));
            st.insert(rating[i]);
        }

        st.clear();

        for(int i=sz-1; i>=0; i--){
            des[i] = distance(st.begin(), st.lower_bound(rating[i]));
            st.insert(rating[i]);
        }


        for(int i=1; i<sz; i++){
            for(int j=0; j<i; j++){
                if(rating[j] < rating[i] && asc[j]){
                    ans += asc[j];
                }
            }
        }

        for(int i=sz-2; i>=0; i--){
            for(int j=sz-1; j>i; j--){
                if(rating[j] < rating[i] && des[j]){
                    ans += des[j];
                }
            }
        }

        // for(int i : asc) cout << i << " ";
        // cout << endl;
        // for(int i : des) cout << i << " ";
        // cout << endl;

        return ans;
    }
};