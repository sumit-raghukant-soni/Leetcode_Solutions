class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int arr[][] = new int[4][2], ind = 0;
        arr[0] = p1; arr[1] = p2; arr[2] = p3; arr[3] = p4;

        double finalValues[] = new double[3];

        for(int i=0; i<4; i++){
            int curr[] = arr[i], k = 0;
            double values[] = new double[3];
            for(int j=0; j<4; j++){
                if(i == j) continue;
                double dis = Math.sqrt(Math.pow(curr[0] - arr[j][0], 2) + Math.pow(curr[1] - arr[j][1], 2));
                values[k++] = dis;
            }
            Arrays.sort(values);
            if(values[0] != values[1] || values[0] == 0) return false;
            if(i == 0) finalValues = values;
            else if(finalValues[0] != values[0] || finalValues[1] != values[1] || finalValues[2] != values[2]) return false;
        }
        
        return true;
    }
}