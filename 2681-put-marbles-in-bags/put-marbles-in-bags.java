class Solution {
    public long putMarbles(int[] weights, int k) {
        int sz = weights.length;
        long minScore = 0, maxScore = 0;
        int[] separationPoints = new int[sz-1];

        for(int i=0; i<sz-1; i++){
            separationPoints[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(separationPoints);

        for(int i=0; i<k-1; i++){
            minScore += separationPoints[i];
        }

        for(int i=sz-2; i>=(sz-k); i--){
            maxScore += separationPoints[i];
        }

        return maxScore - minScore;
    }
}