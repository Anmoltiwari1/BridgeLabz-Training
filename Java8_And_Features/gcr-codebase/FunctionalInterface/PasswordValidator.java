public interface SecurityUtils {
    static boolean isPasswordStrong(String password) {
        if (password.length() < 8) return false;
        
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }
        
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {"weak", "StrongPass123!", "NoSpecial123", "nouppercasepass!"};
        
        for (String password : passwords) {
            System.out.println(password + " is " + 
                (SecurityUtils.isPasswordStrong(password) ? "strong" : "weak"));
        }
    }
}