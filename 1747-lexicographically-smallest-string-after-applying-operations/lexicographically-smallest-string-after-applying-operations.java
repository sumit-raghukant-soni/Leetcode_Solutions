class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int sz = s.length();
        String ans;
        StringBuilder str = null;
        TreeSet<String> st = new TreeSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        while(!q.isEmpty()){
            str = new StringBuilder(q.poll());
            // System.out.println(str.toString());
            String bs = str.substring(sz-b) + str.substring(0, sz-b);
            if(!st.contains(bs)){
                st.add(bs);
                q.add(bs);
            }
            for(int k=1; k<sz; k+=2){
                // System.out.println("Changing " + k + " " + str.charAt(k) + ":" + (char) ((str.charAt(k) + a - '0')%10 + '0') );
                str.setCharAt(k, (char) ((str.charAt(k) + a - '0')%10 + '0') );
            }
            if(!st.contains(str.toString())){
                st.add(str.toString());
                q.add(str.toString());
            }
            // System.out.println(bs + " " + str.toString());
        }

        return st.first();
    }
}