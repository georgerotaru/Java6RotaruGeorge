/*
 * With this class you can input text from keyboard and the program will try
 * to find if you entered any Romanian personal identification numbers
 */
package regexuri;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class uses regex to build a pattern and to test if it can be found
 * in a given text
 * @author George
 */
public class RegexTest {

    public static void main(String[] args) {
        // this sets the rules for searching within given text
        String regex = "\\b(1|2)[0-9]{2}(0)[1-9][0-2][0-9][0-4][0-9]{5}+\\b|"
                + "\\b(1|2)[0-9]{2}(0)[1-9](3)[0-1][0-4][0-9]{5}+\\b|"
                + "\\b(1|2)[0-9]{2}(1)(1|2)[0-2][0-9][0-4][0-9]{5}+\\b|"
                + "\\b(1|2)[0-9]{2}(1)(1|2)(3)[0-1][0-4][0-9]{5}+\\b";
        System.out.println("Regex or pattern to be searched: "+regex);
        // create a pattern using introduced regular expresion
        Pattern pattern = Pattern.compile(regex);
        // read the source string using a new Scanner object
        Scanner scannerSourceString = new Scanner(System.in);
        System.out.println("Insert source string: ");
        String source = scannerSourceString.nextLine();
        // create the matcher as result of applying regex on source string
        Matcher matcher = pattern.matcher(source);
        boolean found = false;
        // if the regular expression or pattern was found
        while (matcher.find()) {
        String result;
        result = String.format("I found text \"%s\" starting at " +
        "index %d until index %d.",
        matcher.group(),
        matcher.start(),
        matcher.end());
        System.out.println(result);
        found = true;
        }
        // if regular expression or pattern was not found in source string
        if (!found) {
        System.out.println("No match found :(");
        }
    }
}
