class Solution {
    public int maxArea(int[] a) {
        int length = a.length;
        int minLeft = 0, posLeft = 0;
        int minRight = 0, posRight = 0;
        for (int i = 0; i < length; i++) {
            if ((a[i] - i > minLeft)) {
                posLeft = i;
                minLeft = a[i] - i;
            }
            if ((a[i]) + i >= minRight) {
                posRight = i;
                minRight = a[i] + i;
            }
        }
        System.out.println(posLeft + "," + posRight);
        if (posLeft < posRight) {
            return (Math.min(a[posLeft], a[posRight]) * (posRight - posLeft));
        } else {
            int minimum_left = 0;
            int position_left = 0;
            for (int i = 0; i < posRight; i++) {
                if ((a[i] - i > minimum_left)) {
                    position_left = i;
                    minimum_left = a[i] - i;
                }
            }
            int containerLeft = (Math.min(a[position_left], a[posRight]) * (posRight - position_left));
            int minimum_right = 0, position_right = 0;
            for (int i = posLeft + 1; i < length; i++) {
                if ((a[i]) + i >= minimum_right) {
                    position_right = i;
                    minimum_right = a[i] + i;
                }
            }
            int containerRight = (Math.min(a[position_right], a[posLeft]) * (position_right - posLeft));
            return Math.max(containerLeft, containerRight);
        }
    }
}