class Solution {
    int freq[] = new int[101];
    int sz, MOD = 1000000007;
    long ans = 0;
    public int threeSumMulti(int[] arr, int target) {
        sz = arr.length;

        for(int i : arr) freq[i]++;

        if(target == 0) return (int) calc(freq[0]);

        // System.out.println("Case 1 " + freq[0]);
        for(int i=0; i<101; i++){
            if(i > target) break;
            if(freq[i] == 0) continue;
            if(i > 0 && target%i == 0 && target == i*3 && freq[i] >= 3){
                // System.out.println("Case 1 " + i);
                ans += calc(freq[i]);
            }
            int tmp = target - i;
            solve(i, tmp);
            tmp = target - (i<<1);
            if(tmp > i && tmp < 101 && freq[tmp] > 0){
                ans += calc(freq[tmp], freq[i]);
                // System.out.println("twince" + i + " " + tmp + " " + ans);
            }

        }

        return (int) ans;
    }

    private void solve(int i, int tmp){
        for(int j=i+1; j<101; j++){
            if(j > tmp) break;
            if(freq[j] == 0) continue;
            if(j > 0 && tmp%j == 0 && tmp == j*2 && freq[j] >= 2){
                ans += calc(freq[i], freq[j]);
                // System.out.println("Case 2 " + i + ":" + j + " " + ans + " <> " + tmp);
            }
            int tmp2 = tmp - j;
            if(tmp2 < 101 && freq[tmp2] != 0 && tmp2 != j && tmp2 != i && tmp2 > j){
                ans += calc(freq[i], freq[j], freq[tmp2]);
                // System.out.println("Case 3 " + i + ":" + j + ":" + tmp2 + " " + ans);
            }
            ans = ans % MOD;
        }
    }

    private long calc(int n){
        // System.out.println( fact(n) + " " + fact(n-3) );
        // return fact(n)%MOD / (fact(3) * fact(n-3));
        return fact(n);
    }

    private long calc(int m, int n){
        // System.out.println( m + " " + ((1L * n * (n-1))/2) );
        return m * ((1L * n * (n-1))/2);
    }

    private long calc(int m, int n, int o){
        return 1L * m * n * o;
    }

    // private long fact(int n){
    //     long fact = 1;
    //     while(n > 0){
    //         fact = ((fact%MOD) * (n%MOD))%MOD;
    //         n--;
    //     }
    //     return fact;
    // }

    private long fact(int n){
        // code here
        int r = 3;
        int mod = 1000000007;
        if (r > n){
            return 0;
        }
        
        long numerator = 1;
        long denominator = 1;
        
        for (int i = 0; i < r; i++){
            numerator = (numerator * (n - i)) % mod;
            denominator = (denominator * (i + 1)) % mod;
        }
        
        long inverse = 1;
        long base = denominator;
        long power = mod - 2;
        while (power > 0){
            if ((power & 1) == 1){
                inverse = (inverse * base) % mod;
            }
            base = (base * base) % mod;
            power >>= 1;
        }
        
        long result = (numerator * inverse) % mod;
        return result;
    }
}