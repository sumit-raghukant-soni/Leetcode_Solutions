class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int sz = s.length(), n = indices.length, last = 0, sz3;
        String ans = "";

        List<IST> lst = new ArrayList<>();

        for(int i=0; i<n; i++){
            lst.add(new IST(indices[i], sources[i], targets[i]));
        }

        Collections.sort(lst, (a, b) -> a.ind - b.ind);

        for(int i=0; i<n; i++){
            int ind = lst.get(i).ind;
            String src = lst.get(i).src, tgt = lst.get(i).tgt;
            while(last < ind){
                ans += s.charAt(last++);
            }
            sz3 = src.length();
            // System.out.println(ind + " " + sz3);
            // System.out.println(s.substring(ind, ind + sz3) + " " + src);
            if((ind + sz3) <= sz && s.substring(ind, ind + sz3).equals(src)){
                ans += tgt;
                last += sz3;
            }
        }

        while(last < sz){
            ans += s.charAt(last++);
        }

        return ans;
    }
}

class IST{
    int ind;
    String src, tgt;
    IST(int i, String s, String t){
        this.ind = i;
        this.src = s;
        this.tgt = t;
    }
}