interface device{

    void turnOn();
    void turnOff();
}


class AC implements device{
    
    @Override
    public void turnOn(){
        System.out.println("AC is turned on");
    }

    @Override
    public void turnOff(){
        System.out.println("AC is turned off");
    }
}

class lights implements device{

    @Override
    public void turnOn(){
        System.out.println("lights is turned on");
    }

    @Override
    public void turnOff(){
        System.out.println("lights is turned off");
    }
}

class TV implements device{

     @Override
    public void turnOn(){
        System.out.println("TV is turned on");
    }

    @Override
    public void turnOff(){
        System.out.println("TV is turned off");
    }
}

public class SmartDevice{
    public static void main(String[] args) {  
        TV tv=new TV();
        tv.turnOff();
    }
}
