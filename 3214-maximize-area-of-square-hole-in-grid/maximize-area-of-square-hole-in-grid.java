class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int l = 0, b = 0, cnt = 0;

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        for(int i=0; i<hBars.length; i++){
            if(i-1 >= 0 && hBars[i] == hBars[i-1]+1) cnt++;
            else cnt = 1;
            l = l > cnt ? l : cnt;
        }

        cnt = 0;
        for(int i=0; i<vBars.length; i++){
            if(i-1 >= 0 && vBars[i] == vBars[i-1]+1) cnt++;
            else cnt = 1;
            b = b > cnt ? b : cnt;
        }

        l++;
        b++;
        // System.out.println(l + " " + b);
        return l < b ? l*l : b*b;
    }
}