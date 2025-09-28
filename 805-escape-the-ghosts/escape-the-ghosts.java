class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int sz = ghosts.length, mini = Integer.MAX_VALUE;

        for(int i=0; i<sz; i++){
            int diff = Math.abs(calc(ghosts[i][0]) - calc(target[0])) + Math.abs(calc(ghosts[i][1]) - calc(target[1]));
            // System.out.println(ghosts[i][0] + ":" + ghosts[i][1] + " = " + diff);
            mini = mini < diff ? mini : diff;
        }

        // System.out.println(mini + " " + (Math.abs(target[0] + target[1])) );
        return (Math.abs(target[0]) + Math.abs(target[1])) < mini;
    }

    private int calc(int i){
        return i + 10000;
    }
}