class Solution {
    public double[] sampleStats(int[] count) {
        int sz = count.length;
        long cnt = 0;
        double mean = 0, med = 0, mode = -1, min = -1, max = -1, maxCnt = 0;
        double[] ans = new double[5];

        
        for(int i=0; i<sz; i++){
            if(min == -1 && count[i] > 0) min = i;
            else if(max < i && count[i] > 0) max = i;
            if(maxCnt < count[i]) {
                maxCnt = count[i]; mode = i;
            }
            mean += 1.0 * count[i] * i;
            // System.out.println(count[i] * i + " " + mean);
            cnt += count[i];
        }

        mean /= cnt;

        // System.out.println(cnt);
        if((cnt&1) == 0){
            boolean flg = false;
            cnt = cnt/2;
            for(int i=0; i<sz; i++){
                if(count[i] == 0) continue;
                if(count[i] >= cnt+1 && !flg){
                    med = i+i; break;
                }
                else if(count[i] >= cnt){
                    med += i; 
                    // System.out.println(i + " added");
                    if(flg) break;
                    flg = true;
                }
                cnt -= count[i];
            }
            // System.out.println(med + " final");
            med = med/2;
        }
        else {
            cnt = (cnt/2) + 1;
            for(int i=0; i<sz; i++){
                if(count[i] >= cnt){
                    med = i; break;
                }
                else cnt -= count[i];
            }
        }

        ans[0] = min; ans[1] = max; ans[2] = mean; ans[3] = med; ans[4] = mode;
        return ans;
    }
}