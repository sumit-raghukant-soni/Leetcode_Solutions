class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int sz1 = firstList.length, sz2 = secondList.length;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        int i=0, j=0;
        while(i < sz1 && j < sz2){
            int s1 = firstList[i][0], e1 = firstList[i][1];
            int s2 = secondList[j][0], e2 = secondList[j][1];

            if((s2 <= e1 && e1 <= e2) || (s2 <= s1 && s1 <= e2) || (s2 <= s1 && e1 <= e2) || (s1 <= s2 && e2 <= e1)){
                pairs.add( new Pair( Math.max(s1, s2), Math.min(e1, e2) ) );
                if(e2 > e1) i++;
                else j++;
            }
            else if(e2 < e1) j++;
            else i++;
        }

        int sz3 = pairs.size(), ans[][] = new int[sz3][2];
        for(i=0; i<sz3; i++){
            ans[i][0] = pairs.get(i).getKey();
            ans[i][1] = pairs.get(i).getValue();
        }

        return ans;
    }
}