class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int sz = s.length();
        Queue<Character> q = new LinkedList<>(), q2 = new LinkedList<>();

        for(int i=0; i<sz; i++){
            q.add(s.charAt(i));
            q2.add(goal.charAt(i));
        }

        for(int i=0; i<sz; i++){
            if(q.equals(q2)) return true;
            char ch = q2.remove();
            q2.add(ch);
        }

        return false;
    }
}