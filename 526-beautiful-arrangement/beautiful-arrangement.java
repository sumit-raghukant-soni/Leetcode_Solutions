class Solution {
    int[] vis = null;
    int sz;
    List<Integer>[] values;
    List<Integer> tmp = new ArrayList<>();
    public int countArrangement(int n) {
        vis = new int[n+1];
        sz = n;
        values = new ArrayList[n+1];

        for(int i=0; i<=sz; i++){
            values[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=n; i++){
            solve(i);
        }   

        // for(int i=1; i<=sz; i++){
        //     System.out.print(values[i] + ", ");
        // }
        // System.out.println();
        // System.out.println();

        return calc(1, n);
    }

    private void solve(int i){
        for(int j=i; j<=sz; j+=i){
            values[j].add(i);
        }

        for(int j=i-1; j>=1; j--){
            if(i%j == 0){
                values[j].add(i);
            }
        }
    }

    private int calc(int curr, int n){
        int cnt = 0;

        for(int i=0; i<values[curr].size(); i++){
            int val = values[curr].get(i);
            if(vis[val] == 0){
                // tmp.add(val);
                if(curr == n){
                    cnt++;
                    // System.out.println(tmp);
                }
                else{
                    vis[val] = 1;
                    cnt += calc(curr+1, n);
                    vis[val] = 0;
                }
                // tmp.remove(Integer.valueOf(val));
            }
        }

        return cnt;
    }
}