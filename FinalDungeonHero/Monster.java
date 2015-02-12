/**
  This class a Monster class that inherits the fields and behaviors of  the 
  Base class DungeonCharacter.
  The monster class is abstract can't create any instances of the class
 
  @History:
  5/1/2012 Started writing the Documentation Standards
  5/7/2012 finish Javadoc and Assignment
  
  @author  Daniel Moua and Tony Moua
  @see No borrowed codes
 */

import java.util.Scanner;
public abstract class Monster extends DungeonCharacter
{
	
	protected double chanceToHeal;
	protected int maximumHeal, minimumHeal,healRange;
	
	/**
	   This constructor will create a default Hero.  
	   super calls the constructor in the base class and adds new fields into the 
	   overide constructor
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
	  */

	public Monster()
	{
		super();
		chanceToHeal = .50;
		maximumHeal = 50;
		minimumHeal = 10;
		healRange = maximumHeal - minimumHeal;
	}//end default constructor
	
	/**
	  	This constructor will create a explict Hero.  
	   super calls the base class explict constructor and then
	   we overide with adding some new fields to the constructer
	   @param characterName - The DungeonCharacter's name
	   @param  hitPoint - The Life of the character
	   @param 	attackSpeed = The characters attack speed
	   @param minimumDamage = the minimum damage a DungeonCharacter can attack
	   @param maximumDamage = the maximum damage a DungeonCharacter can attack
	   @param chanceToHitOpponent = the percent of what you character can susefully attack and hit the opponent
	   @param damageRange - maximumDamage - minimumDamage, rage of the damage to an opponent
	   @param maximumHeal - maximum healing the monster can do
	  * @param minimumHeal - minimum healing the monster can do
	  * @exception	none - No exceptions thrown
	  * @see		"No borrowed code"
	  */
	
	public Monster(String characterName, int hitPoint, int attackSpeed, double chanceToHit, int minimumDamage, int maximumDamage,double chanceToHeal,int maximumHeal,int minimumHeal)
	{
		super(characterName,hitPoint,attackSpeed,chanceToHit,minimumDamage,maximumDamage);
		this.chanceToHeal = chanceToHeal;
		this.maximumHeal = maximumHeal;
		this.minimumHeal = minimumHeal;
	}//end explict constructor
	
	
	/**
	   This method caculates the heal that can heal your self when HP down
	   it generates a number + the minHeal * the healRange + 1 .
	  
	   @return int - the damage applied to an opponent
	   @exception	NullReferenceException - thrown if the name passed in is null
	   @see		"No borrowed code"
	  */

		public int calculateHeal()
	{
	 	return  minimumHeal + (int)(Math.random() * (healRange+1));
	}//end rangeOfHeal method
	
	 /**
	   This method see's if Monster can heal based on weather true or false,implying
	   if can heal "true", if can not heal then "false".
	   @return	boolean - true or false
	   @exception	NullReferenceException - thrown if the name passed in is null
	   @see		"No borrowed code"
	  */
	
	public boolean canHeal()
	{
		return   Math.random() <= this.chanceToHeal;
	}//end can heal
	
	/**
	   A convenience method to allow for the printing of the Monster's  data.  This method
	   will return the Name of Character, attack speed , min Damage, max Damage, chance to hit, minHeal,
	 	 maxHeal, and chanceToHeal.
	  
	   @return		String - The of the Monster's information formatted.
	   @exception	none - No exceptions thrown
	   @see	"No borrowed code"
	  */
	
	public String toString()
	{	
		String result;
		result = super.toString();
		//result += String.format("chanceToHeal: %5f", this.chanceToHeal);
		//result += this.maximumHeal;
		//result += this.minimumHeal;
		return result;
		
	}
	
	/*This method overides the attack method in DungeonCharacter but calls the super
	   to keep the attack method the same but add changes to it.
	  
	   @param DungeonCharacter = DungeonCharacter
	   @return	void
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
	  */
	public void attack(DungeonCharacter opponent)
	{
		super.attack(opponent);
	}//end attack
	
	/*This method calls the super class subtrack method and overrides it
	  *
	  
	  * @return	void
	  * @exception	none - No exceptions thrown
	  * @see		"No borrowed code"
	  */	
	
	
	public void subtractHP(int damage)
	{
		super.subtractHP(damage);
		if (this.hitPoint > 0)
			if (canHeal())
			{
				int healAmount = calculateHeal();

				this.hitPoint += healAmount;
				System.out.println(this.characterName + " healed himself and added " + healAmount + " hit points for a total of " + this.hitPoint);
			}//end
	}//end method



}// end Monster class