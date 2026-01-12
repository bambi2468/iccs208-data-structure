public class Hidden {
    public static boolean isHidden(String s, String t) {
        int targetIdx = 0;
        int strIdx = 0;
        int targetCharCount = t.length();
        int strCharCount = s.length();
        int targetCharFound = 0;
        while (strIdx < strCharCount && targetIdx < targetCharCount) {
            System.out.println("compare "+targetIdx+":"+strIdx+" "+ t.charAt(targetIdx) +" & "+ s.charAt(strIdx));
            if (t.charAt(targetIdx) == s.charAt(strIdx)) {
                targetCharFound++;
                targetIdx++;
            }
            strIdx++;
        }
        System.out.println("targetCharFound: "+targetCharFound);
        return targetCharFound == targetCharCount;
    }

    public static void main(String[] args) {
        String s = "VhHTdipc07";
        String t = "hTc";
        System.out.println(isHidden(s, t));
    }
}
