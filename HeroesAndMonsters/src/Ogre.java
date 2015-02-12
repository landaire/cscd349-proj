public class Ogre extends Monster
{
	/**
	   This constructor will create a default Ogre.  
	   super calls the constructor in it's parent class Monster.
	  
	   @exception	none - No exceptions thrown
	   @see		"No borrowed code"
	  */
	public Ogre()
	{
		super();
		characterName = "Ogre";
		hitPoint = 600;
		
	}//end defalt constructor
	
	/**
	   This constructor will create a explict Monster.  
	   super calls the base class explict constructor and then
	   we overide with adding some new fields to the constructer
	   @param characterName - The Ogre's name
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
	
	public Ogre(String characterName, int hitPoint, int attackSpeed, double chanceToHit, int minimumDamage, int maximumDamage,double chanceToHeal,int maximumHeal,int minimumHeal)
	{
		super(characterName, hitPoint, attackSpeed, chanceToHit, minimumDamage, maximumDamage, chanceToHeal, maximumHeal, minimumHeal);

	}

}//end class
