class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size(), sz = friends.length;
        int u, v, lvl = 0, vis[] = new int[n];
        List<String> ans = new ArrayList<>();
        List<Pair<String, Integer>> tmp = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<String, Integer> mp = new TreeMap<>();

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz; i++){
            u = i;
            for(int j=0; j<friends[i].length; j++){
                v = friends[i][j];
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }

        q.add(id);
        vis[id] = 1;
        q.add(-1);
        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == -1){
                if(q.isEmpty() || lvl == level) break;
                q.add(-1);
                curr = q.poll();
                lvl++;
            }

            if(lvl == level){
                // System.out.println(curr);
                for(String video : watchedVideos.get(curr)){
                    mp.put(video, mp.getOrDefault(video, 0) + 1);
                }
                continue;
            }

            for(int i : adjList.get(curr)){
                if(vis[i] == 0){
                    vis[i] = 1;
                    q.add(i);
                }
            }

        }

        for(Map.Entry<String, Integer> e : mp.entrySet()){
            tmp.add(new Pair(e.getKey(), e.getValue()));
        }

        Collections.sort(tmp, (a, b) -> {
            if(a.getValue() != b.getValue()) return a.getValue() - b.getValue();
            return a.getKey().compareTo(b.getKey());
        });

        for(Pair<String, Integer> p : tmp){
            ans.add(p.getKey());
        }

        return ans;
    }
}