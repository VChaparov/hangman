
public class WordPhrase {
	String Text;
	String HiddenText="";
	
	//Constructor for creating the hidden word/phrase
	public WordPhrase(String text){
		Text=text;
		
		for(Integer i=0;i<Text.length();i++){
			Character c = Text.charAt(i);
			if(Character.isWhitespace(Text.charAt(i))){
				HiddenText+=" ";
			}
			else{
				HiddenText+="_";
			}
		}
		
	}

}
