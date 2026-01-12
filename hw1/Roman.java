public class Roman {
    public static int valueRoman(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static int romanToInt(String romanNum) {
        int total = 0;
        int length = romanNum.length();

        for (int i = 0; i < length; i++) {
            int currentNum = valueRoman(romanNum.charAt(i));

            if (i + 1 < length) {
                int nextNum = valueRoman(romanNum.charAt(i + 1));

                if (currentNum < nextNum) {
                    total = total - currentNum;
                } else {
                    total = total + currentNum;
                }
            } else {
                total = total + currentNum;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXC"));
    }
}
