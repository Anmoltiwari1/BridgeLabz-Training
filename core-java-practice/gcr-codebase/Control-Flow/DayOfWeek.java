public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            System.out.println("Example: java DayOfWeek 12 25 2023");
            return;
        }
        
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        
        int yo = y - (14 - m) / 12;
        int x = yo + yo/4 - yo/100 + yo/400;
        int mo = m + 12 * ((14 - m) / 12) - 2;
        int dayOfWeek = (d + x + 31 * mo / 12) % 7;
        
        System.out.println(dayOfWeek);
    }
}
