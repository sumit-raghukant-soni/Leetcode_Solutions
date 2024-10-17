class Solution {
    public int maximumSwap(int num) {
        int ans = 0, j=7, maxi = 0, maxiI = 0;
        int arr[] = new int[8], nextG[] = new int[8];

        while(num > 0){
            arr[j--] = num%10;
            num /= 10;
        }

        for(int i=7; i>=0; i--){
            if(maxi > arr[i]){
                nextG[i] = maxiI;
            }
            else{
                nextG[i] = -1;
                if(maxi < arr[i]){
                    maxi = arr[i];
                    maxiI = i;
                }
            }
        }

        j=0;
        while(j < 8 && arr[j] == 0){
            j++;
        }
        while(j < 8 && nextG[j] == -1){
            j++;
        }

        for(int i=0; i<8; i++){
            // System.out.println(arr[i] + " " + nextG[i]);
        }

        if(j < 8){
            int tmp = arr[nextG[j]];
            arr[nextG[j]] = arr[j];
            arr[j] = tmp;
        }

        for(int i=0; i<8; i++){
            ans = ans*10 + arr[i];
        }

        return ans;
    }
}