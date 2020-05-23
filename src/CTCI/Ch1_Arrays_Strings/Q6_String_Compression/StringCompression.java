package Q6_String_Compression;

public class StringCompression {

    private static String compress(String str) {

        if(str.isEmpty())
            return str;

        StringBuilder sb = new StringBuilder();
        int charCount =1;
        int i = 0, j =1;

        while (j<str.length()) {

            if(str.charAt(i)!=str.charAt(j)){
                sb.append(str.charAt(i));
                sb.append(charCount);
                charCount = 1;
            }
            else {
                charCount++;
            }
            i++;
            j++;
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(charCount);

        return str.length()<sb.toString().length()?str:sb.toString();
    }



    public static void main(String[] args) {
        String str = "a";
        System.out.println(str);
        System.out.println(compress(str));
    }


}
