import java.io.PrintWriter;

public class jewel_w extends jewels {

	String name = "W";
	boolean condition1 = false;
	boolean condition2 = false;
	boolean condition_left = false;
	boolean condition_up = false;
	boolean sol_ust = false;
	boolean sag_alt = false;
	boolean sag_ust = false;
	
	public  jewel_w() {
	}
	
	@Override
	public void check(int a, int b, jewels[][] list,PrintWriter file) {
		PrintWriter file_1 = new PrintWriter(file);

		
		if(list[a][b] instanceof jewel_w) {
			
			if( ((a-1) >= 0 && list[a-1][b] instanceof jewel_w) || ((a-1) >= 0 && list[a-1][b] instanceof jewel_t)) {  // UST 
				if( ((a-2) >= 0 && list[a-2][b] instanceof jewel_w) || ( (a-2) >= 0 && list[a-2][b] instanceof jewel_t)) { // 2 UST
					
					if(list[a-1][b] instanceof jewel_w && list[a-2][b] instanceof jewel_w) {
						file_1.write("Score: 30 points" + "\n");
						ScoreOfPlayer.scoreOfPlayer += 30;
					}
					if(list[a-1][b] instanceof jewel_w && list[a-2][b] instanceof jewel_t) {
						file_1.write("Score: 35 points" + "\n");
						ScoreOfPlayer.scoreOfPlayer += 35;
					}
					if(list[a-1][b] instanceof jewel_t && list[a-2][b] instanceof jewel_w) {
						file_1.write("Score: 35 points" + "\n");
						ScoreOfPlayer.scoreOfPlayer += 35;
					}
					if(list[a-1][b] instanceof jewel_t && list[a-2][b] instanceof jewel_t) {
						file_1.write("Score: 40 points" + "\n");
						ScoreOfPlayer.scoreOfPlayer += 40;
					}
					
					list[a][b] = new jewel_space();
					list[a-1][b] = new jewel_space();
					list[a-2][b] = new jewel_space();
					
				
					condition1 = true;
					condition_up = true;
				}
			}
			if(condition_up == false) {
				if(((a+1) < list.length && list[a+1][b] instanceof jewel_w) || ((a+1) < list.length && list[a+1][b] instanceof jewel_t)) { // ALT
					if(((a+2) < list.length && list[a+2][b] instanceof jewel_w) || ((a+2) < list.length && list[a+2][b] instanceof jewel_t)) { // 2 ALT
						
						
						if(list[a+1][b] instanceof jewel_w && list[a+2][b] instanceof jewel_w) {
							file_1.write("Score: 30 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 30;
						}
						if(list[a+1][b] instanceof jewel_w && list[a+2][b] instanceof jewel_t) {
							file_1.write("Score: 35 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 35;
						}
						if(list[a+1][b] instanceof jewel_t && list[a+2][b] instanceof jewel_w) {
							file_1.write("Score: 35 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 35;
						}
						if(list[a+1][b] instanceof jewel_t && list[a+2][b] instanceof jewel_t) {
							file_1.write("Score: 40 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 40;
						}
						
						list[a][b] = new jewel_space();
						list[a+1][b] = new jewel_space();
						list[a+2][b] = new jewel_space();
						
						
						
						
						condition1 = true;
					}
				}
			}
			
			
			
	
			
			if(condition1 == false) {  // UST VE ALT KOSULU SAGLANMIYOR ISE 
				if(((b-1) >= 0 && list[a][b-1] instanceof jewel_w) || ((b-1) >= 0 && list[a][b-1] instanceof jewel_s)) { // SOL	
					if(((b-2) >= 0 && list[a][b-2] instanceof jewel_w) || ((b-2) >= 0 && list[a][b-2] instanceof jewel_s)) { // 2 SOL
						
						if(list[a][b-1] instanceof jewel_w && list[a][b-2] instanceof jewel_w) {
							file_1.write("Score: 30 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 30;
						}
						if(list[a][b-1] instanceof jewel_w && list[a][b-2] instanceof jewel_s) {
							file_1.write("Score: 35 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 35;
						}
						if(list[a][b-1] instanceof jewel_s && list[a][b-2] instanceof jewel_w) {
							file_1.write("Score: 35 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 35;
						}
						if(list[a][b-1] instanceof jewel_s && list[a][b-2] instanceof jewel_s) {
							file_1.write("Score: 40 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 40;
						}
						
						list[a][b] = new jewel_space();
						list[a][b-1] = new jewel_space();
						list[a][b-2] = new jewel_space();
						
						
						
						condition2 = true;
						condition_left = true;
					}
				}
				if(condition_left == false) {
					if(((b+1) < list[0].length && list[a][b+1] instanceof jewel_w) || ((b+1) < list[0].length && list[a][b+1] instanceof jewel_s)) { // SAG
						if(((b+2) < list[0].length && list[a][b+2] instanceof jewel_w) || ((b+2) < list[0].length && list[a][b+2] instanceof jewel_s)) { // 2 SAG
							
							
							if(list[a][b+1] instanceof jewel_w && list[a][b+2] instanceof jewel_w) {
								file_1.write("Score: 30 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 30;
							}
							if(list[a][b+1] instanceof jewel_w && list[a][b+2] instanceof jewel_s) {
								file_1.write("Score: 35 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 35;
							}
							if(list[a][b+1] instanceof jewel_s && list[a][b+2] instanceof jewel_w) {
								file_1.write("Score: 35 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 35;
							}
							if(list[a][b+1] instanceof jewel_s && list[a][b+2] instanceof jewel_s) {
								file_1.write("Score: 40 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 40;
							}
							
							
							list[a][b] = new jewel_space();
							list[a][b+1] = new jewel_space();
							list[a][b+2] = new jewel_space();
							
							
							
							condition2 = true;
						}
					}
				}
				
				
			}
			
			
			if(condition1 == false && condition2 == false) {
				if( ((a-1) >= 0 && (b-1) >= 0 && list[a-1][b-1] instanceof jewel_w) || ((a-1) >= 0 && (b-1) >= 0 && list[a-1][b-1] instanceof jewel_d)) {  // SOL UST	
					if(0 <= (a-2) && 0 <= (b-2) && list[a-2][b-2] instanceof jewel_w || 0 <= (a-2) && 0 <= (b-2) && list[a-2][b-2] instanceof jewel_d) {  // SOL UST SOL USTUN SOL USTU KONTROL EDILECEK ( 9DA ISE)
						
						if(list[a-1][b-1] instanceof jewel_w && list[a-2][b-2] instanceof jewel_w) {
							file_1.write("Score: 30 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 30;
						}
						if(list[a-1][b-1] instanceof jewel_w && list[a-2][b-2] instanceof jewel_d) {
							file_1.write("Score: 50 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 50;
						}
						if(list[a-1][b-1] instanceof jewel_d && list[a-2][b-2] instanceof jewel_w) {
							file_1.write("Score: 50 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 50;
						}
						if(list[a-1][b-1] instanceof jewel_d && list[a-2][b-2] instanceof jewel_d) {
							file_1.write("Score: 70 points" + "\n");
							ScoreOfPlayer.scoreOfPlayer += 70;
						}
						
						list[a][b] = new jewel_space();
						list[a-1][b-1] = new jewel_space();
						list[a-2][b-2] = new jewel_space();
						
						
						
						sol_ust = true;
						
					}
				}
				if(sol_ust == false) {
					if( ((a+1) < list.length && (b+1) < list[0].length && list[a+1][b+1] instanceof jewel_d)  || ((a+1) < list.length && (b+1) < list[0].length && list[a+1][b+1] instanceof jewel_w)) { // SOL UST YOK SAG ALT VAR 
						if( ((a+2) < list.length && (b+2) < list[0].length && list[a+2][b+2] instanceof jewel_d) || ((a+2) < list.length && (b+2) < list[0].length && list[a+2][b+2] instanceof jewel_w)) { //SAG ALT VAR SAG ALTIN SAG ALTI DA VAR (1DE ISE)
							
							if(list[a+1][b+1] instanceof jewel_w && list[a+2][b+2] instanceof jewel_w) {
								file_1.write("Score: 30 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 30;
							}
							if(list[a+1][b+1] instanceof jewel_w && list[a+2][b+2] instanceof jewel_d) {
								file_1.write("Score: 50 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 50;
							}
							if(list[a+1][b+1] instanceof jewel_d && list[a+2][b+2] instanceof jewel_w) {
								file_1.write("Score: 50 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 50;
							}
							if(list[a+1][b+1] instanceof jewel_d && list[a+2][b+2] instanceof jewel_d) {
								file_1.write("Score: 70 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 70;
							}
							
							list[a][b] = new jewel_space();
							list[a+1][b+1] = new jewel_space();
							list[a+2][b+2] = new jewel_space();
							
							
							
							sag_alt = true;
						}
					}
				}
				
				if(sol_ust == false && sag_alt == false) {
					if( ((a-1) >= 0 && (b+1) < list[0].length && list[a-1][b+1] instanceof jewel_d)  || ((a-1) >= 0 && (b+1) < list[0].length && list[a-1][b+1] instanceof jewel_w)) {  // SAG UST	
						if( (0 <= (a-2) && (b+2) < list[0].length && list[a-2][b+2] instanceof jewel_d)  || (0 <= (a-2) && (b+2) < list[0].length && list[a-2][b+2] instanceof jewel_w)) { // SAG UST VAR SOL ALT YOK SAG USTUN SAG USTU KONTROL EDILECEK ( 7DE ISE)
							
							
							if(list[a-1][b+1] instanceof jewel_w && list[a-2][b+2] instanceof jewel_w) {
								file_1.write("Score: 30 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 30;
							}
							if(list[a-1][b+1] instanceof jewel_w && list[a-2][b+2] instanceof jewel_d) {
								file_1.write("Score: 50 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 50;
							}
							if(list[a-1][b+1] instanceof jewel_d && list[a-2][b+2] instanceof jewel_w) {
								file_1.write("Score: 50 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 50;
							}
							if(list[a-1][b+1] instanceof jewel_d && list[a-2][b+2] instanceof jewel_d) {
								file_1.write("Score: 70 points" + "\n");
								ScoreOfPlayer.scoreOfPlayer += 70;
							}
							
							
							list[a][b] = new jewel_space();
							list[a-1][b+1] = new jewel_space();
							list[a-2][b+2] = new jewel_space();
							
							
							
							sag_ust = true;
						}
					}
					if(sag_ust == false) {
						if( ((a+1) < list.length && (b-1) >= 0 && list[a+1][b-1] instanceof jewel_d)  ||  ((a+1) < list.length && (b-1) >= 0 && list[a+1][b-1] instanceof jewel_w)  )   { // SAG UST YOK SOL ALT VAR
							if( ((a+2) < list.length && 0 <= (b-2) && list[a+2][b-2] instanceof jewel_d)  || ((a+2) < list.length && 0 <= (b-2) && list[a+2][b-2] instanceof jewel_w)) { // SOL ALT VAR SOL ALTIN SOL ALTI DA VAR ( 3TE ISE)
								
								
								if(list[a+1][b-1] instanceof jewel_w && list[a+2][b-2] instanceof jewel_w) {
									file_1.write("Score: 30 points" + "\n");
									ScoreOfPlayer.scoreOfPlayer += 30;
								}
								if(list[a+1][b-1] instanceof jewel_w && list[a+2][b-2] instanceof jewel_d) {
									file_1.write("Score: 50 points" + "\n");
									ScoreOfPlayer.scoreOfPlayer += 50;
								}
								if(list[a+1][b-1] instanceof jewel_d && list[a+2][b-2] instanceof jewel_w) {
									file_1.write("Score: 50 points" + "\n");
									ScoreOfPlayer.scoreOfPlayer += 50;
								}
								if(list[a+1][b-1] instanceof jewel_d && list[a+2][b-2] instanceof jewel_d) {
									file_1.write("Score: 70 points" + "\n");
									ScoreOfPlayer.scoreOfPlayer += 70;
								}
								
								list[a][b] = new jewel_space();
								list[a+1][b-1] = new jewel_space();
								list[a+2][b-2] = new jewel_space();
								
								
								
							}
						}
					}
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
		
			
			

			
			
		

				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}
	
	@Override
	public String toString() {
		return this.name;
		
	}
	
} 