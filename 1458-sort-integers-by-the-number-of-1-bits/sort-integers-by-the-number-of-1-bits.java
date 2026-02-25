class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, (a, b) -> {
            if(Integer.bitCount(a) == Integer.bitCount(b)) return a - b;
            return Integer.bitCount(a) - Integer.bitCount(b);
        });

        return Arrays.stream(arr2).mapToInt(i -> i).toArray();
    }
}