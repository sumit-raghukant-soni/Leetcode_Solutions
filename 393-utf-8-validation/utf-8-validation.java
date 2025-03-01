class Solution {
    public boolean validUtf8(int[] data) {
        int sz = data.length, k = 0;
        int arr[] = new int[sz];

        for(int i=0; i<sz; i++){
            arr[i] = countPre(data[i]);
            // System.out.print(arr[i] + ":" + Integer.toBinaryString(data[i]) + ", ");
        }

        if(arr[0] > sz || (arr[0] == 1 && sz == 1)) return false;
        if(arr[0] == 0 && sz == 1) return true;

        int curr = arr[0] > 0 ? arr[0]-1 : 0;
        for(int i=1; i<sz; i++){
            if(curr >= 4) return false;
            if(arr[i] == 1) curr--;
            else{
                if(curr == 0) curr = arr[i] > 0 ? arr[i]-1 : 0;
                else return false;
            }
        }

        // System.out.println(curr);

        return curr == 0;
    }

    private int countPre(int data){
        int cnt = 0;

        for(int i=0; i<8; i++){
            if((data&1) == 1) cnt++;
            else cnt = 0;
            data>>=1;
        }

        return cnt;
    }
}