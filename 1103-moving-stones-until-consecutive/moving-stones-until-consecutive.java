class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int ans[] = new int[2];
        int tmp[] = {a, b, c};
        Arrays.sort(tmp);
        a = tmp[0]; b = tmp[1]; c = tmp[2];

        if(c-b == 2 || b-a == 2){
            ans[0] = 1;
        }
        else ans[0] = (a == b || a == b-1 ? 0 : 1) + (b == c || b == c-1 ? 0 : 1);
        ans[1] = (a == b ? 0 : b-a-1) + (b == c ? 0 : c-b-1);

        return ans;
    }
}