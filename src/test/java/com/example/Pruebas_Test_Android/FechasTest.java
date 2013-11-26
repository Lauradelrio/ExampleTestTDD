package com.example.Pruebas_Test_Android;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 26/11/13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class FechasTest {

    //Test Imput

    @Test
    public void TestLegalDay() throws Exception{
        String date = new Fechas().rebuilt_date("03/50/2021");
        assertEquals(date,"03/50/2021 is illegal");
    }

    @Test
    public void TestLegalMonth() throws Exception{
        String date = new Fechas().rebuilt_date("23/50/2021");
        assertEquals(date,"23/50/2021 is illegal");
    }

    @Test
    public void TestLegalYear() throws Exception{
        String date = new Fechas().rebuilt_date("23/50/1021");
        assertEquals(date,"23/50/1021 is illegal");
    }

    @Test
    public void TestMoreChar() throws Exception{
        String date = new Fechas().rebuilt_date("0023/50/1021");
        assertEquals(date,"0023/50/1021 is illegal");
    }

    @Test
    public void TestLessCharYear() throws Exception{
        String date = new Fechas().rebuilt_date("23/50/121");
        assertEquals(date,"23/50/121 is illegal");
    }

    @Test
    public void TestLessField() throws Exception{
        String date = new Fechas().rebuilt_date("23/50");
        assertEquals(date,"23/50 is illegal");
    }

    @Test
    public void TestLessField2() throws Exception{
        String date = new Fechas().rebuilt_date("hola");
        assertEquals(date,"hola is illegal");
    }

    @Test
    public void TestLessField3() throws Exception{
        String date = new Fechas().rebuilt_date("23/50/23/50");
        assertEquals(date,"23/50/23/50 is illegal");
    }

    //  Test Output

    @Test
    public void TestBasic() throws Exception{
        String date = new Fechas().rebuilt_date("12/18/14");
        assertEquals(date,"2014-12-18");
    }

    @Test
    public void TestCompletDayyMonth() throws Exception{
        String date = new Fechas().rebuilt_date("2/4/67");
        assertEquals(date,"2067-02-04");
    }


    @Test
    public void TestCompletYear() throws Exception{
        String date = new Fechas().rebuilt_date("12/18/1");
        assertEquals(date,"2001-12-18");
    }

    @Test
    public void TestCompletYear2() throws Exception{
        String date = new Fechas().rebuilt_date("12/18/2021");
        assertEquals(date,"2021-12-18");
    }

    @Test
    public void TestBisiestoYear() throws Exception{
        String date = new Fechas().rebuilt_date("2/29/2012");
        assertEquals(date,"2012-02-29");
    }

    @Test
    public void TestNoBisiestoYear() throws Exception{
        String date = new Fechas().rebuilt_date("2/29/2013");
        assertEquals(date,"2/29/2013 is illegal");
    }




  /*
    @Test
    public void TestEntrada() throws Exception{
        String fecha = new Fechas().probarformato("4/67");
        assertTrue(fecha, false);
    }
    */
}
