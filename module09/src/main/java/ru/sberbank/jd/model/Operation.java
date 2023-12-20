package ru.sberbank.jd.model;

import lombok.*;
import ru.sberbank.jd.controller.input.SumInput;

@Data
@Builder
public class Operation {
    private String id;
    private SumInput sumInput;
    private String result;
}
