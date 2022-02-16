package fmsTest;

import com.artem.math.validator.StateMachine;
import com.artem.math.validator.ValidationResult;
import org.junit.Assert;
import org.junit.Test;

public class FMSTest {

    public void shouldPass(String str){
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertTrue(result.getComment(), result.isValid());
    }

    public void shouldFail(String str){
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertFalse(result.getComment(), result.isValid());
    }

    ///////////////////////////////ShouldPass/////////////////////////////////

    @Test
    public void shouldPassWithWhitespace(){
        shouldPass("21 / 700 + 485");
    }

    @Test
    public void shouldPassWithoutWhitespace(){
        shouldPass("21/700+485");
    }

    @Test
    public void shouldPassWithOperator(){
        shouldPass("-21 / -700 + -485");
    }

    @Test
    public void shouldPassWithOperatorAndWithoutWhitespace(){
        shouldPass("-21/-700+-485");
    }

    /////////////////////////////////WithDot///////////////////////////////////

    @Test
    public void shouldPassWithWhitespaceAndDot(){
        shouldPass("21.06 / 700.5 + 485.02");
    }

    @Test
    public void shouldPassWithoutWhitespaceAndDot(){
        shouldPass("21.06/700.5+485.02");
    }

    @Test
    public void shouldPassWithOperatorAndDot(){
        shouldPass("-21.06 / -700.5 + -485.02");
    }

    @Test
    public void shouldPassWithOperatorAndWithoutWhitespaceAndDot(){
        shouldPass("-21.06/-700.5+-485.02");
    }

    /////////////////////////////////WithBrackets///////////////////////////////////

    @Test
    public void shouldPassWithWhitespaceAndBrackets(){
        shouldPass("(21 / (700 + 485))");
    }

    @Test
    public void shouldPassWithOperatorAndBrackets(){
        shouldPass("(-21 / (-700 + -485))");
    }

    @Test
    public void shouldPassWithOperatorAndWithoutWhitespaceAndBrackets(){
        shouldPass("(-21/(-700+-485))");
    }

    /////////////////////////////////ShouldFail///////////////////////////////////

    @Test
    public void shouldFailWithLetter(){
        shouldFail("21h / 700 + j485");
    }

    @Test
    public void shouldFailWithUnexpectedEOF(){
        shouldFail("21 / 700 + ");
    }

    @Test
    public void shouldFailWithDoubleOperator(){
        shouldFail("21 / 700 +- 485");
    }

    @Test
    public void shouldFailWithOneBracket(){
        shouldFail("21 / (700 + 485");
    }

    @Test
    public void shouldFailWithTwoDot(){
        shouldFail("21..06 / 700.5 + 485.02");
    }

    @Test
    public void shouldFailWithoutNumberAfterDot(){
        shouldFail("21.7 / 700. + 485.02");
    }
}

