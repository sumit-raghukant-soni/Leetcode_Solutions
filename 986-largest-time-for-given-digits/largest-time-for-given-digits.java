class Solution {
    int maxH = -1, maxM = -1;
    public String largestTimeFromDigits(int[] arr) {
        permutate(arr, 0, 3);

        if(maxH == -1){
            return "";
        }
        return (maxH < 10 ? "0" : "") + String.valueOf(maxH) + ":" + (maxM < 10 ? "0" : "") + String.valueOf(maxM);
    }

    private void permutate(int[] arr, int s, int e){
        if(s > e){
            // for(int i=0; i<4; i++){
            //     System.out.print(arr[i]);
            // }
            // System.out.println();
            int h = arr[0] * 10 + arr[1], m = arr[2] * 10 + arr[3];
            if(h < 24 && m < 60){
                if(h > maxH){
                    maxH = h; maxM = m;
                }
                else if(h == maxH){
                    maxM = maxM > m ? maxM : m;
                }
            }
            return;
        }
        for(int i=s; i<=e; i++){
            int tmp = arr[i];
            arr[i] = arr[s];
            arr[s] = tmp;
            permutate(arr, s+1, e);
            tmp = arr[i];
            arr[i] = arr[s];
            arr[s] = tmp;
        }

        
    }
}