import java.util.ArrayList;

class Solution {
    public int maximumSwap(int num) {
        int[] reverseDigits = new int[100];
        int size = 0;
        int temp = num;
        while (temp != 0) {
            reverseDigits[size] = temp % 10;
            size++;
            temp = temp / 10;
        }
        int[] digits = new int[100];
        int pos = 0;
        for (int i = size - 1; i >= 0; i--) {
            digits[pos] = reverseDigits[i];
            pos++;
        }
        int maxPos = size - 1;
        int swapIndex = -1;
        int maxSwapIndex = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] > digits[maxPos]) {
                maxPos = i;
            }
            if (digits[i] != digits[maxPos]) {
                swapIndex = i;
                maxSwapIndex = maxPos;
            }
        }
        if (swapIndex == -1) {
            return num;
        } else {
            temp = digits[swapIndex];
            digits[swapIndex] = digits[maxSwapIndex];
            digits[maxSwapIndex] = temp;
            int res = 0;
            for (int i = 0; i < size; i++) {
                res = res * 10 + digits[i];
            }
            return res;
        }
    }
}