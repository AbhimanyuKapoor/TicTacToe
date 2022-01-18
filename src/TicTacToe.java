import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe 
{
	static ArrayList<Integer> playerPositions;
	static ArrayList<Integer> cpuPositions;
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource") //This means resource leaked since its not closed
		Scanner input=new Scanner(System.in);
		while(true)
		{
			System.out.println("Type 'play' to play the game\nOr anything else to stop");
			String option=input.next();
			System.out.println();
			if(option.equalsIgnoreCase("play"))
			{
				System.out.println("Type 'cpu' to play against the computer\nOr type 'player' to play 2 player");
				String against=input.next();
				System.out.println();
				if(against.equalsIgnoreCase("cpu"))
				{
					playerPositions=new ArrayList<Integer>();
					cpuPositions=new ArrayList<Integer>();
					char[][] board1={{'1','|','2','|','3'},
									{'-','+','-','+','-'},
									{'4','|','5','|','6'},
									{'-','+','-','+','-'},
									{'7','|','8','|','9'}};
			
					print(board1);
					System.out.println("These are the positions on the board");
					System.out.println();		
					//Making a 2d array for the gameboard
					char[][] board={{' ','|',' ','|',' '},
									{'-','+','-','+','-'},
									{' ','|',' ','|',' '},
									{'-','+','-','+','-'},
									{' ','|',' ','|',' '}};
			
					print(board);
					int playerPlace;
					int cpuPlace;
			
					System.out.println("Type 'X' or 'O' to choose what you play");
					String choice=input.next();
					System.out.println();
					while(true)
					{
						if(choice.equalsIgnoreCase("x"))
						{
							while(true)
							{
								System.out.println("Enter the position from '1-9'");
								playerPlace=input.nextInt();
								if(1<=playerPlace&&playerPlace<=9)
								{
									if(playerPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else if(cpuPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else
										break;
								}
								else
								{
									System.out.println("Position entered is not from 1-9");
									System.out.println();
									continue;
								}
							}
							System.out.println();
							playerPositions.add(playerPlace);
							
							System.out.println();
							put(board, playerPlace, "player");
							print(board);
							
							System.out.println();
							String res=checkWinner("cpu"); 
							System.out.println(res);
							System.out.println();
							if(res.length()>1)
								break;
							
							System.out.println("Computer's chance:");
							System.out.println("Thinking...");
							try {
								Thread.sleep(1500); //The argument in sleep is of milliseconds
							} 
							catch (Exception e) {
								e.printStackTrace();
							} 
							System.out.println();
							
							while(true)
							{
								Random rand=new Random();
								cpuPlace=rand.nextInt(9)+1; //random give 0 to 8 so +1
								if(playerPositions.contains(cpuPlace))
									continue;
								else if(cpuPositions.contains(cpuPlace))
									continue;
								else
									break;
							}
							cpuPositions.add(cpuPlace);
							put(board, cpuPlace, "cpu");
							print(board);
							
							String result=checkWinner("cpu"); 
							System.out.println(result);
							System.out.println();
							if(result.length()>1)
								break;
						}
						else if(choice.equalsIgnoreCase("o"))
						{	
							System.out.println("Computer's chance:");
							System.out.println("Thinking...");
							try {
								Thread.sleep(1500); 
								//Thread is a class of java.lang package and .sleep is for how many milliseconds should the computer wait
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println();
							
							while(true)
							{
								Random rand=new Random();
								cpuPlace=rand.nextInt(9)+1; //random give 0 to 8 so +1
								if(playerPositions.contains(cpuPlace))
									continue;
								else if(cpuPositions.contains(cpuPlace))
									continue;
								else
									break;
							}
							cpuPositions.add(cpuPlace);
							put(board, cpuPlace, "player");
							print(board);
							
							String result=checkWinner("cpu"); 
							System.out.println(result);
							System.out.println();
							if(result.length()>1)
								break;
							
							
							while(true)
							{
								System.out.println("Enter the position from '1-9'");
								playerPlace=input.nextInt();
								if(1<=playerPlace&&playerPlace<=9)
								{
									if(playerPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else if(cpuPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else
										break;
								}
								else
								{
									System.out.println("Position entered is not from 1-9");
									System.out.println();
									continue;
								}
							}
							System.out.println();
							playerPositions.add(playerPlace);
							
							System.out.println();
							put(board, playerPlace, "cpu"); //Even though this is the player just sending cpu to reverse the symbols
							print(board);
							
							System.out.println();
							String res=checkWinner("cpu"); 
							System.out.println(res);
							System.out.println();
							if(res.length()>1)
								break;
						}
						else
						{
							System.out.println("Inavlid choice!");
							System.out.println();
							break;
						}
					}
				}
				else if(against.equalsIgnoreCase("player"))
				{
					playerPositions=new ArrayList<Integer>();
					cpuPositions=new ArrayList<Integer>();
					//Taking player2 as CPU so that i don't have to change symbols
					char[][] board1={{'1','|','2','|','3'},
									{'-','+','-','+','-'},
									{'4','|','5','|','6'},
									{'-','+','-','+','-'},
									{'7','|','8','|','9'}};
			
					print(board1);
					System.out.println("These are the positions on the board");
					System.out.println();		
					//Making a 2d array for the gameboard
					char[][] board={{' ','|',' ','|',' '},
									{'-','+','-','+','-'},
									{' ','|',' ','|',' '},
									{'-','+','-','+','-'},
									{' ','|',' ','|',' '}};
			
					print(board);
					int playerPlace;
					int cpuPlace;
			
					System.out.println("Player1:\nType 'X' or 'O' to choose what you play");
					String choice=input.next();
					System.out.println();
					while(true)
					{
						if(choice.equalsIgnoreCase("x"))
						{
							while(true)
							{
								System.out.println("Player1's chance:");
								System.out.println("Enter the position from '1-9'");
								playerPlace=input.nextInt();
								if(1<=playerPlace&&playerPlace<=9)
								{
									if(playerPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else if(cpuPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else
										break;
								}
								else
								{
									System.out.println("Position entered is not from 1-9");
									System.out.println();
									continue;
								}
							}
							System.out.println();
							playerPositions.add(playerPlace);
							
							System.out.println();
							put(board, playerPlace, "player");
							print(board);
							
							System.out.println();
							String res=checkWinner("player"); 
							System.out.println(res);
							System.out.println();
							if(res.length()>1)
								break;
													
							while(true)
							{
								System.out.println("Player2's chance:");
								System.out.println("Enter the position from 1-9");
								cpuPlace=input.nextInt();
								if(1<=cpuPlace&&cpuPlace<=9)
								{
									if(playerPositions.contains(cpuPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else if(cpuPositions.contains(cpuPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else
										break;
								}
								else
								{
									System.out.println("Position entered is not from 1-9");
									System.out.println();
									continue;
								}
							}
							cpuPositions.add(cpuPlace);
							put(board, cpuPlace, "cpu");
							print(board);
							
							String result=checkWinner("player"); 
							System.out.println(result);
							System.out.println();
							if(result.length()>1)
								break;
						}
						else if(choice.equalsIgnoreCase("o"))
						{	
							while(true)
							{
								System.out.println("Player2's chance:");
								System.out.println("Enter a position 1-9");
								cpuPlace=input.nextInt();
								if(1<=cpuPlace&&cpuPlace<=9)
								{
									if(playerPositions.contains(cpuPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else if(cpuPositions.contains(cpuPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else
										break;
								}
								else
								{
									System.out.println("Position entered is not from 1-9");
									System.out.println();
									continue;
								}							
							}
							cpuPositions.add(cpuPlace);
							put(board, cpuPlace, "player");
							print(board);
							
							String result=checkWinner("player"); 
							System.out.println(result);
							System.out.println();
							if(result.length()>1)
								break;
							
							
							while(true)
							{
								System.out.println("Player1's chance:");
								System.out.println("Enter the position from '1-9'");
								playerPlace=input.nextInt();
								if(1<=playerPlace&&playerPlace<=9)
								{
									if(playerPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else if(cpuPositions.contains(playerPlace))
									{
										System.out.println("Position already taken!\nEnter another place");
										System.out.println();
										continue;
									}
									else
										break;
								}
								else
								{
									System.out.println("Position entered is not from 1-9");
									System.out.println();
									continue;
								}
							}
							System.out.println();
							playerPositions.add(playerPlace);
							
							System.out.println();
							put(board, playerPlace, "cpu"); //Even though this is the player just sending cpu to reverse the symbols
							print(board);
							
							System.out.println();
							String res=checkWinner("player"); 
							System.out.println(res);
							System.out.println();
							if(res.length()>1)
								break;
						}
						else
						{
							System.out.println("Invalid choice!");
							System.out.println();
							break;
						}
					}
				}
				else
				{
					System.out.println("Invalid choice");
					System.out.println();
				}
			}
			else
				System.exit(0); //Completely terminates the program
		}
	}
	
	public static void print(char[][] board)
	{
		for(char[] r:board) //for-each character array 'r' inside the 2d array
		{
			//var 'r' stores the rows
			for(char element:r)
			{
				System.out.print(element); //First row
			}
			System.out.println(); //goes to next line after the first row
		}
	}
	public static void put(char[][] board, int placement, String user)
	{
		char symbol=' ';
		
		if(user.equals("player"))
		{
			symbol='X';
		}
		else if(user.equals("cpu"))
		{
			symbol='O';
		}
		
		switch(placement) //Changing the position chosen to X as 'X' plays first
		{
			case 1:
				board[0][0]=symbol;
				break;
			case 2:
				board[0][2]=symbol;
				break;
			case 3:
				board[0][4]=symbol;
				break;
			case 4:
				board[2][0]=symbol;
				break;
			case 5:
				board[2][2]=symbol;
				break;
			case 6:
				board[2][4]=symbol;
				break;
			case 7:
				board[4][0]=symbol;
				break;
			case 8:
				board[4][2]=symbol;
				break;
			case 9:
				board[4][4]=symbol;
				break;
		}
	}
	@SuppressWarnings("rawtypes") //Means generic types are used like using List instead of ArrayList
	public static String checkWinner(String who)
	{
		//Listing down all winning conditions
		
		List<Integer> topRow= Arrays.asList(1,2,3);
		//List java.util.List is for an ordered sequence of elements it is an interface
		// .asList converts the array to List
		List<Integer> midRow= Arrays.asList(4,5,6);
		List<Integer> botRow= Arrays.asList(7,8,9);
		
		List<Integer> leftCol= Arrays.asList(1,4,7);
		List<Integer> midCol= Arrays.asList(2,5,8);
		List<Integer> rightCol= Arrays.asList(3,6,9);
		
		List<Integer> cross1= Arrays.asList(1,5,9);
		List<Integer> cross2= Arrays.asList(3,5,7);
		
		//Need to add all the Lists above to a List of all winning conditions which we will check
		List<List> winning= new ArrayList<List>(); //A List of all the List called winning
		//Since List is an interface we can't do List<> 'name'=new List<>()
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		
		winning.add(cross1);
		winning.add(cross2);
		
		if(who.equals("cpu"))
		{
			for(List l:winning)
			{
				if(playerPositions.containsAll(l))
					// If playerPositions containsAll of the elements which are also inside of the List l
					return "Congratulations you have won!";
				else if(cpuPositions.containsAll(l))
					return "You loose :(";
				//If the board is full and there is no winner then there is a tie			
			}
			//If this if would be inside the loop and someone wins on the last chance, it can still send a tie as all the position would be occupied which had happened
			if(playerPositions.size()+cpuPositions.size()==9)
				return "It is a tie";			
		}
		else
		{
			for(List l:winning)
			{
				if(playerPositions.containsAll(l))
					return "Player1 wins!";
				else if(cpuPositions.containsAll(l))
					return "Player2 wins!";
			}
			if(playerPositions.size()+cpuPositions.size()==9)
				return "It is a tie";
		}
		return " ";
	}
}
