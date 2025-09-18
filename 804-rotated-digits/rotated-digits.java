class Solution {
    public int rotatedDigits(int n) {
        int cnt = 0;
        int[] flg = new int[n+1];
        List<Integer> all = new ArrayList<>(), best = new ArrayList<>();
        all.add(0); all.add(1); all.add(8); 
        all.add(2); all.add(5); all.add(6); 
        all.add(9);
        best.add(2); best.add(5); best.add(6); 
        best.add(9);

        for(int i=1; i<=n; i++){
            int val = i/10;
            if(i >= 10){
               if((flg[val] == 1 && all.contains(i%10)) 
               || (flg[val] == 0 && best.contains(i%10))){
                    flg[i] = 1;
               }
               else if(flg[val] == 0 && !best.contains(i%10) && all.contains(i%10)){
                    flg[i] = 0;
               }
               else flg[i] = -1;
            }
            else if(best.contains(i)) flg[i] = 1;
            else if(all.contains(i)) flg[i] = 0;
            else flg[i] = -1;

            if(flg[i] == 1) cnt++;
        }

        return cnt;
    }
}