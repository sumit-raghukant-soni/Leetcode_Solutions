class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        int sz = paths.length, sz2 = 0;
        Map<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<sz; i++){
            String[] arr = paths[i].split(" ");
            String root = arr[0];
            sz2 = arr.length;
            for(int j=1; j<sz2; j++){
                String[] arr2 = arr[j].split("\\(");
                String fnm = arr2[0];
                String fcnt = arr2[1];
                if(!mp.containsKey(fcnt)) mp.put(fcnt, new ArrayList<>());
                mp.get(fcnt).add(root + "/" + fnm);
            }
        }

        for(Map.Entry<String, List<String>> e : mp.entrySet()){
            if(e.getValue().size() > 1) ans.add(e.getValue());
        }

        return ans;
    }
}