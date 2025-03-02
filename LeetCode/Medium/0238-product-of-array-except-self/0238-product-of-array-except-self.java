class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        int tmp = 1;

        /** 왼쪽에서 시작 */
        for (int i = 0; i < nums.length; i++) {
            answers[i] = tmp;
            tmp *= nums[i];
        }
        
        /** 오른쪽에서 시작 */
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answers[i] *= tmp;
            tmp *= nums[i];
        }
        return answers;
    }
}