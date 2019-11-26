package Q5_oneEditAway;

public class OneEditAway {

    private static boolean oneEditAway(String a, String b) {

        if (Math.abs(a.length() - b.length())>1)
            return false;
        //s1 is short and s2 is long
        String s1= a.length() > b.length() ? b:a;
        String s2 = a.length() > b.length()?a:b;

        int i = 0,j =0;
        boolean foundDiff = false;

        while (i<s1.length() && j<s2.length()) {

            if(s1.charAt(i)!=s2.charAt(j)){
                if(foundDiff)
                    return false;
                foundDiff = true;
                if(s1.length() == s2.length())
                    i++;
            } else {
                i++;
            }
            j++;
        }
        return true;


    }

    public static void main(String[] args) {
        String a = "palee";
        String b = "pale";
        boolean isOneEdit1 = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit1);

        String c = "pale";
        String d = "pkle";
        boolean isOneEdit2 = oneEditAway(c, d);
        System.out.println(c + ", " + d + ": " + isOneEdit2);
        String e = "pal";
        String f = "pkle";
        boolean isOneEdit3 = oneEditAway(e, f);
        System.out.println(e + ", " + f + ": " + isOneEdit3);
    }


}
