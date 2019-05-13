package exceptions;

import java.io.File;

public class Validations {

    public void emptyString(String txt) throws expEmptyString {
        if ((txt.replace(" ", "") == "") || (txt == null) || (txt.isEmpty())) {
            throw new expEmptyString();
        }
    }
    
    public static boolean existFile(String path) {
        return (new File(path).exists());
    }
    
}
