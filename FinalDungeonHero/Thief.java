/*This Thief class extends from Hero, inheriting all classes from it. allows the thief to do specials also
 
@author Tony Moua Daniel Moua
*/

import java.util.Random;
import java.util.Scanner;

public class Thief extends Hero
{
	private double supriseAttack = .40;
/**
	  This constructor calls the super which is DungeonCharacter. Adding the character name

	  @exception	none - No exceptions thrown
	  @see			"No borrowed code"
*/		
	public Thief()
	{
		super();
		characterName = "Ninja";
	}
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
	public Thief(String characterName, int hitPoint, int attackSpeed, double chanceToHitOpponent, int minDamage, int maxDamage, double chanceToBlock)
	{
		super(characterName, hitPoint, attackSpeed, chanceToHitOpponent, minDamage, maxDamage,chanceToBlock);
	}//end evc
/**
	   This method calculates the damage of the special attack.  

	   @return		int - random number 
		@param -		none
	   @exception	none - No exceptions thrown
	   @see		none
	  */	
	public boolean canDoSurpriseAttack()//if crushing blow is avaiable 
	{
		return Math.random()<= .40;
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
		Scanner kb = new Scanner(System.in);
		int choice;
		
		System.out.println("1.Attack" + "\n"
								+"2.Special Attack");
			System.out.print("Enter your choice: ");
			choice = kb.nextInt();
			if(choice == 1)
			{
				super.attack(opponent);
			}
			else if(choice == 2)
			{
				surpriseAttack(opponent);
			}
			else
			{
				System.out.println("SURPRISED ATTACK FAILED");
			}
	}
/**
	   This method shows that if we can use the special it commands the character to use special.  

	   @return		none
		@param -		DungeonCharacter opponent
	   @exception	none - No exceptions thrown
	   @see		none
	  */	
	public void surpriseAttack(DungeonCharacter opponent)
	{
		if(canDoSurpriseAttack())
		{
			super.attack(opponent);
			System.out.println("Surprise ATTACK!!");
			System.out.println(opponent.hitPoint);//print HP after damage is done
		}
		else
		{
			System.out.println("Special FAILED!!!");
		}
		
	}
	
}