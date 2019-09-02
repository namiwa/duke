public class Parser {

    private static Command checkValidDoneIndex(String input) throws DukeEmptyCommandException {
        String[] hold = input.split(" ");
        int test = hold.length;
        int index = Integer.parseInt(hold[1]);
        if (test > 2) {
            throw new DukeEmptyCommandException();
        } else {
            return new DoneCommand(index);
        }
    }

    private static String[] testRegex(String inputs) throws DukeEmptyCommandException {
        if (inputs.startsWith("deadline")) {
            if (!inputs.contains("/by")) {
                throw new DukeEmptyCommandException();
            }
        }
        if (inputs.startsWith("event")) {
            if (!inputs.contains("/at")) {
                throw new DukeEmptyCommandException();
            }
        }
        if (inputs.equals("todo")) {
            throw new DukeEmptyCommandException();
        }

        String[] res = inputs.split("/");
        if (res.length == 0) {
            throw new DukeEmptyCommandException();
        }
        return res;
    }

    private static Command deleteTask(String input) throws DukeEmptyCommandException, DukeCommandException {
        String[] split = input.split(" ", 2);
        int res = -1;
        if (split[split.length - 1].equals("")) {
            throw new DukeEmptyCommandException();
        }
        try {
            res = Integer.parseInt(split[split.length - 1]);
        } catch (NumberFormatException e) {
            throw new DukeCommandException();
        }
        return new DeleteCommand(res);
    }

    private static Command parseFind(String input) {
        String[] split = input.split(" ", 2);
        return new FindCommand(split[1]);
    }

    public static Command parse(String input) throws DukeCommandException, DukeEmptyCommandException {
        if (input.startsWith("todo ")) {
            String[] temp = input.split("todo ");
            String [] split = testRegex(temp[temp.length - 1]);
            if (!temp[0].equals("")) {
                throw new DukeCommandException();
            }
            Task hold = new Todo(split);
            return new AddCommand(hold);
        } else if (input.startsWith("event ")) {
            String[] temp = input.split("event ");
            String [] split = testRegex(temp[temp.length - 1]);
            if (!temp[0].equals("")) {
                throw new DukeCommandException();
            }
            split[split.length - 1] = split[split.length - 1].trim();
            split[split.length - 1] = split[split.length - 1].replaceFirst("at ", "");
            Task hold = new Events(split);
            return new AddCommand(hold);
        } else if (input.startsWith("deadline ")) {
            String[] temp = input.split("deadline ");
            String [] split = testRegex(temp[temp.length - 1]);
            if (!temp[0].equals("")) {
                throw new DukeCommandException();
            }
            split[split.length - 1] = split[split.length - 1].trim();
            split[split.length - 1] = split[split.length - 1].replaceFirst("by ", "");
            Task hold = new Deadline(split);
            return new AddCommand(hold);
        } else if (input.equals("bye")) {
            return new ByeCommand();
        } else if (input.startsWith("done ")) {
            return checkValidDoneIndex(input);
        } else if (input.startsWith("delete ")) {
            return deleteTask(input);
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.equals("find ")) {
           return parseFind(input);
        } else {
            throw new DukeCommandException();
        }
    }


}
