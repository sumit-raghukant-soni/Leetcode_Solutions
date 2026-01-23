class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int sz = arr.length;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i=0; i<sz; i++){
            pq.add(arr[i]);
        }

        for(int i=sz-1; i>=0; i--){
            int curr = pq.poll();
            int ind = find(arr, curr);
            if(ind == i) continue;
            if(ind != 0){
                ans.add(i+1);
                ans.add(i - ind + 1);
            }
            ans.add(i+1);
            // System.out.println("For " + curr + " ind is " + ind);
            
            int s = ind, e = i;
            while(s < e){
                // System.out.println("Swapped " + s + ":" + e);
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                e--; s++;
            }
            // for(int j=0; j<sz; j++){
            //     System.out.print(arr[j] + ",");
            // }
            // System.out.println();
        }

        return ans;
    }

    private int find(int arr[], int num){
        int ind = 0;
        for(int i : arr){
            if(i == num) return ind;
            ind++;
        }

        return ind;
    }
}