class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int sz = arr.length, s, e, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE, mid = -1;
        List<Integer> ans = new ArrayList<>();        
        
        s = -1; e = sz;
        while(s <= e){
            mid = s + (e-s)/2;
            if(mid < 0 || mid >= sz) break;
            if(arr[mid] < x){
                s = mid + 1;
            }
            else{
                start = Math.min(mid, start);
                e = mid - 1;
            }
        }
        start = start == Integer.MAX_VALUE ? mid : start;

        if(start == -1) start = 0;
        else if(start == sz) start = sz-1;

        end = start--;
        for(int i=start, j = end; (i>=0 || j<sz) && k > 0; k--){
            int val1 = i >= 0 ? arr[i] : 10000000, val2 = j < sz ? arr[j] : 10000000;
            int av1 = Math.abs(val1 - x), av2 = Math.abs(val2 - x);
            if(av1 <= av2){
                ans.add(0, val1);
                i--;
            }
            else{
                ans.add(val2);
                j++;
            }
        }

        return ans;
    }
}