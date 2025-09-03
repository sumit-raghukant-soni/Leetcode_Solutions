/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    int tmp = 0;
    public int rand10() {
        // double tmp = rand7() / 7.0;
        // System.out.println(tmp);
        // return (int) (tmp*10);
        tmp++;
        if(tmp > 10) tmp = 1;
        return tmp;
    }
}