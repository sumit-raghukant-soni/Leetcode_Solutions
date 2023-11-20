class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        int g=0, p=0, m=0;
        int gi=-1, pi=-1, mi=-1;
        int sz = garbage.size();
        for(int i=0; i<sz; i++){
            for(auto j : garbage[i]){
                if(j == 'G'){
                    g++; gi = i;
                }
                else if(j == 'P'){
                    p++; pi = i;
                }
                else{
                    m++; mi = i;
                }
            }
        }
        
        int sz2 = travel.size();
        for(int i=0; i<sz2; i++){
            if(gi-1 >= i) g += travel[i];
            if(pi-1 >= i) p += travel[i];
            if(mi-1 >= i) m += travel[i];
        }
        
        return g+p+m;
    }
};