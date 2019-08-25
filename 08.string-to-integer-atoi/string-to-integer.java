class Solution {
    public int myAtoi(String str) {
        int num = 0;
        boolean isNumberFound = false;
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && (i < str.length() - 1) && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9'
                    && isNumberFound == false) {
                isNegative = true;
            } else if (str.charAt(i) == '+' && (i < str.length() - 1) && str.charAt(i + 1) >= '0'
                    && str.charAt(i + 1) <= '9' && isNumberFound == false) {
                continue;
            } else if (isNumberFound == false && str.charAt(i) == ' ') {
                continue;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            } else {
                isNumberFound = true;
                int digit = Character.getNumericValue(str.charAt(i));
                if (num != 0) {
                    if (!isNegative && ((Integer.MAX_VALUE / num) < 10)
                            || (Integer.MAX_VALUE / num == 10 && digit >= Integer.MAX_VALUE % 10)) {
                        num = Integer.MAX_VALUE;
                        break;
                    } else if (isNegative && ((((Integer.MIN_VALUE + 1) / num) < 10)
                            || ((Integer.MIN_VALUE / num == 10) && (digit >= (Integer.MIN_VALUE % 10) * -1)))) {
                        System.out.println(((Integer.MIN_VALUE + 1) / num) + "," + i + "," + num);
                        num = Integer.MIN_VALUE;
                        break;
                    }
                }
                if (isNegative) {
                    num = num < 0 ? num : num * -1;
                    num = (num * 10) - digit;
                } else {
                    num = (num * 10) + digit;
                }
            }
        }
        return num;
    }
}