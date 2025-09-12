class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int sz1 = languages.length, sz2 = friendships.length, ans = Integer.MAX_VALUE, sz3 = 0;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Set<Integer> lst = new HashSet<>();
        Set<Integer> languagesKnown = new HashSet<>();

        for(int i=0; i<sz1; i++){
            List<Integer> tmp = new ArrayList<>();
            
            for(int j : languages[i]){
                languagesKnown.add(j);
                tmp.add(j);
            } 

            mp.put(i+1, tmp);
        }

        for(int i=0; i<sz2; i++){
            boolean flg = false;
            for(int j : mp.get(friendships[i][0])){
                if(mp.get(friendships[i][1]).contains(j)){
                    flg = true;
                    break;
                }
            }
            if(!flg){
                lst.add(friendships[i][0]);
                lst.add(friendships[i][1]);
            }
        }

        if(lst.isEmpty()) return 0;
        
        sz3 = lst.size();
        for(int i : languagesKnown){
            int cnt = 0;
            for(int j : lst){
                if(mp.get(j).contains(i)) cnt++;
            }
            ans = ans < (sz3 - cnt) ? ans : (sz3 - cnt);
        }
        
        return ans;
    }
}