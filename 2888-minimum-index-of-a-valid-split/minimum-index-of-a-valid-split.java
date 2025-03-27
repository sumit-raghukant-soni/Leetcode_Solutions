class Solution {
    public int minimumIndex(List<Integer> nums) {
        int sz = nums.size(), k = 0;
        int dominator = -1, cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            mp.put(nums.get(i), mp.getOrDefault(nums.get(i), 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            if(e.getValue() > cnt){
                cnt = e.getValue();
                dominator = e.getKey();
            }
        }

        for(int i=0; i<sz; i++){
            if(nums.get(i) == dominator){
                cnt--; k++;
            }
            // System.out.println("at index : " + i + " , " + k + " <> " + ((i+1)/2));
            // System.out.println("also : " + cnt + " <> " + ((sz-i)/2));
            if(k > ((i+1)/2) && cnt > ((sz-i-1)/2)) return i;
        }

        return -1;
    }
}