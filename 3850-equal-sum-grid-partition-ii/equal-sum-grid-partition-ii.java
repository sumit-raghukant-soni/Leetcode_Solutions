class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0, curr;
        int rows[] = new int[m], cols[] = new int[n];
        Map<Long, List<Pair<Integer, Integer>>> st = new HashMap<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
                total += grid[i][j];
                if(!st.containsKey(grid[i][j] * 1L)) st.put(grid[i][j] * 1L, new ArrayList<>());
                st.get(grid[i][j] * 1L).add(new Pair(i, j));
            }
        }

        // System.out.println(total);

        curr = 0;
        for(int i=0; i<m-1; i++){
            curr += rows[i];
            // System.out.println(i + " row wise sum = " + curr);
            if((curr*2) == total){
                return true;
            }
            else if(st.containsKey( (curr*2) - total ) && st.get( (curr*2) - total ) != null){
                // System.out.println("first");
                for(Pair<Integer, Integer> p : st.get( (curr*2) - total )){
                    // System.out.println(p);
                    if(n == 1){
                        if(p.getKey() == 0 || p.getKey() == i) return true;
                    }
                    else if(p.getKey() <= i && 
                    (!(p.getKey() == 0 && i == 0) || (p.getValue() == 0 || p.getValue() == n-1))) {
                        return true;
                    }
                }
            }
            else if(st.containsKey( total - (curr*2) ) && st.get( total - (curr*2) ) != null) {
                // System.out.println("Second");
                for(Pair<Integer, Integer> p : st.get( total - (curr*2) )){
                    // System.out.println(p);
                    if(n == 1){
                        if(p.getKey() == m-1 || p.getKey() == i) return true;
                    }
                    else if(p.getKey() > i && 
                    (!(p.getKey() == m-1 && i == m-2) || (p.getValue() == 0 || p.getValue() == n-1)) ) {
                        // System.out.println(p + " Ans ");
                        return true;
                    }
                }
            }
        }

        curr = 0;
        for(int i=0; i<n; i++){
            curr += cols[i];
            // System.out.println(i + " col wise " + curr);
            if((curr*2) == total){
                return true;
            }
            else if(st.containsKey( (curr*2) - total ) && st.get( (curr*2) - total ) != null){
                for(Pair<Integer, Integer> p : st.get( (curr*2) - total )){
                    if(m == 1){
                        if(p.getValue() == 0 || p.getValue() == i) return true;
                    }
                    else if(p.getValue() <= i && 
                    (!(p.getValue() == 0 && i == 0) || (p.getKey() == 0 || p.getKey() == m-1))) {
                        return true;
                    }
                }
            }
            else if(st.containsKey( total - (curr*2) ) && st.get( total - (curr*2) ) != null){
                for(Pair<Integer, Integer> p : st.get( total - (curr*2) )){
                    if(m == 1){
                        if(p.getValue() == n-1 || p.getValue() == i) return true;
                    }
                    else if(p.getValue() > i && 
                    (!(p.getValue() == n-1 && i == n-2) || (p.getKey() == 0 || p.getKey() == m-1)) ) {
                        return true;
                    }
                }
            }
        }


        return false;
    }
}