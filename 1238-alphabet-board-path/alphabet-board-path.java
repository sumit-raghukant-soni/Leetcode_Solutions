class Solution {
    Map<String, String> mp = new HashMap<>();
    public String alphabetBoardPath(String target) {
        int sz = target.length();
        String ans = "";

        char prev = 'a', next;
        for(int i=0; i<sz; i++){
            next = target.charAt(i);
            // System.out.println(prev + " " + next + " top ");
            // System.out.println(mp);
            if(prev == next) ans += "!";
            else ans += calculate(prev, next) + "!";
            prev = next;
        }

        return ans;
    }

    private String calculate(char prev, char next){
        if(mp.containsKey(prev + "" + next)) return mp.get(prev + "" + next);
        int r1 = (prev-'a')/5, c1 = (prev-'a')%5;
        int r2 = (next-'a')/5, c2 = (next-'a')%5;
        // System.out.println(prev + " " + next);
        String res = "";
        if(r1 > r2){
            while(r1 > r2){
                r1--; res += "U";
            }
            while(c1 < c2){
                c1++; res += "R";
            }
            while(c1 > c2){
                c1--; res += "L";
            }
        }
        else {
            while(c1 < c2){
                c1++; res += "R";
            }
            while(c1 > c2){
                c1--; res += "L";
            }
            while(r1 < r2){
                r1++; res += "D";
            }
        }
        mp.put(prev + "" + next, res);
        return res;
    }
}