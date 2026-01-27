@FunctionalInterface
interface LightAction {
    void activate();
}


public class SmartLight {
    public static void main(String[] args){

        LightAction motionTrigger= () -> System.out.println("Lights On at full brightness");
        LightAction nightTimeTrigger = () -> System.out.println("Lights on at full brigthness at night");
        LightAction voiceTrigger = () -> System.out.println("Loghts on at full brigthness when voice command given");

        motionTrigger.activate();
        nightTimeTrigger.activate();
        voiceTrigger.activate();
    }
}
