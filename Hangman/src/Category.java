import java.util.ArrayList;
import java.util.Random;

public class Category {
	String Name;
	ArrayList<WordPhrase> Words= new ArrayList<WordPhrase>();
	
	//Method for choosing a random word/phrase from the category
	public static WordPhrase PickWord(Category c){
		Random rand = new Random();
		WordPhrase w= c.Words.get(rand.nextInt(c.Words.size()));
		return w;
	}

}
