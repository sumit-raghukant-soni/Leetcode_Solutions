class Solution {
    public int lastRemaining(int n) {
        int elem = 1, steps = 1;
        boolean dir = true;

        while(n >= 2){
            elem += (dir || (n&1) == 1) ? steps : 0;
            steps *= 2;
            n /= 2;
            dir = !dir;
        }

        return elem;
    }
}