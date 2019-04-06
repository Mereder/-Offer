public class ReplaceWhitespace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (Character.isWhitespace(a)){
                temp.append("%20");
                continue;
            }
            temp.append(a);
        }
        return temp.toString();
    }

}
