package other;

/**
 * 约瑟夫环问题：三种解法
 * <p>
 * 已知 n 个人（以编号1，2，3 … n 分别表示）围成一圈。从编号为 1 的人开始报数，数到 m 的那个人出列；
 * 他的下一个人又从 1 开始报数，数到 m 的那个人又出列；依此规律重复下去，直到最后剩下一个人。要求找出最后出列的人的编号；
 *
 * @author shc
 * @date 2020-09-08
 */
public class YueSheFu {

    /**
     * 利用数组
     */
    public static int first(int n, int m) {
        int[] peoples = new int[n];
        for (int i = 1; i <= n; i++) {
            peoples[i - 1] = i;
        }
        // 数组中剩余的人
        int theRest = n;
        // 计数器加1
        int count = 0;
        // 数组索引位置
        int index = 0;

        while (theRest > 1) {
            if (peoples[index] > 0) {
                //说明还没有被淘汰 计数器加1
                count++;
                if (count == m) {
                    // 计数器归0
                    count = 0;
                    //此人被淘汰
                    peoples[index] = -1;
                    // 剩余人数-1
                    theRest--;
                }
            }
            index++;
            //当当前人等于总人数时，则又从第一人开始计数
            if (index == n) {
                index = 0;
            }

        }

        int resut = 0;
        for (int j = 0; j < n; j++) {
            if (peoples[j] > 0) {
                resut = peoples[j];
                break;
            }
        }
        return resut;
    }

    /**
     * 单向循环链表
     */
    public static int second(int n, int m) {
        return 0;
    }

    /**
     * 利用公式
     * f(n,m)=(f(n−1,m)+m)%n
     * <p>
     * 如果编号从 0 开始，则最后的返回值表示的是数组的下标，要想得到编号，最终的返回结果还需要加 1
     */
    public static int third(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (third(n - 1, m) + m) % n;
    }


    public static void main(String[] args) {
        System.out.println(first(10, 3) + "第一种方法");
        System.out.println(third(10, 3) +1 + "第三种方法");
    }
}
