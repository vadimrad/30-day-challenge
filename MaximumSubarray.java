/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. */

class MaximumSubarray {
    //accumulate sum
    public int maxSubArray(int[] nums) {
        
        
        int max = nums[0];
        int current = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
    
   
    
}

class DivideConq {
    public int maxSubArray(int[] nums) {
        return maxSubArrRecr(nums, 0, nums.length - 1);
    }
    
    public int maxSubArrRecr(int[] nums, int l, int r)
    {
        if (l == r) return nums[l];
        int mid = l + (r - l)/2;
       
        int maxSubLeft = maxSubArrRecr(nums, l, mid);
        int maxSubRight = maxSubArrRecr(nums, mid+1, r);
        int maxSingleSide = Math.max(maxSubLeft, maxSubRight);
       
        int sum = 0;
        int maxRightFromMid = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= r; ++i)
        {
            sum += nums[i];
            maxRightFromMid = Math.max(maxRightFromMid, sum);
        }
        
        sum = 0;
        int maxLeftEndMid = Integer.MIN_VALUE;
        for(int i = mid; i >= l; --i)
        {
            sum += nums[i];
            maxLeftEndMid = Math.max(maxLeftEndMid, sum);
        }
        
        return Math.max(maxSingleSide, maxRightFromMid + maxLeftEndMid);
    }   
