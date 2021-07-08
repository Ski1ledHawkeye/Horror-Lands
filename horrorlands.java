
import java.util.*;
import java.util.Random;

public class horrorlands{
    public static void main(String args[])
    { 
      //System objects  
      Scanner sc = new Scanner(System.in);
      Random rand = new Random();
      
      //Game Variables
      String[] enemies = {"Skleton", "Zombie", "Warrior", "Assassian"};
      int maxEnemyHealth = 75;
      int enemyAttackDamage = 25;
      
      //Player Variables
      int health = 100;
      int attackDamage = 50;
      int numHealthPotions = 3;
      int healthPotionHealAmount = 30;
      int healthPotionDropChance = 50; //Percentage
      
      boolean running = true;
      
      System.out.println("Welcome to Horror lands");
      
      GAME:
      while(running){
        System.out.println("--------------------------------------------");
        
        int enemyHealth = rand.nextInt(maxEnemyHealth);
        String enemy = enemies[rand.nextInt(enemies.length)];
        System.out.println("\t# " +enemy+ " has appeared! #\n");
        //  #Skleton has appeared! #
        while(enemyHealth >0){
           System.out.println("\tYour HP: "+ health);
           System.out.println("\t" +enemy+ "'s HP: " +enemyHealth);
           System.out.println("\n\tWhat will you do?");
           System.out.println("\t1. Attack");
           System.out.println("\t2 Drink health potion");
           System.out.println("\t3. Run");
           
           String input = sc.nextLine();
           if(input.equals("1")){
               int damageDealt = rand.nextInt(attackDamage);
               int damageTaken = rand.nextInt(enemyAttackDamage);
               
               enemyHealth -= damageDealt;
               health -= damageTaken;
               
               System.out.println("\tYou strike the " +enemy+ " for " +damageDealt+ " damage.");
               System.out.println("\tYou recive " +damageTaken + " damage by the " +enemy);
               
               if (health<10) {
                   System.out.println("\t>You have taken too much damage, you are weak to fight");
                   break;
                }
            }
           else if(input.equals("2")){
               if(numHealthPotions >0){
                   health += healthPotionHealAmount;
                   numHealthPotions--;
                   System.out.println("\t> You drank a health potion and healed yourself for " +healthPotionHealAmount+"." + "\n\t> Now you have " +health+ " HP." + "\n\t> You have " +numHealthPotions+ " health potions left.");
                }
                else{
                    System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one");
                    
                }
            } 
           else if(input.equals("3")){
               System.out.println("\tYou run away from the " +enemy+ "!");
               continue GAME;
            } 
            else{
                System.out.println("\tInvaild command");
            }
         }
         if(health <1){
            System.out.println("Game over! Weak to battle");
            break;
            }
            
         System.out.println("--------------------------------------------");
         System.out.println("# "+enemy+ " was defeated #");
         System.out.println("# You have health " +health+ " HP left. #");
         if(rand.nextInt(100) < healthPotionDropChance) {
            numHealthPotions++;
            System.out.println(" # The " +enemy+ " dropped a health potion! #");
            System.out.println(" # You now have " +numHealthPotions+ " health potion(s). #");
            }
         System.out.println("--------------------------------------------");
         System.out.println("What would you like to do now!");
         System.out.println("1. Continue Fighting");
         System.out.println("2. Exit Game");
         
         String input = sc.nextLine();
         
         while(!input.equals("1") && !input.equals("2")){
            System.out.println("Invalid command!");
            input = sc.nextLine();
            }
         if(input.equals("1")){
            System.out.println("Continue the adventure!");
            }
         else if(input.equals("2")){
            System.out.println("You exit Horror Lands! Sucessful in your adventure");
            break;
            }
        }
      System.out.println("###############################");
      System.out.println("#    Thanks for Playing :P    #");
      System.out.println("###############################");
    }
}
