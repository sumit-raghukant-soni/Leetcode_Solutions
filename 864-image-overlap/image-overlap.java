class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        List<Pair<Integer,Integer>>vp1 = new ArrayList<>(),vp2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1){
                    vp1.add(new Pair(i, j));
                }
                if(img2[i][j]==1){
                    vp2.add(new Pair(i, j));
                }
            }
        }
        int ans=0;
        Map<Pair<Integer,Integer>,Integer>mp = new HashMap<>();
        for(Pair<Integer, Integer> it1:vp1){
            for(Pair<Integer, Integer> it2:vp2){
                int a=it1.getKey()-it2.getKey();
                int b=it1.getValue()-it2.getValue();
                Pair<Integer, Integer> p = new Pair(a, b);
                mp.put(p, mp.getOrDefault(p, 0) + 1);
                ans = Math.max(ans,mp.get(p));
            }
        }
        return ans;
    }
}