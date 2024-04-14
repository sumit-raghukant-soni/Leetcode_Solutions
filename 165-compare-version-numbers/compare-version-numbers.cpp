class Solution {
public:
    int compareVersion(string version1, string version2) {
        long long a, b;
        int i=0, j=0, sz1 = version1.size(), sz2 = version2.size();

        while(i < sz1 || j < sz2){
            a=0, b=0;
            // cout << "a " << endl;
            while(i < sz1 && version1[i] != '.'){
                a = (a*10) + version1[i++] - '0';
                // cout << a << " ";
            }
            // cout << endl;
            if(i < sz1 && version1[i] == '.') i++;

            // cout << "b " << endl;
            while(j < sz2 && version2[j] != '.'){
                b = (b*10) + version2[j++] - '0';
                // cout << b << " ";
            }
            // cout << endl;
            if(j < sz2 && version2[j] == '.') j++;
            // cout << a << " " << b << endl;
            if(a < b) return -1;
            else if(b < a) return 1;
        }

        return a < b ? -1 : (a == b ? 0 : 1);
    }
};