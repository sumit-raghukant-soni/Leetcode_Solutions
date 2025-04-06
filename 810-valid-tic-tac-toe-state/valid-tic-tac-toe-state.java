class Solution {
    private int qxm = 0, qom = 0, sz1, sz2, newb[][] = new int[3][3];
    private List<Pair<Integer, Integer>> qx = new ArrayList<>(), qo = new ArrayList<>();
    private boolean ans = false;
    public boolean validTicTacToe(String[] board) {

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == 'X') qx.add(new Pair(i, j));
                else if(board[i].charAt(j) == 'O') qo.add(new Pair(i, j));
            }
        }
        
        sz1 = qx.size(); sz2 = qo.size();
        solvex();

        return ans;
    }

    private void solvex(){
        // for(int i=0; i<3; i++){
        //     for(int j=0; j<3; j++){
        //         System.out.print(newb[i][j] + ",");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        if(check()){
            if(qom != sz2 || qxm != sz1) return;
            else {
                ans = true;
                // System.out.println("Here o" + " " + qxm + ":" + qom + " and " + sz1 + ":" + sz2);
            }
        }
        if(ans) return;

        for(int i=0; i<qx.size(); i++){
            int x = qx.get(i).getKey(), y = qx.get(i).getValue();
            if(newb[x][y] == 0){
                newb[x][y] = 1;
                qxm++;
                solveo();
                qxm--;
                newb[x][y] = 0;
            }
        }

        if(qxm == sz1 && qom == sz2){
            // System.out.println("Here x");
            ans = true;
        }
    }

    private void solveo(){
        // for(int i=0; i<3; i++){
        //     for(int j=0; j<3; j++){
        //         System.out.print(newb[i][j] + ",");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        if(check()){
            if(qom != sz2 || qxm != sz1) return;
            else {
                ans = true;
                // System.out.println("Here o" + " " + qxm + ":" + qom + " and " + sz1 + ":" + sz2);
            }
        }
        if(ans) return;

        for(int i=0; i<qo.size(); i++){
            int x = qo.get(i).getKey(), y = qo.get(i).getValue();
            if(newb[x][y] == 0){
                newb[x][y] = 2;
                qom++;
                solvex();
                qom--;
                newb[x][y] = 0;
            }
        }
        
        if(qxm == sz1 && qom == sz2){
            // System.out.println("Here o");
            ans = true;
        }
    }

    private boolean check(){
        return check2(1) || check2(2);
    }

    private boolean check2(int val){
        int tmp;
        for(int i=0; i<3; i++){
            tmp = 0;
            for(int j=0; j<3; j++){
                if(newb[i][j] == val) tmp++;
            }
            if(tmp == 3) return true;
        }

        for(int i=0; i<3; i++){
            tmp = 0;
            for(int j=0; j<3; j++){
                if(newb[j][i] == val) tmp++;
            }
            if(tmp == 3) return true;
        }

        tmp = 0;
        for(int i=0; i<3; i++){
            if(newb[i][i] == val) tmp++;
        }
        if(tmp == 3) return true;
        
        tmp = 0;
        for(int i=0; i<3; i++){
            if(newb[i][2-i] == val) tmp++;
        }

        return (tmp == 3);
    }
}