package pl.dopierala;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EquationsParserTest {
    private EquationsParser eqParser;

    @Before
    public void setUp(){
        eqParser = new EquationsParser();
    }

    @Test
    public void shouldParseEquation5x6Eq100() {
        //given
        final String equation = "5x+6=100";
        final Equation expectedEquation = new Equation(5, 6, 100);

        //when
        Equation result = eqParser.parse(equation);

        //then
        Assert.assertEquals(expectedEquation, result);
    }

    @Test
    public void shouldParseEquation5xEq100() {
        //given
        final String equation = "5x=100";
        final Equation expectedEquation = new Equation(5, 0, 100);

        //when
        Equation result = eqParser.parse(equation);

        //then
        Assert.assertEquals(expectedEquation, result);
    }

    @Test
    public void shouldParseEquation5Eq100() {
        //given
        final String equation = "5=100";
        final Equation expectedEquation = new Equation(0, 5, 100);

        //when
        Equation result = eqParser.parse(equation);

        //then
        Assert.assertEquals(expectedEquation, result);
    }

    @Test
    public void shouldParseEquationXEq200() {
        //given
        final String equation = "x=200";
        final Equation expectedEquation = new Equation(1, 0, 200);

        //when
        Equation result = eqParser.parse(equation);

        //then
        Assert.assertEquals(expectedEquation, result);
    }

    @Test
    public void shouldParseEquationMinusXEq100() {
        //given
        final String equation = "-x=100";
        final Equation expectedEquation = new Equation(-1, 0, 100);

        //when
        Equation result = eqParser.parse(equation);

        //then
        Assert.assertEquals(expectedEquation, result);
    }

}

