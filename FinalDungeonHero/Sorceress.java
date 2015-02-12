/*This Sorceress class extends from Hero, inheriting all classes from it. Allows the Sorceress to do specials also
 
@author Tony Moua Daniel Moua
*/

import java.util.Scanner;
import java.util.Random;

public class Sorceress extends Hero
{
	private double Heal = .40;
/**
	  This constructor calls the super which is DungeonCharacter. Adding the character name

	  @exception	none - No exceptions thrown
	  @see			"No borrowed code"
*/		
	public Sorceress()
	{
		super();
		characterName = "Mage";
	}//end dvc
/**
	   This constructor will create a explicit Warrior.  The name passed in will be checked
	   for null, if not null, the name will be set ot the value passed in, hitPoint, attackSpeed, minDamage, maxDamage, chanceToHitOpponent
		get set to what the user pasees in. 

	   @param characterName -  character name
		@param hitPoint - hit point
	   @param attackSpeed -  attack speed
	   @param minDamage - the minimum damage the monster or character does
		@param maxDamage - the maximum damage the monster or character does
		@param chanceToBlock - to see if hero can block attacks
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
*/		
	public Sorceress(String characterName, int hitPoint, int attackSpeed,double chanceToHitOpponent, int minDamage, int maxDamage, double chanceToBlock)
	{
		super(characterName, hitPoint, attackSpeed, chanceToHitOpponent, minDamage, maxDamage,chanceToBlock);
	}//end evc
/**
	   This method calculates to see if you can use the special.  

	   @return		int - random number 
		@param -		none
	   @exception	none - No exceptions thrown
	   @see		none
	  */	
	public boolean canHeal()//if crushing blow is avaiable 
	{
		return Math.random()<= .50;
	}
/**
	   This method calculates the heal points of the special.  

	   @return		int - random number 
		@param -		none
	   @exception	none - No exceptions thrown
	   @see		none
	  */		
	public int calHealAdd()//How much to heal
	{
		Random generator = new Random();
		return generator.nextInt(50 - 15) + 20;
	}
/**
	   This method shows that if we can use the special it commands the character to use special.  

	   @return		none
		@param -		DungeonCharacter opponent
	   @exception	none - No exceptions thrown
	   @see		none
	  */	
	public void heal()
	{	int heal;
		int temp;
		
		if(canHeal())
		{
		 	heal = calHealAdd();
			System.out.println(characterName + " " + "Healed for " +  heal + " " + "hit points");

		}
		else
			System.out.println("Heal failed");
	}
/**
	   This method allows the character to attack and show menu to see if user wants to use special. 

	   @return		none
		@param opponent -	DungeonCharacter opponent
	   @exception	none - No exceptions thrown
	   @see		none
*/		
	public void attack(DungeonCharacter opponent)
	{
		int choice;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("1.Attack" + "\n" +
								 "2.Special Attack");
			System.out.print("Enter your choice: ");
			choice = kb.nextInt();
			
			if(choice == 1)
			{
				super.attack(opponent);
			}
			else if(choice == 2)
			{
				System.out.println("Heal" );
				heal();
			}
			else
			{
				System.out.println("Crushing Blow FAILED");
			}
	
	}
}
