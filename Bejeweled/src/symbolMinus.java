import java.io.PrintWriter;

public class symbolMinus extends symbols {
	
	String name = "-";
	
	boolean left = false;
	boolean left2 = false;
	int count = 0;

	
	@Override
	public void check(int a, int b, jewels[][] list, PrintWriter file) {
		PrintWriter file_1 = new PrintWriter(file);
		if((b-1) >= 0 && list[a][b-1] instanceof symbols ) { // SOL
			if(0 <= (b-2) && list[a][b-2] instanceof symbols ) { //SOLUN SOLU (SAGDA OLDUGU DURUM)
				count += 1;
				list[a][b] = new jewel_space();
				list[a][b-1] = new jewel_space();
				list[a][b-2] = new jewel_space();
				ScoreOfPlayer.scoreOfPlayer += 60;
				file_1.write("Score: 60 points" + "\n");
				if (count == 1) {
					left = true;
				}
				if(count == 2 ) {
					left2 = true;
				}
			}
			
		}
		
		if(left == false || ( left == true && left2 == false)) {
			if( (b+1) < list[0].length  && list[a][b+1] instanceof symbols) { // SOLDA YOK SAGDA VAR
				if( (b+2) < list[0].length && list[a][b+2] instanceof symbols) { // SAGIN SAGI ( SOLDA OLDUGU DURUM)
					list[a][b] = new jewel_space();
					list[a][b+1] = new jewel_space();
					list[a][b+2] = new jewel_space();
					ScoreOfPlayer.scoreOfPlayer += 60;
					file_1.write("Score: 60 points" + "\n");
				}
			}
		}
	}
	
	
	@Override
	public String toString() {
		return this.name;
		
	}
	

}
