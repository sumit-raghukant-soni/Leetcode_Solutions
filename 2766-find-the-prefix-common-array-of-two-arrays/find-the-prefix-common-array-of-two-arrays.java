class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int sz = A.length, ans[] = new int[sz];
        Set<Integer> one = new HashSet<>(), two = new HashSet<>();

        for(int i=0; i<sz; i++){
            if(one.contains(A[i])){
                two.add(A[i]);
            }
            else one.add(A[i]);
            if(one.contains(B[i])){
                two.add(B[i]);
            }
            else one.add(B[i]);
            ans[i] = two.size();
        }

        return ans;
    }
}