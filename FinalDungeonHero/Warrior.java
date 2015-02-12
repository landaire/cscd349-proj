/*This warrior class extends from Hero, inheriting all classes from it. 

@author Tony Moua Daniel Moua
*/

import java.util.Random;
import java.util.Scanner;

public class Warrior extends Hero
{
	private double CrushingBlow = .40;
	private int minCrushingBlow = 75;
	private int maxCrushingBlow = 175;
/**
	  This constructor calls the super which is DungeonCharacter. Adding the character name

	  @exception	none - No exceptions thrown
	  @see			"No borrowed code"
*/		
	public Warrior()
	{
		super();
		characterName = "Beast";
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
	public Warrior(String characterName, int hitPoint, int attackSpeed, double chanceToHitOpponent, int minDamage, int maxDamage, double chanceToBlock)
	{
		super(characterName, hitPoint, attackSpeed, chanceToHitOpponent,minDamage, maxDamage,chanceToBlock);
	}//end evc
/**
	   This method calculates the damage of the special attack.  

	   @return		int - random number 
		@param -		none
	   @exception	none - No exceptions thrown
	   @see		none
	  */			
	public int crushingBlowDamage()
	{
		Random generator = new Random();
		return generator.nextInt(maxCrushingBlow - minCrushingBlow) + minCrushingBlow;
	}//end calulations
/**
	   This method figures out if the user can use the special attack.  

	   @return		boolean - chanceto hit
		@param -		none
	   @exception	none - No exceptions thrown
	   @see		none
	  */		
	public boolean canDoCrushingBlow()//if crushing blow is avaiable 
	{
		return Math.random()<= CrushingBlow;
	}
/**
	   This method shows that if we can use the special it commands the character to use special.  

	   @return		none
		@param -		DungeonCharacter opponent
	   @exception	none - No exceptions thrown
	   @see		none
	  */		
	public void crushingBlow(DungeonCharacter opponent)
	{
		if(canDoCrushingBlow())
		opponent.subtractHP(crushingBlowDamage());
		System.out.println(opponent.hitPoint);//print HP after damage is done
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
				System.out.println("CRUSHING BLOW" );
				this.crushingBlow(opponent);
			}
			else
			{
				System.out.println("Crushing Blow FAILED");
			}
	
	}
}

