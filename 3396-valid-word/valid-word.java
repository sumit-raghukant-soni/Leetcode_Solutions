class Solution {
    public boolean isValid(String word) {
        int sz = word.length();
        boolean vowel = false, consonant = false, special = false;
        List<Character> v = Arrays.asList(new Character[] {'a','e','i','o','u','A','E','I','O','U'});
        if(sz < 3) return false;
        
        for(int i=0; i<sz; i++){
            if(word.charAt(i) >= '0' && word.charAt(i) <= '9') continue;
            else if(word.charAt(i) == '@' || word.charAt(i) == '#' || word.charAt(i) == '$') special = true;
            else if(v.contains(word.charAt(i))) vowel = true;
            else consonant = true;
        }

        return vowel && consonant && !special;
    }
}