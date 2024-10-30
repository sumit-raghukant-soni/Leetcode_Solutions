class Solution {
    public boolean validMountainArray(int[] arr) {
        int sz = arr.length, flg = 1;
        if(sz < 3 || arr[0] > arr[1]) return false;

        for(int i=0; i<sz-1; i++){
            if(arr[i] == arr[i+1] || flg == 2 && arr[i] <= arr[i+1]){
                return false;
            }
            else if(flg == 1 && arr[i] > arr[i+1]) flg = 2;
            // System.out.println(arr[i] + " " + flg);
        }

        return flg == 2;
    }
}