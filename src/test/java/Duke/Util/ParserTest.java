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

    @Test
    public void DoneCommandTest() throws DukeException {
        DoneCommand done = new DoneCommand(3);
        Command hold = Parser.parse("done 3");
        assertEquals(done, hold);
    }

    @Test
    public void DeleteCommandTest() throws DukeException {
        DeleteCommand delete = new DeleteCommand(2);
        Command hold = Parser.parse("delete 2");
        assertEquals(delete, hold);
    }

    @Test
    public void FindCommandTest() throws DukeException {
        FindCommand add = new FindCommand("games test");
        Command hold = Parser.parse("find games test");
        assertEquals(add, hold);
    }
}
