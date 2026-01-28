public class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;
    
    public TimberTransport(String transportId, String transportDate, int transportRating,
                          float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }
    
    public float getTimberLength() {
        return timberLength;
    }
    
    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }
    
    public float getTimberRadius() {
        return timberRadius;
    }
    
    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }
    
    public String getTimberType() {
        return timberType;
    }
    
    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }
    
    public float getTimberPrice() {
        return timberPrice;
    }
    
    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }
    
    public String vehicleSelection() {
        float area = 2 * 3.147f * timberRadius * timberLength;
        
        if (area < 250) {
            return "Truck";
        } else if (area >= 250 && area <= 400) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }
    
    public float calculateTotalCharge() {
        float volume = 3.147f * timberRadius * timberRadius * timberLength;
        
        float typeMultiplier = 0;
        if (timberType.equalsIgnoreCase("Premium")) {
            typeMultiplier = 0.25f;
        } else if (timberType.equalsIgnoreCase("NonPremium")) {
            typeMultiplier = 0.15f;
        }
        
        float price = volume * timberPrice * typeMultiplier;
        float tax = price * 0.3f;
        
        String vehicle = vehicleSelection();
        float vehiclePrice = 0;
        if (vehicle.equalsIgnoreCase("Truck")) {
            vehiclePrice = 1000;
        } else if (vehicle.equalsIgnoreCase("Lorry")) {
            vehiclePrice = 1700;
        } else if (vehicle.equalsIgnoreCase("MonsterLorry")) {
            vehiclePrice = 3000;
        }
        
        float discount = 0;
        if (transportRating == 5) {
            discount = price * 0.20f;
        } else if (transportRating == 3 || transportRating == 4) {
            discount = price * 0.10f;
        }
        
        return (price + vehiclePrice + tax) - discount;
    }
}