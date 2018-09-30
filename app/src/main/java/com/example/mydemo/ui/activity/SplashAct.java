package com.example.mydemo.ui.activity;

/**
 * @Author yinfx
 * @Date 2018/9/27
 * @Description
 */
public class SplashAct {

    public static void main(String[] args) {


        //10000000(别数了2千万)内，素数有664579个，查找用时2185毫秒
        int maxNum = 200000000;
        testSushu(maxNum);

    }

    /**
     * @Title testSushu
     * @Description 比1大的整数中,除了1和它本身以外,不再有别的因数,这种整数叫做质数或素数
     * @param maxNum 最大值范围
     */
    private static void testSushu(int maxNum) {
        long t = System.currentTimeMillis();
        boolean[] primes = new boolean[maxNum + 1]; // 质数数组

        // 初始化所有数字为true
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        //筛法主要的思路是:
        //对于这么多数，如果一个数是素数的倍数，那么那个数肯定不是素数。
        //所以从k=2开始，将数组中2的倍数（不包括2）的布尔值改为false，代表它们不是素数，
        //然后k=3，进行一次筛选,k=5，进行一次筛选。。。。
        //一直遍历到k的平方根为止，剩下的留在数组中的数就是素数
        for (int k = 2; k <= maxNum / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= maxNum / k; i++) {
                    primes[k * i] = false; // k * i is not prime
                }
            }
        }

        final int NUMBER_PER_LINE = 30; // 一行显示10个数字
        int count = 0; // 到目前为止找到的质数数量
        // 打印质数
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
                /*if (count % NUMBER_PER_LINE == 0)
                    System.out.printf("%8d\n", i);
                else
                    System.out.printf("%8d", i);*/
            }
        }
        System.out.println("\n质数数量【" + count + "】个");
        long diff = System.currentTimeMillis() - t;
        System.out.println("计算用时【" + diff + "】毫秒");
    }

}
