class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int ans[] = new int[n];
        Arrays.sort(potions);

        for(int i=0; i<n; i++){
            ans[i] = m - solve(potions, m, spells[i], success);
        }

        return ans;
    }

    private int solve(int[] potions, int m, long src, long dst){
        int s = 0, e = m-1;

        while(s <= e){
            int mid = s + (e-s)/2;
            // System.out.println(s + " " + e + " " + mid + " " + src);
            if(potions[mid] * src >= dst){
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }

        // System.out.println(s + " " + e);

        return s;
    }
}