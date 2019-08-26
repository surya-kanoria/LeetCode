class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp;
        if (nums1.length == 0) {
            nums1 = nums2;
        } else if (nums2.length == 0) {
            nums2 = nums1;
        }
        if (nums1.length > nums2.length) {
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int size1 = nums1.length;
        int size2 = nums2.length;
        int totalSize = size1 + size2;
        int medianIndex = ((totalSize + 1) / 2) - 1;

        int low = 0, high = nums1.length - 1;
        int mid, midLarger, small1, small2, large1, large2;
        do {
            mid = (low + high) / 2;
            midLarger = medianIndex - mid;
            small1 = mid > 0 ? mid - 1 : mid;
            large1 = mid < (nums1.length - 1) ? mid + 1 : mid;
            small2 = midLarger > 0 ? midLarger - 1 : midLarger;
            large2 = midLarger < (nums2.length - 1) ? midLarger + 1 : midLarger;
            System.out.println(mid + "," + midLarger);
            System.out.println(small1 + "," + small2 + "," + large1 + "," + large2);
            if (nums1[small1] > nums2[large2]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if ((nums1[small1] <= nums2[large2]) && (nums1[large1] >= nums2[small2])) {
                break;
            }
        } while (mid < (size1 - 1));
        System.out.println(mid + "," + midLarger + "," + totalSize + "," + nums2[midLarger]);
        if (totalSize % 2 == 0) {
            System.out.println(nums1[mid] + "," + nums2[midLarger]);
            double total = (nums1[mid] + nums2[midLarger]);
            return total / 2;
        } else {
            double median = nums1[mid];
            return median;
        }
    }
}