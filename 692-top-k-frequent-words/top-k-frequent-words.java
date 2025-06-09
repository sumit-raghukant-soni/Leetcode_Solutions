class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int sz = words.length;
        Map<String, Integer> mp = new TreeMap<>();
        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>((a, b) -> {
            if(a.getKey() == b.getKey()) return a.getValue().compareTo(b.getValue());
            return b.getKey() - a.getKey();
        });
        List<String> ans = new ArrayList<>();

        for(int i=0; i<sz; i++){
            if(!mp.containsKey(words[i])) mp.put(words[i], 0);
            mp.put(words[i], mp.getOrDefault(words[i], 0) + 1);
        }

        // System.out.println(mp);

        for(Map.Entry<String, Integer> e : mp.entrySet()){
            pq.add(new Pair(e.getValue(), e.getKey()));
        }

        for(int i=0; i<k; i++){
            ans.add(pq.poll().getValue());
        }

        return ans;
    }
}