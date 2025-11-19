class Solution {
    public int findFinalValue(int[] nums, int original) {
        int num = original;
        Set<Integer> st = new HashSet<>();

        for(int i : nums) st.add(i); 

        while(st.contains(num)){
            num *= 2;
        }

        return num;
    }
}