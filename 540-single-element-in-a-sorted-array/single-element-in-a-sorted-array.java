class Solution {
    public int singleNonDuplicate(int[] nums) {
        int sz = nums.length, s = 0, e = sz-1;

        while(s <= e){
            int mid = s + (e - s)/2;
            // System.out.println(s + " " + e + " and mid is " + mid);
            if(mid + 1 < sz && nums[mid+1] == nums[mid] ){
                // System.out.println("a");
                if( (sz-mid+2)%2 == 0 ){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            else if(mid-1 >= 0 && nums[mid-1] == nums[mid]){
                // System.out.println("b");
                if( (mid-2)%2 == 0 ){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            else return nums[mid];
        }

        return nums[s];
    }
}