package co.com.andresvasquez.prueba.controller;

import co.com.andresvasquez.prueba.beanprocessor.CalculateOperation;
import co.com.andresvasquez.prueba.beanprocessor.SaveToList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CalculationServiceController {
    @Autowired
    private CalculateOperation calculateOperation;
    @Autowired
    private SaveToList saveToList;

    Logger log = LoggerFactory.getLogger(CalculationServiceController.class);

    @GetMapping("/")
    public String process(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);
        model.addAttribute("sessionid", session.getId());
        return "index";
    }

    @PostMapping("/operatorion")
    public String operator1(@RequestParam("op1") int op1, @RequestParam("op2") int op2, @RequestParam("operador") String operador, HttpServletRequest request) {
        log.info("Operador1: {}", op1);
        log.info("Operador2: {}", op2);
        log.info("Operador: {}", operador);
        String result = calculateOperation.getResult(op1, op2, operador);
        saveToList.add(op1, op2, operador,result,request);
        return "redirect:/";
    }
    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
