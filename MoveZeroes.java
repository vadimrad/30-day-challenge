/* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations. */

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        
        while (end < nums.length) {
            if (nums[end] != 0) {
                nums[start] = nums[end];
                start++;
            }
            end++;
        }
        
        while (start < nums.length) {
            nums[start] = 0;
            start++;
        }
    }
}
