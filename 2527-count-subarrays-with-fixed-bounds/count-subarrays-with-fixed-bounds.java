class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int sz = nums.length;
        long ans = 0;
        List<Integer> minI = new ArrayList<>(), maxI = new ArrayList<>();

        for(int i=0; i<sz; i++){
            int start = i;
            // System.out.println(start);

            while(i < sz && nums[i] >= minK && nums[i] <= maxK){
                if(nums[i] == minK){
                    minI.add(i);
                    if(!maxI.isEmpty() && nums[i] != maxK){
                        // System.out.println("min found at " + i);
                        // System.out.println(maxI.get(maxI.size()-1) + " " + start + " " + (maxI.get(maxI.size()-1) - start + 1));
                        ans += maxI.get(maxI.size()-1) - start + 1;
                    }
                }
                if(nums[i] == maxK){
                    maxI.add(i);
                    if(!minI.isEmpty() && nums[i] != minK){
                        // System.out.println("max found at " + i);
                        // System.out.println(minI.get(minI.size()-1) + " " + start + " " + (minI.get(minI.size()-1) - start + 1));
                        ans += minI.get(minI.size()-1) - start + 1;
                    }
                }
                if(nums[i] != minK && nums[i] != maxK && !minI.isEmpty() && !maxI.isEmpty()){
                    // System.out.println("Nothing found " + (i - Math.max(maxI.get(maxI.size()-1), minI.get(minI.size()-1))) );
                    // ans += i - Math.max(maxI.get(maxI.size()-1), minI.get(minI.size()-1));
                    // ans += Math.min(maxI.get(maxI.size() - 1), minI.get(minI.size() - 1) ) - Math.min(maxI.get(0), minI.get(0));
                    ans += Math.min( maxI.get(maxI.size()-1), minI.get(minI.size()-1) ) - start + 1;
                }
                i++;
            }
            if(minK == maxK){
                ans += (1L*minI.size()*(minI.size()+1))/2;
            }
            // System.out.println(minI);
            // System.out.println(maxI);
            maxI.clear();
            minI.clear();
        }

        return ans;
    }
}