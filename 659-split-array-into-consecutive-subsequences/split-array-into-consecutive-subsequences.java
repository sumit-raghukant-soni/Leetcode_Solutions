class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> startWith = new HashMap<>(), endWith = new HashMap<>();

        for(int i : nums) startWith.put(i, startWith.getOrDefault(i, 0) + 1);

        for(int i : nums){
            if(startWith.get(i) == 0) continue;
            startWith.put(i, startWith.get(i) - 1);
            if(endWith.getOrDefault(i-1, 0) > 0){
                endWith.put(i-1, endWith.get(i-1)-1);
                endWith.put(i, endWith.getOrDefault(i, 0)+1);
            }
            else if(startWith.getOrDefault(i+1, 0) > 0 && startWith.getOrDefault(i+2, 0) > 0){
                startWith.put(i+1, startWith.get(i+1)-1);
                startWith.put(i+2, startWith.get(i+2)-1);
                endWith.put(i+2, endWith.getOrDefault(i+2, 0)+1);
            }
            else return false;
        }

        return true;
    }
}