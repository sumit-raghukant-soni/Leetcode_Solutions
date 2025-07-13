class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int sz1 = players.length, sz2 = trainers.length, cnt = 0, j = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);

        for(int i=0; i<sz1; i++){
            if(j < sz2 && trainers[j] < players[i]) j++;
            if(j < sz2){
                j++; cnt++;
            }
            else break;
        }

        return cnt;
    }
}