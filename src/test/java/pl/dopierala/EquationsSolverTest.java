package pl.dopierala;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EquationsSolverTest {

    private EquationSolver eqSolv;

    @Before
    public void setUp(){
        eqSolv = new EquationSolver();
    }

    @Test
    public void shouldReturn1IfEquationIsXPlus3Eq4(){
        //given
        final double a =1;
        final double b =3;
        final double c =4;
        final double expectedResult = 1;
        //when
        double result = eqSolv.solve(a,b,c);
        //then
        Assert.assertEquals(expectedResult,result,0.0001);
    }

    @Test
    public void shouldReturnNeg1IfEquationIs3XPlus3Eq0(){
        //given
        final double a =3;
        final double b =3;
        final double c =0;
        final double expectedResult = -1;
        //when
        double result = eqSolv.solve(a,b,c);
        //then
        Assert.assertEquals(expectedResult,result,0.0001);
    }

    @Test
    public void shouldThrowExceptionWhenEquationIsIncorrect(){
        //given
        final double a =0;
        final double b =0;
        final double c =4;
        //when
        try {
            double result = eqSolv.solve(a, b, c);
            Assert.fail("Exception not thrown.");
        }catch (IncorrectEquationException e) {
            //then
            Assert.assertTrue(e instanceof IncorrectEquationException);
        }
    }

}
