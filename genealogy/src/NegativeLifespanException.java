public class NegativeLifespanException extends Exception {

    public NegativeLifespanException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        System.out.println("Death date before birth date");
        for(StackTraceElement element : getStackTrace()){
            System.out.println(element);
        }

        return "Lifespan cannot be negative";
    }
}
