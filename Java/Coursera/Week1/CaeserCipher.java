public class CaserCipher {

	
	
	public static String encrypt(String input, int key){
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String encryptalpha = alphabet.substring(key) + alphabet.substring(0, key);
		StringBuffer result= new StringBuffer();
		//String result= "";
		int len = input.length();
	

		for(int i=0; i<len; i++){
		char ch = input.charAt(i);
		
			if(isThere(ch)){
				int loc =alphabet.indexOf(input.charAt(i));
				System.out.println(loc);
				result.append(encryptalpha.charAt(loc));
				}
			
			else{
				result.append(ch);
				}
			   }
		
		return result.toString();
	}
	
	
	public static  boolean isThere(char ch){
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
			int loc = alphabet.indexOf(ch);
			//System.out.print(loc);
			if(loc >= 0){
				return true;
			}
			else{
				return false;
			}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//String encryptalpha = alphabet.substring(23) + alphabet.substring(0, 23);
		System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
	
		//System.out.println(isThere('!'));
		
	}

}
