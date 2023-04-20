import java.awt.Window.Type;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class bejeweled {
	
	public static void play(String a, String b) {
				
		methodCaller methodCaller = new methodCaller();
		ArrayList<ArrayList<jewels>> outerList = new ArrayList<>();
		ArrayList<String>  commands = new ArrayList<String>();

		jewel_d jewel_d_Object = new jewel_d();
		jewel_t jewel_t_Object = new jewel_t();
		jewel_s jewel_s_Object = new jewel_s();
		jewel_w jewel_w_Object = new jewel_w();
		symbolSlash symbolSlash_Object = new symbolSlash();
		symbolMinus symbolMinus_Object = new symbolMinus();
		symbolPlus symbolPlus_Object = new symbolPlus();
		SymbolReverseSlash symbolReverse_Object = new SymbolReverseSlash();
		SymbolVertical symbolVertical_Object = new SymbolVertical();


		
		
		// Taking input and creating grid
		
		try {
			File file = new File(a);
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				ArrayList<jewels> innerList = new ArrayList<>();
				String line = sc.nextLine();
				for(String s : line.split("\\s")) {
					if(s.equals("D")) {
						innerList.add(new jewel_d());					
					}					
					if(s.equals("T")) {
						innerList.add(new jewel_t());
					}
					
					if(s.equals("S")) {
						innerList.add(new jewel_s());
					}					
					if(s.equals("W")) {
						innerList.add(new jewel_w());
					}
					if(s.equals("/")) {
						innerList.add(new symbolSlash());
					}
					if(s.equals("-")) {
						innerList.add(new symbolMinus());
					}
					if(s.equals("+")) {
						innerList.add(new symbolPlus());
					}
					if(s.equals("\\")) {
						innerList.add(new SymbolReverseSlash());
					}
					if(s.equals("|")) {
						innerList.add(new SymbolVertical());
					}
				}
				outerList.add(innerList);
				}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		// CONVERTING 2D ARRAYLIST TO 2D ARRAY
		jewels[][] gridArray = outerList.stream().map(u -> u.toArray(new jewels[0])).toArray(jewels[][]::new);
		
		
		
		// Taking commands from command.txt
		try {
			File file = new File(b);
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				commands.add(line);
			}		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//	methodCaller.printGrid(gridArray, outputStream); == TXT YE GRID YAZDIRMA

		//		methodCaller.printGrid(gridArray);  == KONSOLA GRID YAZDIRMA

		
		
		try {
			PrintWriter outputStream = new PrintWriter("monitorizing.txt");
			outputStream.println("Game grid:" + "\n");
			methodCaller.printGrid(gridArray, outputStream);
			outputStream.write("---------------------------------------------------------------------------" + "\n");
			System.out.println();


			//Reading commands
			for (String command : commands) {
				if(command.contains("0") || command.startsWith("1") || command.startsWith("2") || command.startsWith("3") || command.startsWith("4") || command.startsWith("5") || command.startsWith("6") || command.startsWith("7") || command.startsWith("8") || command.startsWith("9")){
					String[] coordinateList = command.split("\\s");
					Integer y_coordinate = Integer.parseInt(coordinateList[0]);
					Integer x_coordinate = Integer.parseInt(coordinateList[1]);
					
					
					
					
					if(gridArray[y_coordinate][x_coordinate] instanceof jewel_space) {  // SECILEN KOORDINAT BOS ISE
						outputStream.write("---------------------------------------------------------------------------" + "\n");
						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");

						outputStream.println("Please enter a valid coordinate" + "\n" );
						outputStream.write("---------------------------------------------------------------------------" + "\n");


					}
					
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof jewel_d) {  // SECILEN KOORDINAT D ISE 
						
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");

						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");

						
						jewel_d_Object.check(y_coordinate, x_coordinate, gridArray,outputStream);				

						
						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						outputStream.write("\n");

						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");

						
						//System.out.println("Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");
						//outputStream.println("Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");



						
					}
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof jewel_t) { // SECILEN KOORDINAT T ISE
						
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");
						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");

						
						jewel_t_Object.check(y_coordinate, x_coordinate, gridArray,outputStream);


						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						outputStream.write("\n");

						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");


						//System.out.println("Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");
						//outputStream.println( "Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");

					}
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof jewel_s) {  // SECILEN KOORDINAT S ISE
						
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");

						outputStream.println( "Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");
						
						
						jewel_s_Object.check(y_coordinate, x_coordinate, gridArray,outputStream);



						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						
						outputStream.write("\n");
						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");



						
						//System.out.println("Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");
						//outputStream.println("Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");

					}
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof jewel_w) {  // SECILEN KOORDINAT W ISE
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");

						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");

						
						jewel_w_Object.check(y_coordinate, x_coordinate, gridArray,outputStream);


						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						outputStream.write("\n");					
						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");


						
						//System.out.println( "Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");
						//outputStream.println("Score:" + ScoreOfPlayer.scoreOfPlayer + "\n");

						
					}
					
					
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof symbolSlash) {  // SECILEN KOORDINAT / ISE
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");

						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");
						
						symbolSlash_Object.check(y_coordinate, x_coordinate, gridArray, outputStream);


						
						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						outputStream.write("\n");

						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");

					}
					
					
					
					
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof symbolMinus) {  // SECILEN KOORDINAT - ISE
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");
						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");

						
						symbolMinus_Object.check(y_coordinate, x_coordinate, gridArray, outputStream);

						
						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						outputStream.write("\n");

						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");


					}
					
					
					
					
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof symbolPlus) {  // SECILEN KOORDINAT + ISE
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");
						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");
						
						symbolPlus_Object.check(y_coordinate, x_coordinate, gridArray, outputStream);

						
						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						outputStream.write("\n");

						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");



					}
					
					
					
					
									
					
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof SymbolReverseSlash) {  // SECILEN KOORDINAT \ ISE
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");
						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");
						
						symbolReverse_Object.check(y_coordinate, x_coordinate, gridArray, outputStream);

						
						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						
						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");


					}

					
					
					
					
					
					else if(gridArray[y_coordinate][x_coordinate] instanceof SymbolVertical) {  // SECILEN KOORDINAT | ISE
						
						outputStream.write("---------------------------------------------------------------------------" + "\n");

						outputStream.println("Select coordinate or enter E to end the game:" +y_coordinate +" "+ x_coordinate + "\n");

						
						symbolVertical_Object.check(y_coordinate, x_coordinate, gridArray, outputStream);

						
						for (int i = 0; i < gridArray.length; i++) {
							methodCaller.gravity(gridArray);
						}
						
						
						methodCaller.printGrid(gridArray, outputStream);
						outputStream.println();
						outputStream.write("---------------------------------------------------------------------------" + "\n");


					}



					
					
					
					
				}
				
				
				
				
				
				if(command.equals("E")) {
					outputStream.println("Select coordinate or enter E to end the game: E" + "\n");	

					outputStream.println("Total score: " + ScoreOfPlayer.scoreOfPlayer + " points" + "\n");


				}
				
				
				 
				else if(!command.contains("0") && !command.contains("1") && !command.contains("2") && !command.contains("3") && !command.contains("4") && !command.contains("5") && !command.contains("6") && !command.contains("7") && !command.contains("8") && !command.contains("9") && !command.equals("E") && !command.equals("") ) {
					outputStream.println("Enter name:  " + command +"\n");
					try {
						FileWriter fileWriter = new FileWriter("leaderboard.txt",true);
						
						//
						
						int count = 0;
						ArrayList<Integer> leaders = new ArrayList<Integer>();	

						File file = new File("leaderboard.txt"); //DOSYA KONUMUNU KONTROL ET 
						Scanner sc = new Scanner(file);
						fileWriter.write("\n");
						fileWriter.write(command + " " + ScoreOfPlayer.scoreOfPlayer + "\n");
						while(sc.hasNextLine()) {
							count += 1;
							String leaderLine = sc.nextLine();
							String[] xx = leaderLine.split(" ");
							
							try {
								leaders.add(Integer.parseInt(xx[1]));
							}
							catch (Exception e) {
							}

							
							
							//System.out.println(Integer.parseInt(xx[1])); 
							//fileWriter.write(leaderLine + "\n");
						}
						leaders.add(ScoreOfPlayer.scoreOfPlayer);
						Collections.sort(leaders);
						leaders.sort(Comparator.reverseOrder());
						
						int numToFind = ScoreOfPlayer.scoreOfPlayer;
						count += 1; 
						
						System.out.println();
						
						for(int i=0; i < leaders.size(); i++) {
							int val = leaders.get(i);
							if(val == numToFind) {
								outputStream.println("Your rank is " + (i+1)+  "/" + count  + "\n" + "\n" + "Goodbye");

							}
						}

						//
						fileWriter.close();
						sc.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					


				}
				
				
				
				
				
				
			}
			
			outputStream.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		//System.out.println(matrix.get(2).charAt(0));
		
		/*for (Object string : matrix) {
			System.out.println(string);
		}*/
	}

}


