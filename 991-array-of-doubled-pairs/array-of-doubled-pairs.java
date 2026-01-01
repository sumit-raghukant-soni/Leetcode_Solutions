class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int sz = arr.length, mid = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> lst = new ArrayList<>();

        Arrays.sort(arr);

        for(int i=0; i<sz; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        for(int i=0; i<sz; i++){
            if(arr[i] < 0) mid = i+1;
        }

        // System.out.println(mid);

        for(int i=mid; i<sz; i++){
            if(!mp.containsKey(arr[i])) continue;
            if(mp.get(arr[i]) > 1) mp.put(arr[i], mp.get(arr[i]) - 1);
            else mp.remove(arr[i]);
            
            int val2 = arr[i] * 2;
            // System.out.println("val2 " + val2);
            // System.out.println("mp " + mp);
            if(!mp.containsKey(val2)) return false;
            if(mp.get(val2) > 1) mp.put(val2, mp.get(val2) - 1);
            else mp.remove(val2);
        }

        // System.out.println("Here");

        for(int i=mid-1; i>=0; i--){
            if(!mp.containsKey(arr[i])) continue;
            if(mp.get(arr[i]) > 1) mp.put(arr[i], mp.get(arr[i]) - 1);
            else mp.remove(arr[i]);
            
            int val2 = arr[i] * 2;
            if(!mp.containsKey(val2)) return false;
            if(mp.get(val2) > 1) mp.put(val2, mp.get(val2) - 1);
            else mp.remove(val2);
        }

        return true;
    }
}