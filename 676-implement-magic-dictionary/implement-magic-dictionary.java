class MagicDictionary {
    Set<String> st = null;
    Set<String> org = null;
    public MagicDictionary() {
        st = new HashSet<>();
        org = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        int sz = 0;
        char ch;
        StringBuilder b = null;

        for(String str : dictionary){
            b = new StringBuilder(str);
            sz = str.length();
            for(int i=0; i<sz; i++){
                org.add(str);
                ch = str.charAt(i);
                for(char j='a'; j<='z'; j++){
                    if(j != ch){
                        b.setCharAt(i, j);
                        st.add(b.toString());
                    }
                }
                b.setCharAt(i, ch);
            }    
        }

        for(String str : org){
            if(!st.contains(str)) st.remove(str);
        }

        // System.out.println(st);
    }
    
    public boolean search(String searchWord) {
        int sz;
        char ch;
        StringBuilder b = null;

        return st.contains(searchWord);
        // b = new StringBuilder(searchWord);
        // sz = searchWord.length();
        // for(int i=0; i<sz; i++){
        //     ch = searchWord.charAt(i);
        //     for(char j='a'; j<='z'; j++){
        //         b.setCharAt(i, j);
        //         if(j != ch && st.contains(b.toString())){
        //             // System.out.println(st + " " + b.toString());
        //             System.out.println(searchWord + " " + b.toString());
        //             return true;
        //         }
        //     }
        //     b.setCharAt(i, ch);
        // }    

        // return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */