class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int start = 0, end = length1;
        int mid, mid2, partXLeft, partYLeft, partXRight, partYRight;
        while (start <= end) {
            mid = (start + end) / 2;
            mid2 = (length1 + length2 + 1) / 2 - mid;
            partXLeft = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            partXRight = (mid == length1) ? Integer.MAX_VALUE : nums1[mid];
            partYLeft = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            partYRight = (mid2 == length2) ? Integer.MAX_VALUE : nums2[mid2];
            if (partXLeft <= partYRight && partYLeft <= partXRight) {
                if ((nums1.length + nums2.length) % 2 != 0) {
                    return (double) Math.max(partXLeft, partYLeft);
                } else {
                    return ((double) (Math.max(partXLeft, partYLeft) + Math.min(partXRight, partYRight)) / 2);
                }
            } else if (partXLeft > partYRight) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}