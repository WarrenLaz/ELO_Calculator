import java.util.Scanner;
public class LeagELO {

	/* NOTES: 
	 * P_a = 1/(1+10^((B_o-A_o)/400))
	 * P_b =  1/(1+10^((A_o-B_o)/400))
	 * 
	 * Num of Outcome:
	 * Victory = 1
	 * Draw = 0.5
	 * Loss = 0
	 * 
	 * EX:
	 * 
	 * A_l = (1-P_a)
	 * A_f = A_o + 32(1-P_a)
	 * 
	 * A_l = (0-P_a)
	 * A_f = A_o + 32(0-P_a)
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
	
	//
	Scanner in = new Scanner(System.in);
	String Base_rank, AvgBase_rank;
	int num_rank, AvgBase_ranknum, LP;
	int[] ELO;
	//
	
	//
	System.out.println("ENTER YOUR BASE RANK: "); // ----------- BASE
	Base_rank = in.next();
	System.out.println("ENTER YOUR NUMBER RANK: "); // --------- NUM
	num_rank = in.nextInt();
	System.out.println("ENTER YOUR LP: ");
	LP = in.nextInt();
	System.out.println("ENTER TIER AVG BASE RANK: ");
	AvgBase_rank = in.next();
	System.out.println("ENTER TIER AVG NUMBER RANK: ");
	AvgBase_ranknum = in.nextInt();
	//
	
	ELO = GetElo( Base_rank,  num_rank, LP,  AvgBase_rank,  AvgBase_ranknum);
	
	PrintStats(ELO);
	}
	
	public static void PrintStats(int[]ELO) {
		System.out.println("SUCCESS RATE: " + 1/(1+Math.pow(10, (ELO[1]-ELO[0])/400d)));
		System.out.println("LP GAIN: " + 32*(1-(1/(1+Math.pow(10, (ELO[1]-ELO[0])/400d)))));
		System.out.println("LP LOSS: " + 32*(0-(1/(1+Math.pow(10, (ELO[1]-ELO[0])/400d)))));
	}
	
	public static int[] GetElo(String MyBR, int MyNUMR, int LP, String AvgBR, int AvgNUMR ) {

		int[] Elos = new int[2];
		
		switch(MyBR.toLowerCase()) {
		case "iron": Elos[0] = 0 ;break;
		case "bronze": Elos[0] = 400 ;break;
		case "silver": Elos[0] = 800 ;break;
		case "gold": Elos[0] = 1200 ;break;
		case "platinum": Elos[0] = 1600 ;break;
		case "diamond": Elos[0] = 2000 ;break;
		case "masters": Elos[0] = 2400 ;break;
		case "grandmaster": Elos[0] = 2800 ;break;
		case "challenger": Elos[0] = 3200 ;break;
		}
		
		switch(MyNUMR) {
		case 4: Elos[0] += 0;break;
		case 3: Elos[0] += 100;break;
		case 2: Elos[0] += 200;break;
		case 1: Elos[0] += 300;break;
		}
		
		Elos[0] += LP;
		
		switch(AvgBR.toLowerCase()) {
		case "iron": Elos[1] = 0 ;break;
		case "bronze": Elos[1] = 400 ;break;
		case "silver": Elos[1] = 800 ;break;
		case "gold": Elos[1] = 1200 ;break;
		case "platinum": Elos[1] = 1600 ;break;
		case "diamond": Elos[1] = 2000 ;break;
		case "masters": Elos[1] = 2400 ;break;
		case "grandmaster": Elos[1] = 2800 ;break;
		case "challenger": Elos[1] = 3200 ;break;
		}
		
		switch(AvgNUMR) {
		case 4: Elos[1] += 0;break;
		case 3: Elos[1] += 100;break;
		case 2: Elos[1] += 200;break;
		case 1: Elos[1] += 300;break;
		}
		
		return Elos;
	}
	
}
