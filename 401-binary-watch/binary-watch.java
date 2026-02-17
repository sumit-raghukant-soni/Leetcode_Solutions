class Solution {
    int h[] = {8,4,2,1};
    int m[] = {32,16,8,4,2,1};
    Set<Pair<Integer, Integer>> st = new HashSet<>();
    public List<String> readBinaryWatch(int turnedOn) {
        solve(turnedOn, 0, 0, 0, 0);
        List<String> ans = new ArrayList<>();

        for(Pair<Integer, Integer> p : st){
            ans.add(String.valueOf(p.getKey()) + ":" + (p.getValue() < 10 ? "0" : "") + String.valueOf(p.getValue()));
        }

        Collections.sort(ans);

        return ans;
    }

    private void solve(int k, int i, int j, int hrs, int mins){
        if(k == 0){
            st.add(new Pair(hrs, mins));
            return;
        }
        if(i == 4 && j == 6) return;

        for(int l=i; l<4; l++){
            if(hrs + h[l] <= 11){
                hrs += h[l];
                solve(k-1, l+1, j, hrs, mins);
                hrs -= h[l];
            }
        }
        for(int l=j; l<6; l++){
            if(mins + m[l] <= 59){
                mins += m[l];
                solve(k-1, i, l+1, hrs, mins);
                mins -= m[l];
            }
        }
    }
}