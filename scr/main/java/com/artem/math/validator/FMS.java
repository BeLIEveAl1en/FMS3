package com.artem.math.validator;

public class FMS {

    public static void main(String[] args) {
        String str = "21.06 / 700.5 + 485.02";
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
