package ru.sberbank.jd.controller.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumInput {
    private Double value1;
    private Double value2;
}
