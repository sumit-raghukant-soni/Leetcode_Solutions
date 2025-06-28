class AuthenticationManager {
    int timeToLive;
    HashMap<String, Integer> mp = null;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        mp = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        mp.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mp.containsKey(tokenId) && mp.get(tokenId)+timeToLive > currentTime){
            mp.put(tokenId, currentTime);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for(Map.Entry<String, Integer> e : mp.entrySet()){
            if(e.getValue()+timeToLive > currentTime) cnt++;
        }

        return cnt;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */