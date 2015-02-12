import java.util.Random;

public class DungeonCharacter
{
	Random generator = new Random();
	
	protected String characterName;
	
	protected int minHP = 150;
	protected int maxHP = 225;
	protected int hitPoint = generator.nextInt(maxHP - minHP)+maxHP;
	protected int attackSpeed;
	protected int minDamage;
	protected int maxDamage;
	protected double chanceToHitOpponent;
	
/**
	  This constructor will create a default character.  The defaults are: characterName = default; hitPoint = 0;
	  attackSpeed =2; mindamage = 100; maxdamage = 200; and chance to hit = .70.

	  @exception	none - No exceptions thrown
	  @see			"No borrowed code"
*/	
	public DungeonCharacter()
	{
		this.characterName ="";
		this.hitPoint = 0;
		this.attackSpeed = 2;
		this.minDamage = 100;
		this.maxDamage = 200;
		this.chanceToHitOpponent = .70;
	}//dvc

/**
	   This constructor will create a explicit character.  The name passed in will be checked
	   for null, if not null, the name will be set ot the value passed in, hitPoint, attackSpeed, minDamage, maxDamage, chanceToHitOpponent
		get set to what the user pasees in. 

	   @param characterName - character name
		@param hitPoint - hit point
	   @param attackSpeed - attack speed
	   @param minDamage - the minimum damage the monster or character does
		@param maxDamage - the maximum damage the monster or character does
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
*/	

	public DungeonCharacter(String characterName, int hitPoint, int attackSpeed, double chanceToHitOpponent, int minDamage, int maxDamage)
	{
		this.characterName = characterName;
		this.hitPoint = hitPoint;
		this.attackSpeed = attackSpeed;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.chanceToHitOpponent = chanceToHitOpponent;
	}//evc 

/**
	   This method returns the name of Character.  This is a simple getMethod.

	   @return		String - charactername
	   @exception	none - No exceptions thrown
	   @see		none
*/	
	public String getCharacterName()
	{
		return this.characterName;
	}//end getCharacterName
/**
	   This method returns hit points of character.  This is a simple getMethod.

	   @return		int - hitPoint
	   @exception	none - No exceptions thrown
	   @see		none
*/		
	public int getHP()
	{
		return this.hitPoint;
	}//end getHP
/**
	   This method returns attack points of character/monster.  This is a simple getMethod.

	   @return		int - attack speed
	   @exception	none - No exceptions thrown
	   @see		none
*/			
	public int getAttackSpeed()
	{
		return this.attackSpeed;
	}//end
/**
	   This method returns the chance to hit an opponent.  This is a simple getMethod.

	   @return		boolean - chanceToHitOpponent
	   @exception	none - No exceptions thrown
	   @see		none
*/			
	public boolean canHit()
	{
		return Math.random() <= chanceToHitOpponent;
	}//end
/**
	   This method returns the damage that is being dealt to character/monster.  This is a simple getMethod.

	   @return		int - damage
	   @exception	none - No exceptions thrown
	   @see		none
*/			
	public int damageTaken()
	{
		return minDamage + (int)Math.random();
	}//end
/**
	   This method does the calculation of how much damage is being dealt. 

	   @return		none
		@param damage -	damage
	   @exception	none - No exceptions thrown
	   @see		none
*/			
	public void subtractHP(int damage)
	{
		this.hitPoint -= damage;
		System.out.println("Attacking... "+characterName+" recieves "+damage+" damage!");
		
		if(hitPoint <= 0)
		{
			hitPoint = 0;
		}	
	}//end
/**
	   This method allows the monster/character to attack each other. 

	   @return		none
		@param opponent -	DungeonCharacter opponent
	   @exception	none - No exceptions thrown
	   @see		none
*/		
	public void attack(DungeonCharacter opponent)
	{
		int damage;
	
		if(canHit())
		{
			damage = damageTaken();
			opponent.subtractHP(damage);
		}
		else
			System.out.println("Attack Failed!!!");
	}
	
}