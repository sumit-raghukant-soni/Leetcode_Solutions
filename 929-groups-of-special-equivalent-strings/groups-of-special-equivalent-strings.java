class Solution {
    public int numSpecialEquivGroups(String[] words) {
        int sz = words.length;
        Map<String, String> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            // System.out.println(createKey(words[i]) + " " + words[i]);
            mp.put(createKey(words[i]), words[i]);
        }

        // System.out.println(mp);

        return mp.size();
    }

    private String createKey(String value) {
        int sz = value.length();
        String a = "", b = "";

        for(int i=0; i<sz; i++){
            if(i%2 == 0) a += value.charAt(i);
            else b += value.charAt(i);
        }

        char[] a1 = a.toCharArray(), b1 = b.toCharArray();
        Arrays.sort(a1); Arrays.sort(b1);

        a = new String(a1);
        b = new String(b1);

        return a + b;
    }
}