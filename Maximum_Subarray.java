// Problem statement: Given an integer array nums, find the subarray with the largest sum, and return its sum.




//Brute Force Approach
//Time complexity  = O(N^2)
//Space Complexity = O(1)


class Solution {
    public int maxSubArray(int[] nums) {

        int MAX_SUM = Integer.MIN_VALUE;
        int n = nums.length;

        //Iterate over the array and then inside the inner loop try all possible sub arrays and it's sum, and capture the subarray with maximum sum.
        for(int start = 0; start < n; start++) {
            //currSubSum variable keeps track of the current subarray sum.
            int currSubSum = 0;

            for(int end = start; end < n; end++) {
                //Adding one element in current subarray.
                currSubSum+=nums[end];
                //Check is current subarray sum is more than previously captured MAX_SUM, if so then we update it.
                if(currSubSum > MAX_SUM) {
                    MAX_SUM = currSubSum;
                    //If we need to return the subarray also then we can use the start and end indices.
                    System.out.println("Start index: " + start + " ,End index: " + end);
                }
            }
        }
        
        return MAX_SUM;
    }
}






