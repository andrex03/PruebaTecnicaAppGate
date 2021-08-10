package co.com.andresvasquez.prueba.beanprocessor;


import co.com.andresvasquez.prueba.utils.exceptions.GenericException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculateOperationTest {
    private CalculateOperation calculateOperation;
    @BeforeEach
    public void Setup(){
        calculateOperation = new CalculateOperation();
    }
    @Test
    public void testCalculateOperationSuma() throws GenericException {
        String result = calculateOperation.getResult(1,2,"suma");
        Assertions.assertEquals(result,"3");
    }
    @Test
    public void testCalculateOperationResta() throws GenericException {
        String result = calculateOperation.getResult(2,1,"resta");
        Assertions.assertEquals(result,"1");
    }
    @Test
    public void testCalculateOperationMultiplicacion() throws GenericException {
        String result = calculateOperation.getResult(2,2,"multiplicacion");
        Assertions.assertEquals(result,"4");
    }
    @Test
    public void testCalculateOperationDivision() throws GenericException {
        String result = calculateOperation.getResult(4,2,"division");
        Assertions.assertEquals(result,"2");
    }
    @Test
    public void testCalculateOperationPotenciacion() throws GenericException {
        String result = calculateOperation.getResult(2,3,"potenciacion");
        Assertions.assertEquals(result,"8");
    }
    @Test
    public void testErrorDivision() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculateOperation.getResult(2, 0, "division");
        });
    }
}
