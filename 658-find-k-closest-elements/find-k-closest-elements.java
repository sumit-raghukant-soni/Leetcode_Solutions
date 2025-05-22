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

        s = -1; e = sz;
        while(s <= e){
            mid = s + (e-s)/2;
            if(mid < 0 || mid >= sz) break;
            if(arr[mid] <= x){
                end = Math.max(mid, end);
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        // System.out.println(start + " <> " + end);
        end = end == Integer.MIN_VALUE ? mid : end;

        if(start == end && start == -1){
            for(int i=0; i<k; i++) ans.add(arr[i]);
            return ans;
        }
        else if(start == end && start == sz){
            for(int i=sz-k; i<sz; i++) ans.add(arr[i]);
            return ans;
        }

        // if(start == end) start--;
        // else{
        //     for(int i=0; i<=(end-start) && k > 0; i++, k--){
        //         ans.add(x);
        //     }
        //     start--; end++;
        // }
        end = start--;
        for(int i=start, j = end; (i>=0 || j<sz) && k > 0; k--){
            // System.out.println(i + " <> " + j);
            int val1 = i >= 0 ? arr[i] : 10000000, val2 = j < sz ? arr[j] : 10000000;
            int av1 = Math.abs(val1 - x), av2 = Math.abs(val2 - x);
            if(av1 <= av2){
                // System.out.println(val1 + " a ");
                ans.add(0, val1);
                i--;
            }
            else{
                // System.out.println(val2);
                ans.add(val2);
                j++;
            }
        }

        return ans;
    }
}