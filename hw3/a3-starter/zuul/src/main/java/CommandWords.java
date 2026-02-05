import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords {
    // a constant array that holds all valid command words
    HashMap<String, CommandWord> validCommands = new HashMap<>();

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        for (CommandWord commandWord : CommandWord.values()) {
            validCommands.put(commandWord.getCommandText(), commandWord);
        }
    }
    /**
     * Check whether a given String is a valid command word.
     * 
     * @return true if a given string is a valid command,
     *         false if it isn't.
     */
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }
}
