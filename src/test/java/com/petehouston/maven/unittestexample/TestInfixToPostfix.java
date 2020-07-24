package IdeaProjects.UnitTestExample.src.test.java.com.petehouston.maven.unittestexample;

import IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample.InfixToPostfix;
import IdeaProjects.UnitTestExample.src.main.java.com.petehouston.maven.unittestexample.MyException;
import org.junit.Assert;
import org.junit.Test;

public class TestInfixToPostfix {
    @Test
    public void testInfixtoPostfix(){
        InfixToPostfix IFP = new InfixToPostfix();

        String[] t = IFP.InfixToPostfix(new String[]{"1", "+", "2"});
        String a = "12+";
        String b = "1+2";
        String c = "1-2";
        String d = "1*2";
        String e = "1/2";
        Assert.assertEquals(a, "12+");
        Assert.assertNotEquals(b, "12+");
        Assert.assertNotEquals(c, "12-");
        Assert.assertNotEquals(c, "12*");
        Assert.assertNotEquals(c, "12/");
    }
    @Test
    public void testAdd(){
        Double expected = 3.0;
        Double unexpected = 2.0;
        Double actual = InfixToPostfix.Add(1, 2);
        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }
    @Test
    public void testDevide() throws MyException {
        Double expected = 3.0;
        Double unexpected = 2.0;
        Double actual = InfixToPostfix.Devide(2, 6);
        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }
    @Test
    public void testSubtract(){
        Double expected = 3.0;
        Double unexpected = 2.0;
        Double actual = InfixToPostfix.Substract(2, 5);
        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }
    @Test
    public void testMultiply(){
        Double expected = 6.0;
        Double unexpected = 8.0;
        Double actual = InfixToPostfix.Multiply(2, 3);
        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(unexpected, actual);
    }

    @Test
    public void testProcess() {
        InfixToPostfix IFP = new InfixToPostfix();
        String[] expected = {"1","+","2","+","3"};
        String[] actual = IFP.process("1+2+3");
        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void testKiemtra(){
        InfixToPostfix IFP = new InfixToPostfix();

        boolean unexpected = IFP.Kiemtra("1++2");
        boolean unexpected1 = IFP.Kiemtra("1--2");
        boolean unexpected2 = IFP.Kiemtra("1//2");
        boolean unexpected3 = IFP.Kiemtra("1**2");
        boolean unexpected4 = IFP.Kiemtra("1**2");
        boolean unexpected5 = IFP.Kiemtra("(12+)");
        boolean unexpected6 = IFP.Kiemtra("(+9)");
        Assert.assertEquals(unexpected, false);
        Assert.assertEquals(unexpected1, false);
        Assert.assertEquals(unexpected2, false);
        Assert.assertEquals(unexpected3, false);
        Assert.assertEquals(unexpected4, false);
        Assert.assertEquals(unexpected5, false);
        Assert.assertEquals(unexpected6, false);
    }

}
