class Solution {
public:
    int calculate(int h1, int m1, int h2, int m2){
        int a = h1*60 + m1, b = h2*60 + m2;
        // cout << a << " " << b << endl;
        return min(b-a, (a + 24*60)-b);
    }
    int findMinDifference(vector<string>& timePoints) {
        int ans = INT_MAX, sz = timePoints.size();
        sort(timePoints.begin(), timePoints.end(), [](string& a, string& b){
            string afront(a.begin(), a.begin()+2), bfront(b.begin(), b.begin()+2), aback(a.begin()+3, a.begin()+5), bback(b.begin()+3, b.begin()+5);
            if(stoi(afront) < stoi(bfront)) return true;
            else if(stoi(afront) == stoi(bfront) && stoi(aback) < stoi(bback)) return true;
            return false;
        });

        string h1, m1, h2, m2;
        h1 = string(timePoints[0].begin(), timePoints[0].begin()+2), m1 = string(timePoints[0].begin()+3, timePoints[0].begin()+5);
        h2 = string(timePoints[sz-1].begin(), timePoints[sz-1].begin()+2), m2 = string(timePoints[sz-1].begin()+3, timePoints[sz-1].begin()+5);
        ans = min(ans, calculate(stoi(h1), stoi(m1), stoi(h2), stoi(m2)));
        // cout << timePoints[0] << endl;
        for(int i=1; i<sz; i++){
            // cout << timePoints[i] << endl;
            h2 = string(timePoints[i].begin(), timePoints[i].begin()+2), m2 = string(timePoints[i].begin()+3, timePoints[i].begin()+5);
            int val = calculate(stoi(h1), stoi(m1), stoi(h2), stoi(m2));
            // cout << val << endl;
            ans = min(ans, val);
            h1 = h2, m1 = m2;
        }

        return ans;
    }
};