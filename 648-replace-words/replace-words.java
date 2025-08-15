class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        int sz = sentence.length();
        boolean flg = false, notMatched = false;
        StringBuilder ans = new StringBuilder("");
        Trie root = populateTrie(dictionary), curr = root;

        for(int i=0; i<sz; i++){
            if(sentence.charAt(i) == ' '){
                flg = false; notMatched = false;
                ans.append(' ');
                curr = root;
                continue;
            }
            int ind = sentence.charAt(i) - 'a';
            if(!flg) ans.append(sentence.charAt(i));
            if(!notMatched && curr.next[ind] != null){
                curr = curr.next[ind];
                if(curr.isEndPoint) flg = true;
            }
            else notMatched = true;
        }

        return ans.toString();
    }

    private Trie populateTrie(List<String> dictionary){
        int sz = dictionary.size();

        Trie root = new Trie();

        for(String str : dictionary){
            populateWord(str, root);
        }

        return root;
    }

    private void populateWord(String str, Trie root){
        int sz = str.length();

        for(int i=0; i<sz; i++){
            int ind = str.charAt(i) - 'a';
            if(root.next[ind] == null) root.next[ind] = new Trie();
            root = root.next[ind];
        }
        root.isEndPoint = true;
    }
}

class Trie{
    Trie[] next = new Trie[26];
    boolean isEndPoint;
    Trie(){
        for(int i=0; i<26; i++) next[i] = null;
        isEndPoint = false;
    }
}