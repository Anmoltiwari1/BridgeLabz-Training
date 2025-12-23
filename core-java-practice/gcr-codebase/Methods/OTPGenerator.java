public class OTPGenerator {
    public static int generateSixDigitOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] otps = new int[10];
        
        System.out.println("Generating 10 six-digit OTPs:");
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateSixDigitOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        
        boolean isUnique = areOTPsUnique(otps);
        
        System.out.println("\nValidation Results:");
        System.out.println("All OTPs are unique: " + isUnique);
        
        if (!isUnique) {
            System.out.println("Duplicate OTPs found!");
            for (int i = 0; i < otps.length; i++) {
                for (int j = i + 1; j < otps.length; j++) {
                    if (otps[i] == otps[j]) {
                        System.out.println("Duplicate: OTP " + (i + 1) + " and OTP " + (j + 1) + " both have value " + otps[i]);
                    }
                }
            }
        } else {
            System.out.println("All 10 OTPs are unique - validation successful!");
        }
    }
}
