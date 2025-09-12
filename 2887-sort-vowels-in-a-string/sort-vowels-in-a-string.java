class Solution {
    public String sortVowels(String s) {
        int sz = s.length();
        char ch = ' ';
        List<Integer> inds = new ArrayList<>();
        List<Character> vowels = new ArrayList<>(), req = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        StringBuilder ans = new StringBuilder(s);

        for(int i=0; i<sz; i++){
            ch = s.charAt(i);
            if(req.indexOf(ch) > -1){
                vowels.add(s.charAt(i));
                inds.add(i);
            }
        }

        Collections.sort(vowels, (a, b) -> {
            return (int) a - b;
        });

        int k = 0;
        for(int i : inds){
            ans.setCharAt(i, vowels.get(k++));
        }

        return ans.toString();
    }
}