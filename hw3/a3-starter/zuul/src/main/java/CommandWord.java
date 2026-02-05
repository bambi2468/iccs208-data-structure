public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), UNKNOWN("unknown"), BACK("back");

    private String commandText;

    CommandWord(String commandText) {
        this.commandText = commandText;
    }

    public String getCommandText() {
        return commandText;
    }

    public static CommandWord fromString(String word) {
        if (word == null) {
            return UNKNOWN;
        }

        for (CommandWord commandWord : CommandWord.values()) {
            if (commandWord.commandText.equals(word)) {
                return commandWord;
            }
        }
        return UNKNOWN;
    }

    public static String getValidCommands() {
        StringBuilder sb = new StringBuilder();
        for (CommandWord commandWord : CommandWord.values()) {
            if (commandWord != UNKNOWN) {
                sb.append(commandWord.getCommandText());
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

}
