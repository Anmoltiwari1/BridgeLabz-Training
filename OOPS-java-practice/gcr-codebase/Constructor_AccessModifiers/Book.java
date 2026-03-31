public class Book{
    String title;
    String author;
    double price;

    Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    Book(){
        title="Unknown";
        author="Unkonow";
        price=0.0;
    }
}