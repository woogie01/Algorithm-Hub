class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];
        /** 양쪽에서 기준 중심점 방향으로 찾아가기*/ 
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            /** 빗물이 고이기 위해서는 현재 높이가 이전 높이보다 낮아야 한다 */
            if (leftMax <= rightMax) {
                answer += (leftMax - height[left]);
                left++;
            } else {
                answer += (rightMax - height[right]);
                right--;
            }
        }
        return answer;
    }
}