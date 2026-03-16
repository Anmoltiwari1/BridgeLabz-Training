import java.time.LocalDate;

public class GlobalShipment {
    public static void main(String[] args){


        String input="SHIP-789012|2004-02-29|ROAD|0.75|IN_TRANSIT";
        
        String[] line=input.split("\\|");
        
        String ship=line[0];
        String date=line[1];
        String mode=line[2];
        String weight=line[3];
        String dil=line[4];

        if(checkSHIP(ship) && checkDATE(date) && checkMODE(mode) && checkWEIGHT(weight) && checkDIL(dil))
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static boolean checkSHIP(String ship){

        String SHIP = "^SHIP-[1-9][0-9]{5}$";

        return ship.matches(SHIP);
    }


    public static boolean checkDATE(String DATE){

        try{
            LocalDate.parse(DATE);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static boolean checkMODE(String mode){
        String MODE = "^(AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT)$";

        return mode.matches(MODE);
    }

    public static boolean checkWEIGHT(String weight){
        String WEIGHT = "^([0-9]{0,6}\\.[0-9]{2})$";
        return weight.matches(WEIGHT);
    }

    public static boolean checkDIL(String Dilvery){
        String DILIVERY = "^(DELIVERED|CANCELLED|IN_TRANSIT)$";
        return Dilvery.matches(DILIVERY);
    }
}
