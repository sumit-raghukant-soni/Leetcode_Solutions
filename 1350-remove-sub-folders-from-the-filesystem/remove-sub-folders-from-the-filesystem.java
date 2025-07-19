class Solution {
    public List<String> removeSubfolders(String[] folder) {
        int sz = folder.length;
        boolean flg = true;
        Map<String, Integer> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(String str : folder){
            mp.put(str, mp.getOrDefault(str, 0) + 1);
        }   
        // System.out.println(mp);

        for(String str : folder){
            List<String> folders = new ArrayList<>();
            String tmp = "";
            for(char ch : str.toCharArray()){
                if(ch == '/' && tmp.length() > 1){
                    folders.add(tmp);
                    tmp = "";
                }
                tmp += ch;
            }
            // System.out.println(folders);
            tmp = "";
            flg = true;
            for(String f : folders){
                tmp += f;
                if(mp.containsKey(tmp)){
                    flg = false;
                    mp.remove(str);
                    break;
                }
            }
            if(flg) ans.add(str);
        }

        return ans;
    }
}