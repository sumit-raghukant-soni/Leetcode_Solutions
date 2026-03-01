class Solution {
    public int videoStitching(int[][] clips, int time) {
        int sz = clips.length;
        int tmp[][] = new int[sz][2], ind = -1;

        Arrays.sort( clips, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        for(int i=0; i<sz; i++){
            if(ind == -1) {
                tmp[++ind] = clips[i];
                // System.out.println("First added" + tmp[0][0] + ":" + tmp[0][1]);
            }
            else if(ind == 0) {
                if(clips[i][0] == 0){
                    tmp[0] = clips[i][1] > tmp[0][1] ? clips[i] : tmp[0];
                    // System.out.println("First updated" + tmp[0][0] + ":" + tmp[0][1]);
                }
                else if(tmp[0][1] >= clips[i][0]) {
                    tmp[++ind] = clips[i];
                    // System.out.println("Second added" + tmp[1][0] + ":" + tmp[1][1]);
                }
            }
            else {
                if(tmp[ind-1][1] >= clips[i][0] && tmp[ind][1] < clips[i][1]){
                    tmp[ind] = clips[i];
                    // System.out.println(ind + " updated:" + tmp[ind][0] + ":" + tmp[ind][1]);
                }
                else if(tmp[ind][1] >= clips[i][0] && tmp[ind][1] < clips[i][1]) {
                    tmp[++ind] = clips[i];
                    // System.out.println(ind + " added:" + tmp[ind][0] + ":" + tmp[ind][1]);
                    
                }
            }
            if(tmp[ind][1] >= time) break;
        }

        // System.out.println();
        return tmp[0][0] == 0 && tmp[ind][1] >= time ? ind+1 : -1;
    }
}