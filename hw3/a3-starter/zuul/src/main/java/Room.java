import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is
 * connected to other rooms via exits. The exits are labelled north,
 * east, south, west. For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    public String description;
    private HashMap<String, Room> exitMap = new HashMap<>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Define the exits of this room. Every direction either leads
     * to another room or is null (no exit there).
     * 
     * @param north The north exit.
     * @param east  The east east.
     * @param south The south exit.
     * @param west  The west exit.
     */
    public void setExit(String dir, Room nextRoom) {
        exitMap.put(dir, nextRoom);
    }

    public Room getExit(String dir) {
        return exitMap.get(dir);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public String getExitInfos() {
        StringBuilder info = new StringBuilder();
        info.append("Exits: ");
        Set<String> keys = exitMap.keySet();
        for (String key : keys) {
            info.append(key + ' ');
        }
        return info.toString();
    }

}
