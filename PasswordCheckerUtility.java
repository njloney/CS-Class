
public class PasswordCheckerUtility {
	int count;
	int current = 0;
	public boolean isValidPassword(String P) throws Exception {
		if (P.length()<6) {
			throw passwordToShort;
			return false;
		}
		
		for (int i=0; i++; i < P.length()-1) {
			if((P.charAt(current)).isUpperCase() = false;) {
				throw noUpperCaseException;
				return false;
			}
			current++
		}
		
		current = 0;
		
		for (int i=0; i++; i < P.length()-1) {
			if((P.charAt(current)).isLowerCase() = false;) {
				throw noLowerCaseException;
				return false;
			}
			current++
		}
		
		current = 0;
		
		for (int i=0; i++; i < P.length()-1) {
			if((P.charAt(current)).isDigit() = false;) {
				throw noNumberException;
				return false;
			}
			current++
		}
		
		current = 0;
		
		for (int i=0; i++; i < P.length()-1) {
			if((P.charAt((current)).isDigit() && (P.charAt(current)).isLetter() && (P.charAt(current)).isWhiteSpace()) = false;) {
				throw noSpecialException;
				return false;
			}
			current++
		}

		    char currentChar = input.charAt(0);
		    count = 1;

		    for (int i = 1; i < P.length(); i++) {
		        char nextChar = P.charAt(i);

		        if (nextChar == currentChar) {
		            count++;
		            if (count > 2) {
		            	throw hasPatternException;
		                return false;
		            }
		        } else {
		            currentChar = nextChar;
		            count = 1;
		        }
		        
		    }
		    return true;
	}
	public boolean isWeakPassword(String P){
		if (P.length() > 6 && P.length() < 9) {
			return true;
		} else if{
			return false;
		}
		
	}
	public getInvalidPasswords(ArrayList<String> a) {
		
	}
}
