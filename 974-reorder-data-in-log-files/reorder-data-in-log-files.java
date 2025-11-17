class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int sz = logs.length, k = 0;
        String[] ans = new String[sz];
        List<Pair<String, String>> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();

        for(int i=0; i<sz; i++){
            String curr = logs[i];
            String[] arr = curr.split(" ", 2);
            boolean flg = false;
            // if(arr.length > 1) System.out.println(arr[0] + " : " + arr[1]);
            for(int j=0; j<arr[1].length(); j++){
                char ch = arr[1].charAt(j);
                if(ch <= '9' && ch >= '0'){
                    flg = true;
                    break;
                }
            }
            if(flg) arr2.add(curr);
            else arr1.add(new Pair(arr[0], arr[1]));
        }

        Collections.sort(arr1, (a, b) -> {
            if(a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
            return a.getValue().compareTo(b.getValue());
        });

        // System.out.println(arr1);
        // System.out.println(arr2);

        for(Pair<String, String> str : arr1){
            ans[k++] = str.getKey() + " " + str.getValue();
        }

        for(String str : arr2){
            ans[k++] = str;
        }

        return ans;
    }
}