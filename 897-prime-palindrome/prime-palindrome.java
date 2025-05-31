class Solution {
    public int primePalindrome(int n) {
        if(n < 2) return 2;
        if(n == 2 || n == 3 || n == 5 || n == 7) return n;
        if(n == 4 || n == 6) return n+1;
        if(n <= 10) return 11;
        int cnt = cal(n), tmp = n;
        int a=0, b=0, aLen, bLen, c = 0, k = 0, curr;
        aLen = (cnt+1)/2; bLen = cnt/2;
        
        while(tmp > 0){
            c++;
            int rem = tmp%10;
            if(c > bLen) a += rem * Math.pow(10, k++);
            tmp/=10;
        }

        curr = getPalindrome(a);
        while(curr < n){
            a++;
            curr = getPalindrome(a);
        }

        while(!check(curr)){
            a++;
            curr = getPalindrome(a);
        }

        return curr;
    }

    private int getPalindrome(int num){
        int tmp = num, sz = cal(num);
        if(sz > 1) tmp /= 10;

        while(tmp > 0){
            int rem = tmp%10;
            num = (num*10) + rem;
            tmp /= 10;
        }

        return num;
    }

    private int cal(int a){
        int c = 0;
        while(a > 0){
            a/=10;
            c++;
        }
        return c;
    }

    private boolean check(int num){

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }

        return true;
    }
}