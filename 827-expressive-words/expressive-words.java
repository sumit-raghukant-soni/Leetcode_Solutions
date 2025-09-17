class Solution {
    public int expressiveWords(String s, String[] words) {
        int sz1 = s.length(), sz2 = words.length;
        int ans = 0, lstSz = 0;
        List<Pair<Character, Integer>> lst = new ArrayList<>(), lst2 = new ArrayList<>();

        for(int i=0; i<sz1; i++){
            char ch = s.charAt(i);
            int cnt = 0;
            while(i < sz1 && ch == s.charAt(i)){
                i++;
                cnt++;
            }
            i--;
            lst.add(new Pair(ch, cnt));
        }
        lstSz = lst.size();
        // System.out.println(lst);
        // System.out.println();

        for(int j=0; j<sz2; j++){
            int sz3 = words[j].length();
            for(int i=0; i<sz3; i++){
                char ch = words[j].charAt(i);
                int cnt = 0;
                while(i < sz3 && ch == words[j].charAt(i)){
                    i++;
                    cnt++;
                }
                i--;
                lst2.add(new Pair(ch, cnt));
            }
            // System.out.println(lst2);
            if(lst2.size() != lstSz) continue;

            for(int i=0; i<lstSz; i++){
                // System.out.println(lst.get(i).getKey() + ":" + lst.get(i).getValue());
                // System.out.println(lst2.get(i).getKey() + ":" + lst2.get(i).getValue());
                // System.out.println();
                if(lst.get(i).getKey() != lst2.get(i).getKey()) break;
                if( !(lst2.get(i).getValue() == lst.get(i).getValue() || 
                (lst2.get(i).getValue() < lst.get(i).getValue() && lst.get(i).getValue() >= 3)) ) break;
                if(i == lstSz-1) ans++;
            }

            lst2.clear();
        }

        return ans;
    }
}