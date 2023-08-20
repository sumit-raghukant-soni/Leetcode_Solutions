class Solution {
public:
    int candy(vector<int>& rat) {
        vector<int> temp(rat.size(), 1);
        for(int i=0; i<rat.size(); i++){
            if(i == 0 && i+1 < rat.size() && rat[i+1] < rat[i]){
                temp[i]++;
            }
            else if(i-1 >= 0 && rat[i] > rat[i-1]){
                temp[i] = temp[i-1] + 1; 
            }
            else if(i+1 < rat.size() && rat[i] > rat[i+1])
                temp[i] = temp[i+1] + 1;
        }
        // for(int i=0; i<temp.size(); i++)
        //     cout << temp[i] << " ";
        // cout << endl;
        for(int i=rat.size()-1; i>=0; i--){
            if(i+1 < rat.size() && rat[i] > rat[i+1] && temp[i] <= temp[i+1]){
                temp[i] = temp[i+1] + 1;
            }
        }
        int ans = 0;
        for(int i=0; i<temp.size(); i++){
            // cout << temp[i] << " ";
            ans += temp[i];
        }
        return ans;
    }
};