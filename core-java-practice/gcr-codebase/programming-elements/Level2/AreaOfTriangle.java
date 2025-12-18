package Level2;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        double area=0;
        Scanner sc=new Scanner(System.in);
        int base=sc.nextInt();
        int height=sc.nextInt();

        area=1/2*base*height;

        System.out.println("The Area of the Triangle is sq in is "+area);
        sc.close();
    }
}
