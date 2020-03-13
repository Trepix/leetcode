
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lastPosition = getFirstValue(nums1, nums2);
        int secondLastPosition = 0;

        int totalPositions = nums1.length + nums2.length;
        /*we only need to iterate through the half of the array
        cause both are sorted.
        */
        int maxIterations = ((totalPositions)/2) + 1;

        int i=0;
        int j=0;

        while(i + j < maxIterations && (i < nums1.length && j < nums2.length)){
            if(nums1[i]<nums2[j]) {
                secondLastPosition = lastPosition;
                lastPosition = nums1[i++];
            }
            else {
                secondLastPosition = lastPosition;
                lastPosition = nums2[j++];
            }
        }

        while(i + j < maxIterations && i<nums1.length) {
            secondLastPosition = lastPosition;
            lastPosition = nums1[i++];
        }

        while(i + j < maxIterations && j<nums2.length) {
            secondLastPosition = lastPosition;
            lastPosition = nums2[j++];
        }

        if(totalPositions %2 == 1)
            return lastPosition;
        else
            return (double)(lastPosition + secondLastPosition)/2;

    }

    private int getFirstValue(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return nums2[0];
        if (nums2.length == 0) return nums1[0];
        return Math.min(nums1[0], nums2[0]);


    }
}