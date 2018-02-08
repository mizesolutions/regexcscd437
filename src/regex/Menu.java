package regex;

import java.util.Scanner;

public class Menu {

//    a. Social Security Number
//    b. US Phone number
//    c. E-mail address
//    d. Name on a class roster, assuming one or more middle initials - Last name, First name, MI
//    e. Date in MM-DD-YYYY format
//    f. House address - Street number, street name, abbreviation for road, street, boulevard or avenue
//    g. City followed by state followed by zip as it should appear on a letter
//    h. Military time, including seconds
//    i. US Currency down to the penny (ex: $123,456,789.23)
//    j. URL, including http:// (upper and lower case should be accepted)
//    k. A password that contains at least 10 characters and includes at least one upper case character, lower case character, digit, punctuation mark, and does not have more than 3 consecutive lower case characters
//    l. All words containing an odd number of alphabetic characters, ending in "ion"
//    q. quit

    private Scanner hid;
    private String userChoice;
    private String userInput;
    private String validMenuOptions;
    private FileUtils file;
    private Boolean quit;
    private Regex regex;
    private String verbose;

    public Menu (String args) {
        setHid();
        setUserChoice("");
        setUserinput("");
        setValidMenuOptions("[a-lq]");
        setFile("mizeb_regexOutput.txt");
        setQuit(false);
        setRegex(getUserInput(), getUserChoice());
        setVerbose(args);
    }

    public Scanner getHid() {
        return this.hid;
    }
    public void setHid() {
        hid = new Scanner(System.in);
    }
    public String getUserChoice() { return this.userChoice; }
    public void setUserChoice(String value) { this.userChoice = value;}
    public String getUserInput(){
        return this.userInput;
    }
    public void setUserinput(String value) {
        userInput = value;
    }
    public String getValidMenuOptions() {
        return this.validMenuOptions;
    }
    public void setValidMenuOptions(String value){
        this.validMenuOptions = value;
    }
    public FileUtils getFile() { return this.file; }
    public void setFile(String value) { this.file = new FileUtils(value); }
    public boolean getQuit() { return this.quit; }
    public void setQuit(Boolean value) { this.quit = value; }
    public Regex getRegex() { return this.regex; }
    public void setRegex(String value, String type) { this.regex = new Regex(value, type);}
    public String getVerbose() { return this.verbose; }
    public void setVerbose(String value) { this.verbose = value; }

    public void run() {
        if(isVerbose())
            displayMenu();
        while (!getQuit()) {
            if(isVerbose())
                System.out.print(">> Enter selection: ");
            readUserInput();
            if(getUserInput().toLowerCase().equals("-m"))
                displayMenu();
            else if(getUserInput().toLowerCase().equals("q"))
                setQuit(true);
            else if (validMenuChoice()) {
                setUserChoice(getUserInput());
                getFile().writeInFile("\n" + getUserInput() + "\n");
                regexInput();
                getFile().writeInFile(getUserInput() + "\n");
                if(getRegex().start(getUserChoice(), getUserInput())) {
                    if(isVerbose())
                        System.out.println("Valid");
                    getFile().writeInFile("Valid");
                } else {
                    if(isVerbose())
                        System.out.println("Invalid");
                    getFile().writeInFile("Invalid");
                }
            } else {
                if(isVerbose())
                    System.out.println("Invalid selection: " + getUserInput() + "-m to display menu or q to quit\n");
                getFile().writeInFile("Invalid selection: " + getUserInput() + "\n");
            }
        }
        if(isVerbose())
            System.out.println("\n Thanks for playing \n\n\n\n");
        getFile().writeInFile("\nEnd of test\n");
        getFile().closeFileUtils();
        if(!isVerbose())
            System.out.println("\n >> Test results have been saved to mizeb_regexOutput.txt\n");
    }

    private void displayMenu() {
        System.out.print("\n\n" +
                "=========================================================================================\n" +
                "======  RegEx Test Options         ======================================================\n"+
                "=========================================================================================\n" +
                "                                                                                        \n" +
                "     a. Social Security Number                                                          \n" +
                "     b. US Phone number                                                                 \n" +
                "     c. E-mail address                                                                  \n" +
                "     d. Name on a class roster, assuming one or more middle initials                    \n" +
                "        Last name, First name, MI                                                       \n" +
                "     e. Date in MM-DD-YYYY format                                                       \n" +
                "     f. House address - Street number, street name, abbreviation for road, street,      \n" +
                "        boulevard or avenue                                                             \n" +
                "     g. City followed by state followed by zip as it should appear on a letter          \n" +
                "     h. Military time, including seconds                                                \n" +
                "     i. US Currency down to the penny (ex: $123,456,789.23)                             \n" +
                "     j. URL, including http:// (upper and lower case should be accepted)                \n" +
                "     k. A password that contains at least 10 characters and includes at least one       \n" +
                "        upper case character, lower case character, digit, punctuation mark, and        \n" +
                "        does not have more than 3 consecutive lower case characters                     \n" +
                "     l. All words containing an odd number of alphabetic characters, ending in \"ion\"  \n" +
                "                                                                                        \n" +
                "     q. quit                                                                            \n" +
                "                                                                                        \n" +
                "    -m  to display menu                                                                 \n" +
                "                                                                                        \n");
    }

    private void readUserInput() {
        if (getHid() != null){
            if (getHid().hasNext()){
                setUserinput(getHid().nextLine());
            }
        } else {
            if(isVerbose())
                System.out.println("Scanner error\n");
        }
    }

    private boolean validMenuChoice() {
        if (!getUserInput().isEmpty() || getUserInput().length() > 0)
            return getUserInput().matches(getValidMenuOptions());
        else
            return false;
    }

    private void regexInput() {
        if(isVerbose())
            System.out.print("Enter data to validate: ");
        readUserInput();
    }

    private Boolean isVerbose() {
        return getVerbose().equals("-v");
    }

} //class
