package Duke.Util;

import Duke.Tasks.*;
import Duke.Command.*;
import Duke.Exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void AddCommandTest() throws DukeException {
        Todo test_todo = new Todo("Do testing now");
        AddCommand add = new AddCommand(test_todo);
        Command hold = Parser.parse("todo Do testing now");
        assertEquals(add, hold);
    }

}
