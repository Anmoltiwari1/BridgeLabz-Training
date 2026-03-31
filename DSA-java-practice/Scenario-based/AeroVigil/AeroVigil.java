package AeroVigil;
public class AeroVigil {
    public static void main(String[] args){
        System.out.println(validateFlightNumber("FL-1000"));
    }

    public static boolean validateFlightNumber(String flightNumber){
     
            String f=flightNumber.substring(0,2);
            if(f.equals("FL")){
                String n=flightNumber.substring(3,flightNumber.length());
                int num=Integer.parseInt(n);
                
                if(num>1000 && num<=9999)
                    return true;
            }
            return false;
    }
}
