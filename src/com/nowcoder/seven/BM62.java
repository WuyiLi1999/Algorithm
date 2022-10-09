package com.nowcoder.seven;

/**BM62:斐波那契数列——动态规划
 * 输入一个数字小标，返回该下标所对饮的数列值
 *要求：空间复杂度 O(1)，时间复杂度 O(n)，本题也有时间复杂度 O(logn)的解法
 */
public class BM62 {
    //空间复杂度 O(1)，时间复杂度 O(n)
    public int Fibonacci(int n) {
        //定义两个数字分别用来保存数列中的f(x-1)--b、f(x-2)--a
        int a=1,b=1;
        //用于保存最后的结果--初始值为1
        int result=1;
        //循环计算第n个位置的值
        for (int i = 2; i < n; i++) {
            result=a+b;
            a=b;
            b=result;
        }
        return result;
    }
    //递归遍历---时间复杂度 O(2^n)，空间复杂度 ：递归栈的空间
    public int Fibonacci_1(int n) {
        //递归终止条件：当递归到数列第1项或是第0项的时候，可以直接返回数字。
        if (n<=1)
            return n;
        // 获取本级数列值：即前两项相加。
        else
            return Fibonacci_1(n-1)+Fibonacci_1(n-2);
    }
}
