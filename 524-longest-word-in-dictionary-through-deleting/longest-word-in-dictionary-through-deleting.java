class Solution {
    public String findLongestWord(String s, List<String> dict) {
        int sz = dict.size(), sz1 = s.length(), k=0, sz2;
        String ans = "", tmp = null, curr = null;

        for(int i=0; i<sz; i++){
            curr = dict.get(i);
            sz2 = curr.length();
            tmp = "";
            k=0;
            for(int j=0; j<sz1; j++){
                if(k < sz2){
                    if(s.charAt(j) == curr.charAt(k)){
                        tmp += curr.charAt(k++);
                    }
                }
                else break;
            }
            // System.out.println(tmp);
            if(tmp.length() == sz2){
                if(ans.length() == sz2){
                    if(ans.compareTo(tmp) > 0){
                        ans = new String(tmp);
                    }
                    else ans = ans;
                }
                else if(ans.length() < sz2) ans = new String(tmp);
            }
        }

        return ans;
    }
}