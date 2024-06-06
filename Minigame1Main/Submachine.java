package Minigame1Main;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.java - a class that represents a text-based game called Submachine where the aim is to escape without
 * dying.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Submachine {

    public static ArrayList<String> submachineReader(String fileName){
        ArrayList<String> room = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line = reader.readLine();
            while(line != null){
                room.add(line);
                System.out.println();
                line = reader.readLine();
            }
        }catch(IOException e){
            System.out.println(e);
        }

        return room;
    }
    public static void main (String[] args){

        ArrayList<String> hallway = submachineReader("src/Minigame1/Rooms/Hallway");
        ArrayList<String> mainRoom = submachineReader("src/Minigame1/Rooms/MainRoom");
        ArrayList<String> theFishermansDeathBed = submachineReader("src/Minigame1/Rooms/TheFishermansDeathBed");
        ArrayList<String> theDeadFisherman = submachineReader("src/Minigame1/Rooms/TheDeadFisherman");
        ArrayList<String> theLostChild = submachineReader("src/Minigame1/Rooms/TheLostChild");
        ArrayList<String> theLostChildPart2 = submachineReader("src/Minigame1/Rooms/TheLostChildPart2");
        ArrayList<String> theSpiderRoom = submachineReader("src/Minigame1/Rooms/TheSpiderRoom");
        ArrayList<String> theSpiderRoomDeath = submachineReader("src/Minigame1/Rooms/TheSpiderRoomDeath");
        ArrayList<String> theDeadSpiders = submachineReader("src/Minigame1/Rooms/TheDeadSpiders");
        ArrayList<String> theCavern = submachineReader("src/Minigame1/Rooms/TheCavern");
        ArrayList<String> theAtticChamber = submachineReader("src/Minigame1/Rooms/TheAtticChamber");
        ArrayList<String> egress = submachineReader("src/Minigame1/Rooms/Egress");

        boolean life = true;
        int roomID = 1;
        Scanner input = new Scanner(System.in);
        if(roomID == 1){
            System.out.println(hallway);
            boolean flag = true;
            while (flag){
                System.out.println("Please enter a valid direction");
                String direction = input.next();
                flag = false;
            }
        }


    }
}
