package easy;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 1.递归
 * 2.数组循环
 * 3.黄金分割数
 *
 *
 * @author shc
 * @date 2020-09-06
 */
public class Fibonacci {

    public static int fib(int t){
        if(t == 0){
            return  0;
        }
        if( t == 1){
            return 1;
        }
        return  fib(t-1) + fib(t-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
