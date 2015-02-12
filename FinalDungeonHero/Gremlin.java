/**
  This class a Grimlin class that inherits the fields and behaviors of  the 
  parent class Monster.
  The monster class is abstract can't create any instances of the class
  
  @History:
  5/1/2012 Started writing the Documentation Standards
  5/7/2012 finish Javadoc and Assignment
  @author  Daniel Moua and Tony Moua
  @see		"No borrowed code"
 */


public class Gremlin extends Monster
{
	/**
	   This constructor will create a defalt Grimlin.  
	   super calls the constructor in it's parent class Monster.
	  
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
	  */
	public Gremlin()
	{
		super();
		characterName = "Pete";
	
	}// end default constructor
	
	/**
	   This constructor will create a explict Monster.  
	   super calls the base class explict constructor and then
	   we overide with adding some new fields to the constructer
	   @param characterName - The Grilin's name
	   @param  hitPoint - The Life of the character
	   @param 	attackSpeed = The characters attack speed
	   @param minimumDamage = the minimum damage a DungeonCharacter can attack
	   @param maximumDamage = the maximum damage a DungeonCharacter can attack
	   @param chanceToHitOpponent = the percent of what you character can susefully attack and hit the opponent
	   @param damageRange - maximumDamage - minimumDamage, rage of the damage to an opponent
	   @param maximumHeal - maximum healing the monster can do
	   @param minimumHeal - minimum healing the monster can do
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
	  */
	public Gremlin(String characterName, int hitPoint, int attackSpeed, double chanceToHit, int minimumDamage, int maximumDamage,double chanceToHeal,int maximumHeal,int minimumHeal)
	{
		super(characterName, hitPoint, attackSpeed, chanceToHit, minimumDamage, maximumDamage, chanceToHeal, maximumHeal, minimumHeal);
	}
}//end Gremlin class