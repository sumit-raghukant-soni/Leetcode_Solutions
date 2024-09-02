class Solution {
public:
    int chalkReplacer(vector<int>& chalk, int k) {
        int sz = chalk.size();
        long sum = 0, newK;
        for(int i=0; i<sz; i++) sum += chalk[i];

        newK = k%sum;

        for(int i=0; i<sz; i++){
            if(newK == 0) return i;
            newK -= chalk[i];
            if(newK < 0) return i;
        }

        return 0;
    }
};