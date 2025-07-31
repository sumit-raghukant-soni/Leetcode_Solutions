class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int sz = arr.length;
        Set<Integer> st = null, ans = new HashSet<>(), newValues = new HashSet<>();

        newValues.add(0);
        for(int i : arr){
            st = new HashSet<>();
            for(int j : newValues){
                st.add(i | j);
            }
            st.add(i);
            newValues = st;
            ans.addAll(st);
        }

        return ans.size();
    }
}