package Submachine.SubmachineGame;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineGame.Gamejava - The submachine game class that includes methods to help the navigation mechanics
 * for the game. This class has 4 variables: an Actor type, 2 List<String> types, and an ArrayList<Room> type.
 */

import java.util.*;
import Submachine.SubmachineObjects.Actor;
import Submachine.SubmachineObjects.Item;
import Submachine.SubmachineObjects.Room;
import Submachine.globals.Direction;

public class Game {

    private ArrayList<Room>map; // the map - an arrayList of Rooms
    Actor player;
    List<String> commands = new ArrayList<>(Arrays.asList("take", "drop", "attack", "block", "dodge", "look", "n",
            "s", "w", "e", "u", "d"));
    List<String> objects = new ArrayList<>(Arrays.asList("gauntlet", "rod", "cellarKey", "mainKey", "monster"));

    public Game() {
        this.map = new ArrayList<Room>();
        //----constructs a new Adventure----
        //add Rooms to the map

        //Map Index: 0
        map.add(new Room("Hallway",
                "You are in a dimly lit hallway, portraits on the wall with watchful eyes that follow your movement. \n" +
                "The only way out of this creepy place is to find the key to the locked door behind you.\n" +
                "The only other door lies in front of you, unlocked...\n" +
                "You can only move NORTH from here.",
                false,
                1,Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        //Map Index: 1
        map.add(new Room(" the Main Room",
                "You enter into a big room with very different doors in every direction. \n" +
                "The door to the EAST has a very eerie fog crawling out from underneath it. \n" +
                "The door to the NORTH is surrounded by piles of precious gold coins. \n" +
                "The door to the WEST has what sounds like a child's voice calling out from the other side. \n" +
                "The door to the SOUTH has a sign that reads \"exit\" above it.\n" +
                "Where will you go?\n" +
                "You can move EAST, NORTH, WEST, and SOUTH from here.",
                false,
                4,0, 2, 3, Direction.NOEXIT, Direction.NOEXIT));
        //Map Index: 2
        map.add(new Room("the Fisherman's Room",
                "The wall's of this room are heavily decorated with trophy's, and old fishing pictures.\n" +
                        "After admiring the glorious walls, your eyes settle onto a very unfortunate scene:\n" +
                        "a withered old man struggling to get his last words out on his death bed. \n" +
                        "\"My name is old man Jenkins, I was the greatest fisherman that ever lived.. here son, take my rod. \n" +
                        "I've no need for it anymore...\" Jenkins mutters as he dissolves into dust.\n" +
                        "Use \"take\" command to pick up the \"rod\".\n" +
                        "You can only go WEST from here.",
                false,
                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1, Direction.NOEXIT,Direction.NOEXIT));
        //Map Index: 3
        map.add(new Room("the Psych Ward",
                "There are toys absolutely everywhere in this room. \n" +
                        "If you were still a kid you would never want to leave this toy heaven.\n" +
                        "There is a small child playing with a toy robot in the corner. \n" +
                        "\"There's a toy at the bottom of the cavern river, I want it! I want it!\", the child exclaims. \n" +
                        "As you scan the room you can see a hatch on the floor, almost buried by the toys.\n" +
                        "You can only move DOWN and EAST from here.",
                false,
                Direction.NOEXIT, Direction.NOEXIT,1, Direction.NOEXIT, Direction.NOEXIT, 5));
        //Map Index: 4
        map.add(new Room("the Spider Room",
                "You walk into a room excited by the idea of potential treasure. \n" +
                        "Unfortunately, all is not as it seems, there is no treasure. \n" +
                        "Instead, glowing red eyes come forward out of the darkness to reveal two monster spiders. \n" +
                        "Fortunately, you have your trusty gauntlet on. \n" +
                        "Your eyes glow white as you prepare to bash both spiders into oblivion. \n" +
                        "Enter the \"attack\" command to kill the \"spiders\".\n" +
                        "You can now continue to the other end of the room where sitting on a pile of coins is a shiny key. \n" +
                        "Use the \"take\" command to pick up the \"cellarKey\".\n" +
                        "You can move SOUTH or UP from here.",
                false,
                Direction.NOEXIT, 1, Direction.NOEXIT, Direction.NOEXIT, 6, Direction.NOEXIT));
        //Map Index: 5
        map.add(new Room("the Cavern",
                "As you finish climbing down a dingy sewer ladder you are met with a beautiful cavern, \n" +
                        "glistening with all different types of crystals.\n" +
                        "You can hear the squealing of bats overhead and there is a river at the other end of the cavern.\n" +
                        "You peer over the river and see the \"toy\" that the child was talking about at the bottom of the river. \n" +
                        "Only it's not a toy, it looks to be something else... \n" +
                        "if only you had something to help get it out of the bottom of the water.\n" +
                        "> Use the \"take\" command to grab the \"gauntlet\" *ONLY IF* you have a \"rod\"\n" +
                        "You acquire a rusty gauntlet with the fisherman's rod!\n" +
                        "You can only move UP from here.",
                false,
                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 3, Direction.NOEXIT));
        //Map Index: 6
        map.add(new Room("the Attic Chamber",
                "You are out of breath after climbing a long spiral staircase. \n" +
                        "You are in the attic and there is a cell. \n" +
                        "A prisoner is behind bars its bars as he begs you to free him. \n" +
                        "He promises to give you something in return if you do...\n" +
                        "> Do you free him with the key you just found? Answer \"YES\" or \"NO\".\n" +
                        "*IF YES* You have freed the prisoner! He gives you another key that says \"Egress\" as thanks.\n" +
                        "*IF NO* In your selfishness you decide not to free the prisoner.\n" +
                        "You end up wandering the dungeon for days on end, to no avail.\n" +
                        "You die a selfishness and sad death. Game Over!\n" +
                        "You can only move DOWN from here.",
                false,
                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 7));
        //Map Index: 7
        map.add(new Room("The Spider Room",
                "As you descend back the winding staircase you are met with the bodies of the spiders you have killed.\n" +
                        "You can only move SOUTH from here.",
                false,
                Direction.NOEXIT, 1, Direction.NOEXIT,Direction.NOEXIT,Direction.NOEXIT,Direction.NOEXIT));

        List<Item> inventory = null;

        player = new Actor("player", "A righteous explorer", map.get(0), inventory, 3 );
    }

    public ArrayList getMap(){
        return map;
    }
    void setMap(ArrayList aMap){
        map = aMap;
    }

    public Actor getPlayer(){
        return player;
    }
    public void setPlayer(Actor aPlayer){
        player = aPlayer;
    }
    //move the player to a room
    public void moveActorTo(Actor p, Room aRoom){
        p.setRoom(aRoom);
    }
    // move an actor in direction 'dir'
    int moveTo(Actor anActor, Direction dir){
         Room r = anActor.getRoom();
         int exit = 0;

         switch (dir) {
             case NORTH:
                 exit = r.getN();
                 break;
             case SOUTH:
                 exit = r.getS();
                 break;
             case EAST:
                 exit = r.getE();
                 break;
             case WEST:
                 exit = r.getW();
                 break;
             case UP:
                 exit = r.getU();
                 break;
             case DOWN:
                 exit = r.getD();
                 break;
             default:
                 exit = Direction.NOEXIT;
                 break;
         }
         if (exit != Direction.NOEXIT){
             moveActorTo(anActor, map.get(exit));
         }
         return exit;
    }

    public int movePlayerTo(Direction dir){
        return moveTo(player, dir);
    }

    private void goN(){
        updateOutput(movePlayerTo(Direction.NORTH));
    }
    private void goS(){
        updateOutput(movePlayerTo(Direction.SOUTH));
    }
    private void goW(){
        updateOutput(movePlayerTo(Direction.WEST));
    }
    private void goE(){
        updateOutput(movePlayerTo(Direction.EAST));
    }
    private void goU(){
        updateOutput(movePlayerTo(Direction.UP));
    }
    private void goD(){
        updateOutput(movePlayerTo(Direction.DOWN));
    }
    private void look(){
        Room room = player.getRoom();
        String inventory = "";
        if(player.getInventory() == null){
            inventory += "Your inventory is empty";
        }else if(player.getInventory().size() == 1){
            inventory += "You have a " + player.getInventory().get(0);
        }else if(player.getInventory().size() == 2){
            inventory += "You have a " + player.getInventory().get(0) + " and a " + player.getInventory().get(1);
        }else{
            for (int i = 0; i < player.getInventory().size(); i++) {
                if(player.getInventory().get(i + 1) == null){
                    inventory += " and a " + player.getInventory().get(i).getName() + ".";
                }else {
                    inventory += player.getInventory().get(i).getName() + ", ";
                }
            }
        }
        String str = "You are in " + room.getName() + ". " + room.getDescription();
        System.out.println(str);
        System.out.println(inventory);
    }

    void updateOutput(int roomNumber){
        String s;
        if (roomNumber == Direction.NOEXIT){
            s = "No Exit!";
        }else{
            Room r = getPlayer().getRoom();
            if(r.isVisited()){
                s = "You are in " + r.getName() + ". " + r.getDescription()
                        + ". \n You have already been to this room";
            }else {
                s = "You are in "
                        + r.getName() + ". " + r.getDescription();
            }
            r.setVisited(true);
        }System.out.println(s);
    }

    public String processVerb(List<String> wordList, Actor player){
        String verb;
        String msg = "";
        verb = wordList.get(0);
        if(!commands.contains(verb)){
            msg = verb + " is not a known verb!";
        } else {
            switch(verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                case "u":
                    goU();
                    break;
                case "d":
                    goD();
                    break;
                case "look":
                    look();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public String processVerbNoun(List<String> wordList, Actor player){
        String verb;
        String noun;
        String msg = "";
        verb = wordList.get(0);
        noun = wordList.get(1);
        if (!commands.contains(verb)){
            msg = verb + " is not a known verb! ";
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
        }
        if(verb == "take") {
            if (noun == "rod") {
                Item rod = new Item("rod", "Old Man Jenkin's prized fishing rod");
                player.addToInventory(rod);
                System.out.println(player.getInventory());
                msg += "You have picked up a " + rod.getName() + ".";
            } else if (noun == "gauntlet"){
                Item gauntlet = new Item("gauntlet", "An old gauntlet found at the bottom of the" +
                        " cavern river");
                player.addToInventory(gauntlet);
                 msg += "You have picked up a " + gauntlet.getName() + ".";
            }else if(noun == "cellarKey") {
                Item cellarKey = new Item("cellarKey", "A rusty key that has a name tag that"
                        + " reads 'attic' on it.");
                player.addToInventory(cellarKey);
                msg += "You have picked up the " + cellarKey.getName() + ".";
            }else if(noun == "mainKey"){
                    Item mainKey = new Item("mainKey", "A shiny key that has a name tag that reads" +
                            " 'egress' on it.");
                    player.addToInventory(mainKey);
                    msg += "You have picked up the " + mainKey.getName() + ".";
            }
        }else if(verb == "drop") {
            switch(noun){
                case "rod":
                    if(!player.getInventory().contains(new Item ("rod",
                            "A rusty key that has a name tag that reads 'attic' on it."))){
                        msg += "You do not have a rod to drop.";
                    }else {
                        msg += "You have dropped the rod";
                    }
                    break;
                case "gauntlet":
                    if(!player.getInventory().contains(new Item ("gauntlet",
                            "An old gauntlet found at the bottom of the cavern river"))){
                        msg += "You do not have a gauntlet to drop.";
                    }else {
                        msg += "You have dropped the gauntlet";
                    }
                    break;
                case "cellarKey":
                    if(!player.getInventory().contains(new Item ("cellar key",
                            "A rusty key that has a name tag that reads 'attic' on it."))){
                        msg += "You do not have a cellar key to drop.";
                    }else {
                        msg += "You have dropped the cellar key";
                    }
                    break;
                case "mainKey":
                    if(!player.getInventory().contains(new Item ("main key",
                            "A shiny key that has a name tag that reads 'egress' on it."))){
                        msg += "You do not have a cellar key to drop.";
                    }else {
                        msg += "You have dropped the main key";
                    }
                    break;
            }
        }
        return msg;
    }

    public String ParseCommand(List<String> wordList){
        String msg;
        if (wordList.size() == 1){
            msg = processVerb(wordList, player);
        } else if (wordList.size() == 2){
            msg = processVerbNoun(wordList, player);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    public List<String> wordList(String input){
        String delims = " ";
        List<String> strList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()){
            t = tokenizer.nextToken();
            strList.add(t);
        }
        return strList;
    }


}
