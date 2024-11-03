class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        goal += goal;

        return goal.indexOf(s, 0) > -1;
    }
}