package easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 1---1;2---2;3---3;4---5;5---8;
 *
 * @author shc
 * @date 2019-04-11
 **/
public class ClimbStairs {

    /**
     * 自己写的，程序结果还是正确的，可惜超出时间限制。QAQ
     *
     * @param n
     * @return
     */
    public static int getN(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getN(n - 1) + getN(n - 2);
    }

    /**
     * 暴力法
     * 在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。而在每一步中我们都会继续调用 climbStairsclimbStairs 这个函数
     * 模拟爬 11 阶和 22 阶的情形，并返回两个函数的返回值之和。
     * <p>
     * climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)
     * <p>
     * 其中 ii 定义了当前阶数，而 nn 定义了目标阶数。
     *
     * @param i
     * @param n
     * @return
     */
    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public static void main(String[] args){
        // 这两种方式太慢了
        System.out.println(climb_Stairs(0,30));
        System.out.println(getN(30));
    }


}
