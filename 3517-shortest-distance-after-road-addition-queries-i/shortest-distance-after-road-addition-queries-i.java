class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int sz = queries.length, arr[] = new int[n];
        int ans[] = new int[sz]; 
        ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++){
            next.add(new ArrayList());
            next.get(i).add(i+1);
            arr[i] = n-1-i;
        }

        for(int i=0; i<sz; i++){
            next.get(queries[i][0]).add(queries[i][1]);
            for(int j=queries[i][0]; j>=0; j--){
                for(int k=0; k<next.get(j).size(); k++){
                    if(arr[j] > arr[next.get(j).get(k)]+1){
                        arr[j] = arr[next.get(j).get(k)]+1;
                    }
                }
            }
            ans[i] = arr[0];
            // for(int j=0; j<n; j++){
            //     System.out.print(arr[j] + " ");
            // }
            // System.out.println();
        }

        return ans;
    }
}