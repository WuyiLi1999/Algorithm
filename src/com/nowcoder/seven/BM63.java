package com.nowcoder.seven;

/**BM63:跳台阶
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 数据范围：1≤n≤40
 * 要求：时间复杂度：O(n)，空间复杂度： O(1)
 */
public class BM63 {
    //1. 递归遍历：时间复杂度：O(2^n) 空间复杂度：递归栈的空间
    //会进行大量的重复计算
    public int jumpFloor(int target) {
        if (target<=2){
            return target;
        }else
            return jumpFloor(target-1)+jumpFloor(target-2);
    }
    //2. 记忆搜索，保存之前的结果--时间复杂度O(n)，空间复杂度O(n)
    public int jumpFloor_1(int target) {
        int [] nums=new int[target];
        for (int i=0;i<target;i++){
            if (i<2)
                nums[i]=i+1;
            else
                nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[target-1];
    }
    //3. 动态规划+滑动数组(数组占两个位置，每一次向右滑动一个单位) --时间复杂度：O(n)，空间复杂度： O(1)
    public int jumpFloor_2(int target) {
        if(target<=2)
            return target;
        int [] nums=new int[2];
        int left=0;
        int right=1;
        nums[left]=1;
        nums[right]=2;
        for (int i = 2; i < target; i++) {
            nums[(right+1)%2]=nums[left]+nums[right];
            left=(left+1)%2;
            right=(right+1)%2;

        }
        return nums[right];
    }
}
