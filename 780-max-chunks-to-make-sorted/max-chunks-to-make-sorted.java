class Solution {
    public int maxChunksToSorted(int[] arr) {
        int sz = arr.length, cnt = 0;
        Set<Integer> st1 = new HashSet<>(), st2 = new HashSet<>();

        for(int i=0; i<sz; i++){
            st1.add(arr[i]);
            st2.add(i);
            if(st1.equals(st2)) cnt++;
        }

        return cnt;
    }
}