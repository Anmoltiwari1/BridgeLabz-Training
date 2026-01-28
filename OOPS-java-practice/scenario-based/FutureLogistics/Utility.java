public class Utility {
    
    public GoodsTransport parseDetails(String input) {
        String[] parts = input.split(":");
        
        String transportId = parts[0];
        String transportDate = parts[1];
        int transportRating = Integer.parseInt(parts[2]);
        String transportType = parts[3];
        
        if (transportType.equalsIgnoreCase("BrickTransport")) {
            float brickSize = Float.parseFloat(parts[4]);
            int brickQuantity = Integer.parseInt(parts[5]);
            float brickPrice = Float.parseFloat(parts[6]);
            
            return new BrickTransport(transportId, transportDate, transportRating, 
                                    brickSize, brickQuantity, brickPrice);
        } else if (transportType.equalsIgnoreCase("TimberTransport")) {
            float timberLength = Float.parseFloat(parts[4]);
            float timberRadius = Float.parseFloat(parts[5]);
            String timberType = parts[6];
            float timberPrice = Float.parseFloat(parts[7]);
            
            return new TimberTransport(transportId, transportDate, transportRating,
                                     timberLength, timberRadius, timberType, timberPrice);
        }
        
        return null;
    }
    
    public boolean validateTransportId(String transportId) {
        if (transportId.length() != 7) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        
        if (!transportId.substring(0, 3).equals("RTS")) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        
        String digits = transportId.substring(3, 6);
        for (char c : digits.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Transport id " + transportId + " is invalid");
                return false;
            }
        }
        
        char lastChar = transportId.charAt(6);
        if (!Character.isUpperCase(lastChar)) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        
        return true;
    }
    
    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        } else if (goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }
        return "";
    }
}