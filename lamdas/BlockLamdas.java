package lamdas;

interface StringInterface {
    String stringFunc(String s);
}
public class BlockLamdas {
    public static void main(String[] args) {
        StringInterface target;
        String s = "abcddcba";
        
        // checks if a string is pallindrome or not
        target = (str) -> {
            int i = 0;
            while (i < str.length() >> 1) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1))
                    return "\"" + str + "\" is not a pallindrome";
                i++;
            }
            return "\"" + str + "\" is a pallindrome";
        };

        System.out.println(target.stringFunc(s));

        // reverse a string
        target = (String str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        System.out.println(target.stringFunc(s));
    }
}
