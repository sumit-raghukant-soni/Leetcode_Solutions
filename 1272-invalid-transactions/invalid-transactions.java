class Solution {
    public List<String> invalidTransactions(String[] txns) {
        int sz = txns.length;
        List<String> ans = new ArrayList<>();
        Map<String, Map<String, List<Integer>>> mp = new HashMap<>();

        for(int i=0; i<sz; i++) {
            String data[] = txns[i].split(",");
            if(!mp.containsKey(data[3])){
                mp.put(data[3], new HashMap<>());
            }
            if(!mp.get(data[3]).containsKey(data[0])){
                mp.get(data[3]).put(data[0], new ArrayList<>());
            }
            mp.get(data[3]).get(data[0]).add(Integer.valueOf(data[1]));
        }

        // System.out.println(mp);

        for(int i=0; i<sz; i++){
            String data[] = txns[i].split(",");
            int CurrMins = Integer.valueOf(data[1]);
            if(Integer.valueOf(data[2]) >= 1000){
                ans.add(txns[i]);
            }
            else {
                boolean flg = false;
                for(Map.Entry<String, Map<String, List<Integer>>> e : mp.entrySet()){
                    if(flg) break;
                    // System.out.println(data[3] + " " + e.getKey());
                    if(!e.getKey().equals(data[3])){
                        if(!e.getValue().containsKey(data[0])) continue;
                        // System.out.println(data[3] + " " + e.getKey() + " <> ");
                        for( int min : e.getValue().get(data[0]) ) {
                            if(flg) break;
                            if( Math.abs(min - CurrMins) <= 60){
                                // System.out.println(txns[i] + " " + e);
                                ans.add(txns[i]);
                                flg = true;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}