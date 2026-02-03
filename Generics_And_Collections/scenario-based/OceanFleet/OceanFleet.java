import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vessel{

    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    Vessel(){
    }

    Vessel(String vesselId,String vesselName,double averageSpeed,String vesselType){
        this.vesselId=vesselId;
        this.vesselName=vesselName;
        this.averageSpeed=averageSpeed;
        this.vesselType=vesselType;
    }

    public String getVesselId(){
        return vesselId;
    }
    public String getVesselName(){
        return vesselName;
    }
    public double getAverageSpeed(){
        return averageSpeed;
    }
    public String getVesselType(){
        return vesselType;
    }
    public void setVesselId(String vesselId){
        this.vesselId=vesselId;
    }
    public void setVesselName(String vesselName){
        this.vesselName=vesselName;
    }
    public void setAverageSpeed(double averageSpeed){
        this.averageSpeed=averageSpeed;
    }
    public void setVesselType(String vesselType){
        this.vesselType=vesselType;
    }

}

class VesselUtil{

    private List<Vessel> vesselList=new ArrayList<>();

    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId){

        for(Vessel vessel:vesselList){
            if(vessel.getVesselId().equals(vesselId)){
                return vessel;
            }
        }

        return null;
    }

    public List<Vessel> getHighPerformanceVessels(){
        List<Vessel> HighestAverageSpeed =new ArrayList<>();

        double highestAverageSpeed=Double.MIN_VALUE;

        for(Vessel vessel:vesselList){
            if(vessel.getAverageSpeed()>highestAverageSpeed){
                highestAverageSpeed=vessel.getAverageSpeed();
            }
        }

        for(Vessel vessel:vesselList){
            if(vessel.getAverageSpeed()==highestAverageSpeed){
                HighestAverageSpeed.add(vessel);
            }
        }

        return HighestAverageSpeed;
    }
}

public class OceanFleet {
    public static void main(String[] args) {
        VesselUtil vesselUtil=new VesselUtil();

        List<Vessel> HighestAverageSpeed=new ArrayList<>();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vessels");
        int n=sc.nextInt();
        sc.nextLine();


        System.out.println("Enter the vessel details in format vesselId:vesselName:averageSpeed:vesselType");
        for(int i=0;i<n;i++){
        String vesselDetail=sc.nextLine();

        String[] parts=vesselDetail.split(":");

        String vesselId=parts[0];
        String vesselName=parts[1];
        double averageSpeed=Double.parseDouble(parts[2]);
        String vesselType=parts[3];

        Vessel vessel=new Vessel(vesselId,vesselName,averageSpeed,vesselType);

        vesselUtil.addVesselPerformance(vessel);
        }

        System.out.println("Enter the vesselId to check Speed");
        String checkVesselId=sc.nextLine();

        System.out.println("The vessel of this id is :"+vesselUtil.getVesselById(checkVesselId).getVesselName());

        HighestAverageSpeed=vesselUtil.getHighPerformanceVessels();
        System.out.println("Highest Performance Vessel are :");

        for(Vessel v:HighestAverageSpeed){
            System.out.print(v.getVesselName()+", ");
        }   

        sc.close();
        
    }
}
