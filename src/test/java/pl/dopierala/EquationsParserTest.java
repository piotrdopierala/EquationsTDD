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
    public void sholudParseEquation5x6Eq100(){
        //given
        final String toParse ="5x+6=100";
        final Equation expectedEquation = new Equation(5,6,100);

        //when
        Equation result = EquationsParser.parse(toParse);
        //then
        Assert.assertEquals(expectedEquation,result);

    }
}
