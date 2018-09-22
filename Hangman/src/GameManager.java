import java.util.Scanner;
public class GameManager {
	
	Player player = new Player();
	private Scanner reader;
	
	//Method for playing a game
	public void Play(WordPhrase w){
		GuessWord(w);	
		}
	
	//Method for checking if input letter is valid and if it matches
	public void GuessWord(WordPhrase w){
		boolean CorrectGuess = false;
		String Input="  ";
		//Print result from the letter guess
		System.out.println("Attempts left:" +player.Attempts+"\t");
		System.out.println(w.HiddenText);
		System.out.println("Please enter a letter");
		System.out.print(">");
		
		//Check if input is bigger than 1 character	
		while(true){
			CorrectGuess=false;
				reader = new Scanner(System.in);
				Input = reader.next();		
				//If input is incorrect request another	
				if(Input.length()>1){
					System.out.println("Please enter only one letter");
					continue;
				}
				
			char C = Input.charAt(0);
		//Check if letter matches with any in word/phrase and reveal if matched			
				for(Integer i=0; i<w.Text.length();i++){
					if(w.Text.toLowerCase().charAt(i)== C || w.Text.toUpperCase().charAt(i)== C){
						w.HiddenText = w.HiddenText.substring(0,i)+w.Text.charAt(i)+ w.HiddenText.substring(i+1, w.HiddenText.length());
						CorrectGuess=true;			
					}
				}	
				
				//Lose if out of attempts
				if (player.Attempts==0){
					System.out.println("Game Over");
					break;
				}
				
				//Win if the whole word/phrase is guessed
				if(w.Text.equals(w.HiddenText)){
					ChangeScore(player.Score+1);
					System.out.println("Congratulations you have revealed the word/phrase:");
					System.out.println(w.Text);
					System.out.println("Current Score: "+player.Score);
					break;
				}
				if(!CorrectGuess){
					ChangeAttempts(player.Attempts-1);
					System.out.println("The word/phrase does not have this letter");
				}
				//Print result from the letter guess
				System.out.println("Attempts left:" +player.Attempts+"\t");
				System.out.println(w.HiddenText);
				
				//Subtract attempts if guessed letter is not in word/phrase			
				if(!(w.Text.equals(w.HiddenText))){
					System.out.println("Please enter a letter");
					System.out.print(">");
					}		
		}
	}
	
	//Method for changing the amount of attempts
	public void ChangeAttempts(Integer i){
		player.Attempts=i;
		
	}
	//Method for changing the score of the player
	public void ChangeScore(Integer i){
		player.Score = i;
	
	}
}
