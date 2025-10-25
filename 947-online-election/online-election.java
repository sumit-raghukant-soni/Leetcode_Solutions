class TopVotedCandidate {

    TreeMap<Integer, Integer> mp = new TreeMap<>();
    // TreeMap<Integer, Integer> pq = new TreeMap<>();
    int freq[] = new int[5001], maxi = -1, topper = -1;
    public TopVotedCandidate(int[] persons, int[] times) {
        int sz = persons.length;

        for(int i=0; i<sz; i++){
            // pq.put(persons[i], pq.getOrDefault(persons[i], 0) + 1);
            freq[persons[i]]++;
            if(freq[persons[i]] >= maxi){
                maxi = freq[persons[i]];
                topper = persons[i];
            }
            mp.put(times[i], topper);
            // System.out.println("Here " + pq.lastKey() + " " + persons[i] + " " + pq.firstKey());
            // System.out.println("Here " + pq.get(pq.lastKey()) + " " + pq.get(persons[i]));
            // if(pq.get(pq.lastKey()) == pq.get(persons[i])){
            //     System.out.println("Here changed");
            //     mp.put(times[i], persons[i]);
            // }
            // else mp.put(times[i], pq.lastKey());
            // System.out.println(pq + " <> " + mp);
        }

    }
    
    public int q(int t) {
        // System.out.println(pq + " <> " + mp);
        return mp.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */