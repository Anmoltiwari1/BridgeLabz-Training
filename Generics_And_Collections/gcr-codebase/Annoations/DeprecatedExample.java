class LegacyAPI{

    @Deprecated
    public void oldfeature(){
        System.out.println("This is deprecated method");
    }

    public void newfeature(){
        System.out.println("This is new feature");
    }
}


public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI l = new LegacyAPI();
        l.oldfeature();//warning
        l.newfeature();
    }
}
