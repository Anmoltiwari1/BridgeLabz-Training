class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStart(PetrolPump[] pumps) {
        int n = pumps.length;

        int start = 0;
        int currPetrol = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            currPetrol += pumps[i].petrol - pumps[i].distance;

            if (currPetrol < 0) {
                deficit += currPetrol;
                start = i + 1;
                currPetrol = 0;
            }
        }

        return (currPetrol + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int start = findStart(pumps);
        System.out.println(start);
    }
}
