package Duke;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DukeTest {

    private static final String LINE = "_______________________________\n";

    @Test
     public void testDuke() {
        try {
            InputTest.provideInput("bye");
            Duke.main(new String[0]);
            String output = InputTest.getOutput();
            String expected =
                    LINE +
                            "Hello! I'm Duke\n" +
                            "What can I do for you?\n" +
                            LINE +
                            "\n" +
                            "Bye. Hope to see you again soon!" +
                            LINE;
            assertEquals(expected, output);
        } catch (NullPointerException e) {
            
        }
    }
}
