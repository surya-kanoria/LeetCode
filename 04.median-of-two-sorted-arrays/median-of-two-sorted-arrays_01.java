class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] shorterArray;
        int totalSize = size1 + size2;
        int medianIndex = (totalSize + 1) / 2;
        if(size1 < size2) {
            shorterArray = nums1;
        } else {
            shorterArray = nums2;
        }
        int low = 0, high = shorterArray.length - 1;
        int mid, midLarger;
        do {
            mid = (low + high) / 2;
            int midLarger = medianIndex - mid;
            
        }

    }
}