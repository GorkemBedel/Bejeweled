import java.util.ArrayList;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.*;
import java.io.*;

public abstract class jewels {
	int y_coordinate;
	int x_coordinate;
	
	
	
		
	public abstract void check(int a, int b, jewels[][] list,PrintWriter file);
	
	
	
	
	public void replace(int a, int b, String[][] list) {
		list[a][b] = " ";
	}
	
	
	
	// PRINT GRID METHOD
	
	
	public void printGrid(jewels[][] list,PrintWriter file) throws FileNotFoundException{
		PrintWriter file_1 = new PrintWriter(file);
		for(int i = 0; i < 10; i++)
		   {
		      for(int j = 0; j < 10; j++)
		      {
		         file_1.printf(list[i][j]+ " ");

		      }
		      file_1.println();
		   }
		   
	}
	
	
	
	
	
	public void printGrid(jewels[][] list){
		for(int i = 0; i < 10; i++)
		   {
		      for(int j = 0; j < 10; j++)
		      {
		         System.out.printf(list[i][j]+ " ");

		      }
		      System.out.println();

		   }		   
	}
	
	
	
	
	public void gravity(jewels[][] list) {		
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[0].length; j++) {
				if(i > 0) {
					if(list[i][j] instanceof jewel_space) {
						list[i][j] = list[i-1][j];
						list[i-1][j] = new jewel_space();
					}
				}
			}		
		}
	}
	
	
	
	// DELETING GRID ELEMENT
	public void delete(int a, int b, jewels[][] list) {
		list[a][b] = new jewel_space();
	}
	
	
	
	
	
}
