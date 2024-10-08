class Solution {
    public int minSwaps(String s) {
        Integer o=0, c=0, sz = s.length();

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == '['){
                o++;
            }
            else{
                if(o > 0) o--;
                else c++;
            }
        }

        return (o+1)/2;
    }
}