class Solution {
    public boolean isValid(String word) {
        int sz = word.length();
        boolean vowel = false, consonant = false, special = false;
        List<Character> v = Arrays.asList(new Character[] {'a','e','i','o','u','A','E','I','O','U'}), 
        d = Arrays.asList(new Character[] {'0','1','2','3','4','5','6','7','8','9'}), 
        s = Arrays.asList(new Character[] {'@','#','$'});
        if(sz < 3) return false;
        
        for(int i=0; i<sz; i++){
            if(d.contains(word.charAt(i))) continue;
            else if(v.contains(word.charAt(i))) vowel = true;
            else if(s.contains(word.charAt(i))) special = true;
            else consonant = true;
        }

        return vowel && consonant && !special;
    }
}