class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        List<Integer> lst = new ArrayList<>();
        int cells2[] = new int[8];
        Integer tmp = 0, k = 1;

        n--;
        while(true){
            tmp = 0; k = 10;
            for(int i=0; i<8; i++) cells2[i] = cells[i];
            for(int i=6; i>=1; i--){
                if(cells2[i-1] == cells2[i+1]){
                    cells[i] = 1;
                    tmp += k;
                }
                else cells[i] = 0;
                k *= 10;
            }
            cells[0] = cells[7] = 0;
            // System.out.println(tmp);
            if(lst.contains(tmp)) break;
            lst.add(tmp);
        }

        // System.out.println(lst + " " + (n % lst.size()) );
        int a = lst.get( (n % lst.size()));
        int ans[] = new int[8];

        for(int i=7; i>=0; i--){
            ans[i] = a%10;
            a /= 10;
            if(a <= 0) break;
        }

        return ans;
    }
}