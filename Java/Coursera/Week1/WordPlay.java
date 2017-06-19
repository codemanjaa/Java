
public class WordPlay {
	
	public boolean isVowel(char c){
		
		char ch = Character.toLowerCase(c);
		if(ch=='a' | ch == 'e'| ch=='i' | ch == 'o'| ch == 'u'){
		return true;
		}
		else {
		return false;
		}


		}
	
	public String replaceVowels(String phrase, char ch){
		
		StringBuffer sb = new StringBuffer(phrase);
		char rc = ch;
		int i= 0;
		for(i=0; i<phrase.length();i++){
		char c = sb.charAt(i);
		if(isVowel(c)){
		
		sb.setCharAt(i, rc);
			
			}
			
		}
		
		String result = sb.toString();
		
		return result;
		
	}
	
	public String emphasize(String phrase, char ch){
		
		int len = phrase.length();
		StringBuffer sb = new StringBuffer(phrase);
		
		for(int i=0; i<len; i++){
			
			
			if((Character.toLowerCase(sb.charAt(i))==Character.toLowerCase(ch))){
				if((i % 2)==0){
					sb.setCharAt(i, '+');
				
				
				}
				else {
					sb.setCharAt(i, '*');
				}
			}
		}
		String result = sb.toString();
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPlay wp = new WordPlay();
		System.out.println(wp.isVowel('F'));
		System.out.println(wp.isVowel('a'));
		//System.out.println(wp.isVowel('b'));
		//System.out.println(wp.isVowel('o'));
		//System.out.println(wp.isVowel('O'));

		System.out.println(wp.replaceVowels("Hello World", '*'));
		System.out.println(wp.emphasize("dna ctgaaactga", 'a'));
		System.out.println(wp.emphasize("Mary Bella Abracadabra", 'a'));

	}

}
