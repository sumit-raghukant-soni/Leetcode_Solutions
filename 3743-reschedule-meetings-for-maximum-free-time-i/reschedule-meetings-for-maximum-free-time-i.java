class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int sz = startTime.length, cnt = 0, ans = 0;
        int tmp[][] = new int[sz][2];
        List<Integer> lst = new ArrayList<>();

        for(int i=0; i<sz; i++){
            tmp[i][0] = startTime[i];
            tmp[i][1] = endTime[i];
        }

        Arrays.sort(tmp, (a, b) -> a[0] - b[0]);

        int last = 0;
        for(int i=0; i<sz; i++){
            if(tmp[i][0] > last){
                lst.add(tmp[i][0] - last);
            }
            else lst.add(0);
            last = tmp[i][1];
        }
        if(last != eventTime){
            lst.add(eventTime - last);
        }

        // System.out.println(lst);

        cnt = 0;
        for(int i=0; i<lst.size(); i++){
            cnt += lst.get(i);
            if(i >= k){
                ans = ans > cnt ? ans : cnt;
                cnt -= lst.get(i-k);
            }
        }
        ans = ans > cnt ? ans : cnt;

        return ans;
    }
}