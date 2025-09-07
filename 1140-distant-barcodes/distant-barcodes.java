class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int sz = barcodes.length, ans[] = new int[sz];
        int freq[][] = new int[10001][2];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<sz; i++){
            q.add(i);
            freq[barcodes[i]][1]++;
            freq[barcodes[i]][0] = barcodes[i];
        }

        Arrays.sort(freq, (a, b) -> b[1] - a[1]);

        for(int i=0; i<10001; i++){
            if(freq[i][1] == 0) break;
            int prev = -10000, val = freq[i][0];
            for(int j=0; j<freq[i][1]; j++){
                int ind = q.poll();
                if(ind == prev+1){
                    q.add(ind);
                    ind = q.poll();
                }
                prev = ind;
                // System.out.println(i + " " + ind);
                ans[ind] = val;
            }
        }

        return ans;
    }
}