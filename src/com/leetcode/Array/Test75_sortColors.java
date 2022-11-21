package com.leetcode.Array;

//75:给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，
// 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
public class Test75_sortColors {
    //方式一：计数排序 时间复杂度O(kn)，空间复杂度O(1)
    public void sortColors(int[] nums) {
        int [] count=new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int k=0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++]=i;
            }
        }
    }
    //方式二：三路快排--双指针思想
    public void sortColors_ByQuick(int[] nums) {
        int zero=-1;//nums[0...zero]中保存0 zero是排好序数组中元素0的末位位置（起始值为-1）
        int two=nums.length;//nums[two...n-1]中保存的是2 two是排好序数组中值为2的起始位置（起始值为数组长度n）
        for (int i = 0; i < two;) {
            //当前元素为1，继续遍历下一个元素
            if (nums[i]==1){
                i++;
            }else if (nums[i]==0){
                //当前元素为0，将改位置的元素与num[++zero]的元素交换，交换完成之后i位置等于1，zero位置等于0
                int temp=nums[i];
                nums[i]=nums[++zero];
                nums[zero]=temp;
                i++;
            }else if (nums[i]==2){
                //当前元素为2，将当前元素nums[--two]元素交换，交换完之后nums[i]值为未判断的元素，nums[two]值为2
                int temp=nums[i];
                nums[i]=nums[--two];
                nums[two]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums={0,2,1,0,0,2,1,1,0,2};
        new Test75_sortColors().sortColors_ByQuick(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
    }
}
