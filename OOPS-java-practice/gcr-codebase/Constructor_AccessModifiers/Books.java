public class Books {
    
    String title;
    String author;
    double price;
    boolean availability;

    //Paramterized Constructor
    Books(String title,String author,double price,boolean availability){
        this.title=title;
        this.author=author;
        this.price=price;
        this.availability=true;
    }

    //Method to borrow thw book
    public void BorrowABook(){
        if(availability){
            System.out.print("Your book titled "+title+" is being borrowed");
            availability=false;
        }else{
            System.out.println("Book is not available");
        }
    }
}
