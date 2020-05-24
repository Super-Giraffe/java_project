package LeetCode;

/**
 * 题目：旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */

public class Solution21 {
    public int minArray(int[] numbers) {
        if (numbers.length <= 0){
            return 0;
        }
        int start = 0;
        int end = numbers.length - 1;
        int mid = start;
        while (numbers[start] >= numbers[end]){
            mid = (start + end) / 2;
            if (start + 1 == end){
               mid = end;
               break;
            }
            if (numbers[start] == numbers[mid] && numbers[start] == numbers[end]){
                int result = numbers[start];
                for (int i = start; i <= end; i++){
                    if (numbers[i] < result){
                        result = numbers[i];
                    }
                }
                return result;
            }
            if (numbers[mid] >= numbers[start]){
                start = mid;
            }else {
                if (numbers [mid] <= numbers[end]){
                    end = mid;
                }
            }
        }
        return numbers[mid];
    }
}
