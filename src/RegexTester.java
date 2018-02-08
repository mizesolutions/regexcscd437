import regex.*;

/**
 * This program offers the user the opportunity to test twelve different common data
 * types for validity using predefined regular expressions.
 *
 * There are two modes of operation available to the user:
 *
 *      Default: Assumes the user will either be testing by redirecting a file of test
 *               data to the program, or they know what the menu options are and do
 *               not require prompting.
 *
 *               ex: $ java RegexTester < testData
 *
 *      Verbose: To run the program with prompting turned on, the user must run the
 *               program with the -v flag
 *
 *               ex:  $ java RegexTester -v
 *
 * Both modes automatically save the test results to the file mizeb_regexOutput.txt
 * in the directory from where the program is run. If the program is run from an IDE,
 * user will need to check to see where the results are saved.
 *
 */

public class RegexTester {

    public static void main(String[] args) {
        String verbose = "";

        if (args.length > 0)
            verbose = args[0];

        Menu menu = new Menu(verbose);

        menu.run();

    } // main

} // class
