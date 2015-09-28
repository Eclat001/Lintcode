/* You are climbing a stair case. It takes n steps to reach to the top. Each time you can 
 * either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example  Given an example n=3 , 1+1+1=2+1=1+2=3   return 3
 * */
public class climbStair {
	/**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 0) {
            return 0;
        }
        int f1 = 1;
        int f2 = 2;
        if (n == 1) {
            return f1;
        }
        if (n == 2) {
            return f2;
        }
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
