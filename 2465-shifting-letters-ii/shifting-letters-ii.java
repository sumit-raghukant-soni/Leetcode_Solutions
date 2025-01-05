class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int sz = s.length(), sz2 = shifts.length;
        int j=0;
        int alpha[] = new int[sz];
        String ans = "";
        PriorityQueue<Integer> forward = new PriorityQueue<>(), backward = new PriorityQueue<>();

        Arrays.sort(shifts, (a, b) -> a[0] - b[0]);

        for(int i=0; i<sz; i++){
            alpha[i] = s.charAt(i) - 'a';
        }

        for(int i=0; i<sz; i++){
            while(j < sz2 && shifts[j][0] == i){
                if(shifts[j][2] == 1) forward.add(shifts[j][1]);
                else backward.add(shifts[j][1]);
                j++;
            }
            while(!forward.isEmpty() && forward.peek() < i){
                forward.poll();
            }
            while(!backward.isEmpty() && backward.peek() < i){
                backward.poll();
            }
            alpha[i] += (forward.size()%26) + (26 - backward.size()%26);
        }

        for(int i=0; i<sz; i++){
            ans += (char) ((alpha[i]%26) + 'a');
        }

        return ans;
    }
}