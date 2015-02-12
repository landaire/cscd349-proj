/*
	This Hero class inherits classes from the super class extending from DungeonCharacter.
	Contains the DVC EVC constructors for the hero, and the outline of what they should have. 
	
	@author Tony Moua Daniel Moua

	@see none
*/
public class Hero extends DungeonCharacter
{
	protected double chanceToBlock;//
	protected int numberOfHits;//attack speed
/**
	  This constructor calls the super which is DungeonCharacter. Adding the chanceToBlock =.20

	  @exception	none - No exceptions thrown
	  @see			"No borrowed code"
*/		
	public Hero()
	{
		super();
		chanceToBlock = .20;
	}//end dvc
/**
	   This constructor will create a explicit Hero.  The name passed in will be checked
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
	public Hero(String characterName, int hitPoint, int attackSpeed, double chanceToHitOpponent, int minDamage, int maxDamage, double chanceToBlock)
	{
		super(characterName, hitPoint, attackSpeed, chanceToHitOpponent, minDamage, maxDamage);
		chanceToBlock = chanceToBlock;
	}//end evc
/**
	   This method just returns the stats of the characters.  This is a simple to string method.

	   @return		String
	   @exception	none - No exceptions thrown
	   @see		none
	  */		
	public String toString()
	{
		String result;
		result = super.toString();
		return result;
	}//end toString
/**
	   This method just returns the chance to see if character can block.  

	   @return		boolean
	   @exception	none - No exceptions thrown
	   @see		none
	  */		
	public boolean Block()// can character block
	{
		return Math.random()<= this.chanceToBlock;
	}//end block
/**
	   This method checks to see if you can attack more then once.  

	   @return		none
		@param -		DungeonCharacter opponent
	   @exception	none - No exceptions thrown
	   @see		none
	  */		
	public void numberOfHits(DungeonCharacter opponent)
	{
		if(attackSpeed > opponent.attackSpeed)
		numberOfHits = attackSpeed/opponent.attackSpeed;
		
		else 
			numberOfHits = 1;
	}
}