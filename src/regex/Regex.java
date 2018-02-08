package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Used https://regexr.com/ to help build and test patterns.
 *
 * Email regex sourced from:
 *
 *
 */

public class Regex {

    private final String SSN = "^([000-999]){3}(-|\\s)?([00-99]){2}(-|\\s)?([0000-9999]){4}$";
    private final String PHN = "^(1{1})?(\\+|\\s|\\.|-)?(\\(|\\s)?([000-999]){3}(\\)|\\s|-|\\.)?([000-999]){3}(\\s|-|\\.)?([0000-9999]){4}$";
    private final String EML = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;";
    private final String NME = "^([A-Z]{1}[a-z]+,\\s){2}([A-Z]{1}\\s?)*$";
    private final String DAT = "^(0[1-9]|1[012])[-\\/](0[1-9]|[12][0-9]|3[01])[-\\/](19|20)\\d\\d$";
    private final String ADD = "";
    private final String CSZ = "";
    private final String MIL = "";
    private final String CUR = "";
    private final String URL = "";
    private final String PWD = "";
    private final String ION = "";


    private String type;
    private String value;


    public Regex (String pType, String pValue) {
        setType(pType);
        setValue(pValue);
    }

    public String getType() { return this.type; }
    public void setType(String pType) { this.type = pType; }
    public String getValue() { return this.value; }
    public void setValue(String pValue) { this.value = pValue; }

    public Boolean start(String pType, String pValue) {
        if(!pType.isEmpty() || pType.length() > 0)
            setType(pType);
        if(!pValue.isEmpty() || pValue.length() > 0)
            setValue(pValue);

        switch(getType()) {
            case "a": return matchValue(SSN);
            case "b": return matchValue(PHN);
            case "c": return matchValue(EML);
            case "d": return matchValue(NME);
            case "e": return matchValue(DAT);
            case "f": return matchValue(ADD);
            case "g": return matchValue(CSZ);
            case "h": return matchValue(MIL);
            case "i": return matchValue(CUR);
            case "j": return matchValue(URL);
            case "k": return matchValue(PWD);
            case "l": return matchValue(ION);
            default: return false;
        }

    }

    private Boolean matchValue(String regex) {
        return getValue().matches(regex);

//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(getValue());
//        return m.matches();
    }

/**

 email: (?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
 source: http://emailregex.com/

 email: ^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$
 source: https://www.journaldev.com/638/java-email-validation-regex

 Name: (\s?[A-Za-z]*\,)(\s[A-Za-z])*

 Date: ([0-1]{1}[0-2]{1})+([-\/]{1})+([0-3]{1}[0-9]{1})+([-\/]{1})+([0-9]{4})

 */

} // class

