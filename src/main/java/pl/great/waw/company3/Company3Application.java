package pl.great.waw.company3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import pl.great.waw.company3.repository.CalculatorRPN;
//
//import java.util.Arrays;
//import java.util.List;

@SpringBootApplication

public class Company3Application {

    public static void main(String[] args) {

        SpringApplication.run(Company3Application.class, args);
    }
}


//        List<String> tokens = Arrays.asList("3", "+", "4", "*", "2", "/", "1", "-", "5", "^", "2", "^", "3");
//        String[] tokensArray = tokens.toArray(new String[0]);
//
//        String rpnExpression = CalculatorRPN.createRPN(tokensArray);
//
//        System.out.println("Odwrotna notacja polska: " + rpnExpression);
//
//        String rpnExpression1 = "3 4 2 * 1 5 - 2 3 ^ ^ / +";
//        double result = CalculatorRPN.calculate(rpnExpression1);
//        System.out.println("Wynik: " + result);
//    }
//}




