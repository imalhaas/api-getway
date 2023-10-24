package br.com.erudio.apigetway.Exceptions.Math;

import br.com.erudio.apigetway.Converter.NumberConverter;
import br.com.erudio.apigetway.Exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.atomic.AtomicLong;

public class SimpleMath {

    public Double sum( Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction( Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiplication( Double numberOne,  Double numberTwo){
        return numberOne * numberTwo;

    }

    public Double division( Double numberOne, Double numberTwo)  {
        return numberOne / numberTwo;
    }


    public Double mean( Double numberOne, Double numberTwo)  {
        return (numberOne + numberTwo) / 2;
    }


    public Double squareRoot(Double number) {
        return Math.sqrt(NumberConverter.covertToDouble(String.valueOf(number)));
    }
}
