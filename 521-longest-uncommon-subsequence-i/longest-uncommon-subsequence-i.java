class Solution {
    public int findLUSlength(String a, String b) {
        int sz1 = a.length(), sz2 = b.length();
        
        if(a.equals(b)) return -1;
        if(sz1 >= sz2) return sz1;
        return sz2;
    }
}