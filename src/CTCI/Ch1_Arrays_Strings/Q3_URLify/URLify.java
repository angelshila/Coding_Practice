package Q3_URLify;

import java.util.Arrays;

public class URLify {

    private static void replaceSpaces(char[] arr, int trueLength) {

        int spaces = 0;
        for (int i =0; i<trueLength;i++) {
            if (arr[i] == ' ') {
                spaces++;
            }
        }

        int index = trueLength + spaces*2;
        if (trueLength < arr.length) arr[trueLength] = '\0';
        for (int i = trueLength-1; i >= 0; i--) {

            if (arr[i] == ' ') {
                arr[index-1] = '0';
                arr[index-2] = '2';
                arr[index-3] = '%';
                index = index-3;
            } else {
                arr[index-1] = arr[i];
                index--;
            }

        }

    }


    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println(Arrays.toString(arr));
    }

}
