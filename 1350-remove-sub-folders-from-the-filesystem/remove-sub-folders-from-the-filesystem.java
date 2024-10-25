class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        int flg;

        for(String str : folder){
            String tmp = "";
            flg = 1;
            for(int i=0; i<str.length(); i++){
                tmp += str.charAt(i);
                if(mp.containsKey(tmp) && ((i+1 < str.length() && str.charAt(i+1) == '/') || i == str.length()-1)){
                    flg = 0;
                    break;
                }
            }
            if(flg == 1) mp.put(tmp, 1);
        }

        for(Map.Entry<String, Integer> pair : mp.entrySet()){
            ans.add(pair.getKey());
        }

        return ans;
    }
}