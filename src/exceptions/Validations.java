package exceptions;

public class Validations {

    public void emptyString(String txt) throws expEmptyString {
        if ((txt.replace(" ", "") == "") || (txt == null) || (txt.isEmpty())) {
            throw new expEmptyString();
        }
    }
    
}
