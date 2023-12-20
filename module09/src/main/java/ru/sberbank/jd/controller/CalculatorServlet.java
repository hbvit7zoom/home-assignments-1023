package ru.sberbank.jd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.sberbank.jd.controller.input.SumInput;
import ru.sberbank.jd.controller.output.SumOutput;
import ru.sberbank.jd.service.CalculatorService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = {"/calculator/*"})
public class CalculatorServlet extends HttpServlet {

    private ObjectMapper objectMapper;
    private CalculatorService calculatorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.objectMapper = new ObjectMapper();
        this.calculatorService = new CalculatorService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SumInput sumInput = getSumInputFrom(req);
        System.out.println("sumInput = " + sumInput);
        SumOutput result = calculatorService.sum(sumInput);

        // Response content
        resp.getOutputStream().write(objectMapper.writeValueAsString(result).getBytes());
        resp.getOutputStream().flush();
    }

    private SumInput getSumInputFrom(HttpServletRequest req) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader= req.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        System.out.println(sb);
        SumInput sumInput = objectMapper.readValue(sb.toString(), SumInput.class);
        return sumInput;
    }
}
