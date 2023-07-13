package pl.great.waw.company3.repository;

import org.junit.jupiter.api.Test;
import pl.great.waw.company3.helpers.RPN;

import static org.junit.jupiter.api.Assertions.*;

class RPNTest {

    @Test
    void calculate() {
        Integer result = RPN.calculate("2 3 + 5 *");
        assertEquals(25,result);

    }
}