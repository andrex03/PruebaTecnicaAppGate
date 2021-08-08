package co.com.andresvasquez.prueba.beanprocessor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SaveToList {
    public void add(int op1, int op2,String operator,String result, HttpServletRequest request){
        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
        }
        String msg = setMessage(op1,op2,operator,result);
        messages.add(msg);
        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);

    }
    private String setMessage(int op1, int op2,String operator,String result) {
        String msg =operator + " de: "+ String.valueOf(op1) + " con " +
                String.valueOf(op2)+ " = "+ result;
        return msg;
    }
}
