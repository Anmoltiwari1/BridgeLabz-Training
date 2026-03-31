package Level1;
public class PensDivision {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;

        int pensEach = totalPens / students;
        int remainingPens = totalPens % students;

        System.out.println("Pens each student gets: " + pensEach);
        System.out.println("Remaining pens: " + remainingPens);
    }
}
