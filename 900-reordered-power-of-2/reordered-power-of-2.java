class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] tmp = (String.valueOf(n)).toCharArray();
        Arrays.sort(tmp);
        String org = new String(tmp);
        List<String> lst = new ArrayList<>();

        for(int i=0; i<=50; i++){
            long val = (long) Math.pow(2, i);
            if(val <= Integer.MAX_VALUE){
                tmp = (String.valueOf(val)).toCharArray();
                Arrays.sort(tmp);
                lst.add(new String(tmp));
            }
        }

        // System.out.println(lst);

        return lst.contains(org);
    }
}