class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        if(low < 10) low = 10;
        if(low > 99 && low < 999) low = 1000;

        int firstHalf = -1;
        for(int i=low; i<=high; i++){
            if(i <= 99 && i >= 10){
                if((i%11) == 0) ans++; 
            } 
            else if(i > 99 && i <= 999) i = 1000;
            else{
                if((i%100) == 0 || firstHalf == -1){
                    firstHalf = sum(i/100);
                }
                if(firstHalf == sum(i%100)) ans++;
            }
            // System.out.println(firstHalf + " " + sum(i%100) + " " + ans);
        }

        return ans;
    }

    private int sum(int num){
        int sum = 0;
        while(num > 0){
            sum += (num%10);
            num/=10;
        }
        return sum;
    }
}