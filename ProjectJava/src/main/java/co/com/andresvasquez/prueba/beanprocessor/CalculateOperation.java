package co.com.andresvasquez.prueba.beanprocessor;

public class CalculateOperation {

    public String getResult(int op1, int op2,String operator) {
        String result = "";
        switch (operator) {
            case "suma":
                result = String.valueOf(op1 + op2);
                break;

            case "resta":
                result = String.valueOf(op1 - op2);
                break;
            case "multiplicacion":
                result = String.valueOf(op1 * op2);
                break;
            case "division":
                result = String.valueOf(op1 / op2);
                break;

            case "potenciacion":
                result = String.valueOf((int) Math.pow(op1, op2));
                break;
            default:
                result = "No se puede realizar operacion";
                break;
        }
        return result;
    }
}
