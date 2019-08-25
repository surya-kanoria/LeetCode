class Solution {
    public int myAtoi(String str) {
        int num = 0;
        boolean isNumberFound = true;
        boolean isNegative = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '-' && (i < str.length() - 1) && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9'){
                isNegative = true;
            }
            else if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                if(isNumberFound) {
                    continue;
                } else{
                    break;
                }
            } else {
                isNumberFound = true;
                int digit = Character.getNumericValue(str.charAt(i));
                num = (num * 10) + digit;
            }
        }
        if(isNegative == true){
            return (0 - num);
        } else {
            return num;
        }
    }
}