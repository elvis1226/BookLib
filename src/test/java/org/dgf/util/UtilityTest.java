package org.dgf.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.dgf.util.Utility.parseLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityTest {

    @Test
    public void TestParseLine() {
        String input1 = "add \"wang\" \" ya\" 2";
        String input2 = "delete \"wang\" \"ya\"";

        List<String> value1 = parseLine(input1);
        assertEquals(4, value1.size());
        assertEquals("add", value1.get(0));
        assertEquals("wang", value1.get(1));
        assertEquals("ya", value1.get(2));
        assertEquals("2", value1.get(3));

        List<String> value2 = parseLine(input2);
        assertEquals(3, value2.size());
        assertEquals("delete", value2.get(0));
        assertEquals("wang", value2.get(1));
        assertEquals("ya", value2.get(2));
    }

}
