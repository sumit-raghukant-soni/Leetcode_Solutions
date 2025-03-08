class Solution {
    public int findNthDigit(int n) {
        long num = 1, k = 1;
        
        while(n > 0){
            if(n - k <= 0) break;
            n -= k;
            // if(n <= 100) 
            // System.out.print(num + " " + n + " " + k + ", ");
            if(num == 9 || num == 99 || num == 999 || num == 9999 || num == 99999 || num == 999999 || num == 9999999 || num == 99999999) k++;
            num++;
        }

        // System.out.println(num);

        // n--;
        while(n > 1){
            n--;
            // System.out.println(num);
            num = num%((int) Math.pow(10, --k));
        }

        k--;
        return (int) num/((int) Math.pow(10, k--));
    }
}