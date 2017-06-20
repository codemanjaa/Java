import java.util.Random;
import java.util.Scanner;


public class SimpleSimulation {
	
	
	public static void allDiceCounter(int rolls){
		Random rand = new Random();
		
		
		int counter[] = new int[13];
		
		for(int i=0; i<rolls; i++){
			
			int d1 = rand.nextInt(6) + 1;
			int d2 = rand.nextInt(6) + 1;
			//System.out.println(d1+"\t+\t"+d2+"\t ="+(d1+d2));
			counter[d1+d2] += 1;
					
			
		}
		
		for(int i=2; i<13; i++){
			System.out.println(i+"'s= \t"+ counter[i] + "\t"+ (100.0*counter[i])/rolls);
			
		}
		
		
	}

	public static void diceCalc(int rolls){
		Random rand = new Random();
		int twos = 0, twelves = 0;
		
		for (int i=0; i<rolls; i++){
			int d1 = rand.nextInt(6) + 1;
			int d2 = rand.nextInt(6) + 1;
			//System.out.println("D1 is \t\t"+d1);
			//System.out.println("D2 is \t\t"+d2);
			
			if((d1+d2) == 2){
				twos +=  1;
				
			}else
			if((d1+d2)== 12){
				twelves += 1;
			} 
		}
		
		System.out.println("Twos are \t"+twos+"\t"+ ((100.0*twos)/rolls));
		System.out.println("Twelves are \t"+ twelves+ "\t"+ (100.0*twelves)/rolls);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		System.out.print("Enter the number of Rolls to dice =>");
		int r = scr.nextInt();
		scr.close();
		diceCalc(r);
		System.out.println("----+++++++++++++++-----------++++++++++++++--------------");
		allDiceCounter(r);
		
	}

}
