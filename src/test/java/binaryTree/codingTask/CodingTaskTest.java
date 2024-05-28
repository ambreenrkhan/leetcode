package binaryTree.codingTask;

import org.junit.*;


import static org.junit.Assert.assertEquals;

public class CodingTaskTest {
    private CodingTask codingTask;

    @Before
    public void setUp() {
        codingTask = new CodingTask();
    }

    @Test
    public void testPrintString() {
        String expected = "Hello World";
        String actual = codingTask.getTestString();
        assertEquals(expected,actual);
    }
}
