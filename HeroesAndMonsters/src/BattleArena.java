import java.util.Random;
import java.util.Scanner;

public class BattleArena
{
	Scanner kb = new Scanner(System.in);
	
	//start main
	public static void main(String [] args)
	{
	BattleArena  b = new BattleArena();
	do
	{
		DungeonCharacter hero, monster;
		hero = b.chooseHero();
		System.out.println(hero + "\n");
		//System.out.println(hero.toString());
		
		monster = b.randomMonster();
		System.out.println(monster + "\n");
	
		while(hero.hitPoint > 0 && monster.hitPoint > 0)
		{
				System.out.println("--" + hero.characterName + " " + "ATTACKS" + " " + monster.characterName+ "--" + "\n");
				hero.attack(monster);
				System.out.println(monster.characterName + " " + "HP: " + monster.hitPoint + "\n\n" ) ;
		
		if(monster.hitPoint > 0)
		{
			System.out.println("--" + monster.characterName + " " + "ATTACKS" + " " + hero.characterName+ "--" + "\n");
			monster.attack(hero);
			System.out.println(hero.characterName + " " + "HP: " + hero.hitPoint+"\n" ) ;
		}
		else
		{
			System.out.println(monster.characterName + " "+ "is dead");
		} //end else
	
		}//end while

	}while(b.playAgain() == true);
}//end main

/**
	   This method allows the user to pick the hero she/he wants to play as.  This is a simple choose hero method.

	   @return		no return
	   @exception	none - No exceptions thrown
	   @see		none
	  */
	public DungeonCharacter chooseHero()
	{
		String choice;
		
		do
		{
		System.out.println("Please select a Hero: " + "\n");
		System.out.println( "a. Warrior\n"
								+ "b. Sorceress\n"
								+ "c. Thief");
		System.out.print("Enter your choice> ");
		choice = kb.nextLine();
		
		if (choice.charAt(0) < 'a' || choice.charAt(0) > 'c')
		{
		System.out.println("Invalid  choice, try again!");
		}//end if
		}
		while (choice.charAt(0) < 'a' || choice.charAt(0) > 'c');				
		switch (choice.charAt(0))
			{
				case 'a': System.out.println("You have choosen a Warrior"); //warrior choice
						  return new Warrior("Beast",500, 4,.80,70,95,.30);
				case 'b': System.out.println("You've choosen a Sorceress!");//sorrceress choice
						  return new Sorceress("Mage",300,5,.70,25,45,.30);
				case 'c': System.out.println("You have choosen a Thief!");//Thief choice
						  return new Thief("Ninja",400,5,.70,25,45,.30);
				default:
						  System.out.println("Invalid character. Warrior was choosen for you! ");
						  return new Warrior();
			}//end switch
		
	}//end chooseHero
/**
	   This method randomly selects a monster that you will be going up against.  This is a simple random method.

	   @return		no return
	   @exception	none - No exceptions thrown
	   @see		none
	  */	
	public DungeonCharacter randomMonster()
	{
		int num;
		Random generator = new Random();
		num = 1 + generator.nextInt(3);
		
		if(num == 1)
		{
			System.out.println("You are fighting an Ogre" + "\n");
			return new Ogre("Ogre", 400,2,.60,30,60,.10,30,40);
		}
		else if(num == 2)
		{
			System.out.println("You are fighting an Gremilin" + "\n");
			return new Gremlin("Gremlin", 250,5,.80,15,30,.40,20,40);
		} 
		else
			System.out.println("You are fighting an Skeleton" + "\n");
			return new Skeleton("Bones", 220,3,.80,30,50,.30,30,50);
	}//end random pick for monsters

/*
	   This method ask if the user would like to play again.  This is a simple play again method.

	   @return		boolean
	   @exception	none - No exceptions thrown
	   @see		none
	  */	
	public boolean playAgain()//to see if player wants to play again.
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Want to play again(y/n) ?");
		
		String answer; 
		answer = kb.next();
		kb.nextLine();
	do
	{	
		if (answer.equalsIgnoreCase("y")) 
		{ 
			//System.out.println("returning true");
			return true; 
		} 
		else if (answer.equalsIgnoreCase("n"))
		{
			return false;
		}
		else 
		{
			System.out.print(" Invalid input, plaese enter yes or no: ");
			answer = kb.next();
		}	
		}while(!(answer.equalsIgnoreCase("y")) || !(answer.equalsIgnoreCase("n")));
		
		return false;
	}//end play again

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
	

}//end class