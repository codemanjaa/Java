public class CaserCipher {

	
	
	public static void testCaesar(){
		
		int key = 17;
		FileResource fr = new FileResource("M:/Coursera/src/message1.txt");
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println(encrypted);
		String decrypted = encrypt(encrypted, 26-key);
		System.out.println(decrypted);
		
	}
	
	public static String encrypt(String input, int key){
		input = input.toUpperCase();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String encryptalpha = alphabet.substring(key) + alphabet.substring(0, key);
		StringBuffer result= new StringBuffer();
		//String result= "";
		int len = input.length();
	

		for(int i=0; i<len; i++){
		char ch = input.charAt(i);
		
			if(isThere(ch)){
				int loc =alphabet.indexOf(input.charAt(i));
				//System.out.println(loc);
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
	
	public static void eyeballDecrypt(String encrypted){
		
		//CaserCipher cs = new CaserCipher();
		
		for(int k=0; k<26; k++){
		String result = encrypt(encrypted, k);
		System.out.println(k + "\t"+result);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//String encryptalpha = alphabet.substring(23) + alphabet.substring(0, 23);
		testCaesar();
		System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
		eyeballDecrypt("LUJYFWAPVU huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula");
		
		
		//System.out.println(isThere('!'));
		
	}

}
