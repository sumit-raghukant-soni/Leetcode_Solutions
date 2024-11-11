class Solution {
    public boolean solve(int[] bits, int i){
        if(i < 0) return true;

        boolean take = false, twoTake = false;
        if(bits[i] == 0){
            take = solve(bits, i-1);
        }
        if(i-1 >= 0 && bits[i-1] == 1){
            twoTake = solve(bits, i-2);
        }
        
        return take | twoTake;
    }
    public boolean isOneBitCharacter(int[] bits) {
        int sz = bits.length;

        return solve(bits, sz-2);
    }
}