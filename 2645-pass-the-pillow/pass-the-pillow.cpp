class Solution {
public:
    int passThePillow(int n, int time) {
        if(time+1 <= n) return time+1;

        int iterations = time/(n-1);
        time = time%(n-1);

        return iterations&1 ? (n-time) : (time+1);
    }
};