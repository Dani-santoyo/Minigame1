package Submachine.SubmachineObjects;
/**Class: Software Development I
 * @author Daniel Santoyo
 * @version 1.0
 * Course: ITEC 3860 Summer 2024
 * Written: 6/5, 2024
 * Submachine.SubmachineObjects.Monster.java - The Monster type extends from Thing class. This object type is not
 * yet implemented but will be in future versions of the game.
 */
public class Monster extends Thing{
    private int lives;
    public Monster(String name, String description, int lives){
        super(name, description);
        this.lives = lives;
    }
}
