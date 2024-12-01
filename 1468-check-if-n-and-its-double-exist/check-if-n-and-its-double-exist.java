class Solution {
    public boolean checkIfExist(int[] arr) {
        int sz = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        for(int i=0; i<sz; i++){
            if((arr[i] == 0 && mp.get(0) > 1) || (arr[i] != 0 && mp.containsKey(arr[i]*2))) return true;
        }

        return false;
    }
}