package ru.sberbank.jd.service;

import ru.sberbank.jd.controller.input.SumInput;
import ru.sberbank.jd.controller.output.SumOutput;
import ru.sberbank.jd.model.Operation;
import ru.sberbank.jd.repository.CalculatorRepository;
import ru.sberbank.jd.repository.InMermoryCalculatorRepositoryImpl;

public class CalculatorService {

    private CalculatorRepository calculatorRepository = new InMermoryCalculatorRepositoryImpl();

    public SumOutput sum(SumInput sumInput) {
        SumOutput sumOutput = new SumOutput(sumInput.getValue1() + sumInput.getValue2());
        Operation op = Operation.builder()
                .sumInput(sumInput)
                .result(String.valueOf(sumOutput.getResult())).build();
        Operation resultOperation = calculatorRepository.save(op);

        System.out.println("Operation saved, operation is " + resultOperation);

        return sumOutput;
    }
}
