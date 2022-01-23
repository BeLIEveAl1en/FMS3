package fms;

public class FMS {

    public static void main(String[] args) {
        String str = "6.708 +7.4/7.7+24.07";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);
        if (result.isValid()){
            System.out.println("OK");
        }
        else {
            System.out.println("ERROR. Comment " + result.getComment() + ", state: " + StateMachine.state.getState());
        }
    }
}
