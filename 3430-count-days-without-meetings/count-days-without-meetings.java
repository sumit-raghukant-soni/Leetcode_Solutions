class Solution {
    public int countDays(int days, int[][] meetings) {
        int sz = meetings.length, ans = 0;
        int start = 1, j = 0, end = 0;

        Arrays.sort(meetings, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        // for(int i=0; i<sz; i++){
        //     System.out.print(meetings[i][0] + ":" + meetings[i][1] + ", ");
        // }
        // System.out.println();

        for(int i=0; i<sz; i++){
            // System.out.println(meetings[i][0] + ":" + meetings[i][1] + " " + start + " and = " + ans);
            if(start < meetings[i][0]) ans += (meetings[i][0] - start);
            j = i;
            start = meetings[i][1] + 1;
            while(j < sz && (meetings[j][0] == meetings[i][0] || meetings[j][1] <= meetings[i][1])){
                // System.out.println(j);
                start = Math.max(start, meetings[j][1] + 1);
                j++;
            }
            if(j != i) i = j-1;
        }

        if(start <= days) ans += (days - start) + 1;

        return ans;
    }
}