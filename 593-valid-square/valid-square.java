class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int arr[][] = new int[4][2], ind = 0;
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        arr[3] = p4;

        double values[][] = new double[4][3];

        for(int i=0; i<4; i++){
            int curr[] = arr[i], k = 0;
            double value[] = new double[3];
            for(int j=0; j<4; j++){
                if(i == j) continue;
                double dis = Math.sqrt(Math.pow(curr[0] - arr[j][0], 2) + Math.pow(curr[1] - arr[j][1], 2));
                value[k++] = dis;
            }
            Arrays.sort(value);
            if(value[0] != value[1] || value[0] == 0) return false;
            values[ind++] = value;
        }

        for(int i=0; i<4; i++){
            // System.out.println(values[i][0] + " " + values[i][1]  + " " + values[i][2]);
            for(int j=0; j<3; j++){
                if(values[i][0] != values[0][0] || values[i][1] != values[0][1] || values[i][2] != values[0][2]) return false;
            }
        }
        
        return true;
    }
}