import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Start {

	public static void main(String[] args) throws IOException {
		
	
	ArrayList<Category> Categories= new ArrayList<Category>();
	Scanner InputReader;
	Charset charset = Charset.forName("Unicode");
	GameManager GM = new GameManager();
	
	//Try to read from file
	Path file = Paths.get("Words.txt");
	try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
	    String line = null;
	    Category Temp = new Category();
	    line=reader.readLine();     		
        	Temp.Name=line.substring(1,line.length());
        	//Iterate through the text file and put Records in the Categories variable
	    while ((line = reader.readLine()) != null) {	    	
	        if(line.charAt(0)!='_'){
	        	Temp.Words.add(new WordPhrase(line));
	        	continue;
        	}
	        Categories.add(Temp);
	        if(line!= null&&line.charAt(0)=='_' ){
	        	Temp = new Category();
	        	Temp.Name=line.substring(1,line.length());
	        	continue;
	        }
	       
	     
	    }
	    //Add the last Category
	    Categories.add(Temp);
	} catch (IOException x) {
	    System.err.format("IOException: %s%n", x);
	}
	for(Integer i = 0; i<Categories.size();i++){
		System.out.println(Categories.get(i).Name);
		for(Integer j = 0; j<Categories.get(i).Words.size();j++){
			System.out.println("   " +Categories.get(i).Words.get(j).Text);
		}
	}
	//Play while you have attempts
	while(GM.player.Attempts >0){
		//List Categories
	System.out.println("Choose a category");
	for(Integer i = 0; i<Categories.size();i++)
		System.out.println(Categories.get(i).Name);
	System.out.print(">");
	//Let user select category
	InputReader = new Scanner(System.in);
	String Input = InputReader.nextLine();
	Integer CategoryPick= null;
	//Check for matching category
	for(Integer i = 0; i<Categories.size();i++){
		if(Input.equals(Categories.get(i).Name))
			CategoryPick = i;
	}
	if(CategoryPick!=null)
	GM.Play(Category.PickWord(Categories.get(CategoryPick)));
	}	
	}
	
}
