import java.util.Scanner;
/*
 Angel G. Rosario Cintrón - 841127893
 Eduardo Perez - 841136230

 Gauss Jordan
 Using an extended array
*/
public class GaussJordan {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in); 
		MainRun data = new MainRun();
		int n = data.n; // filas
		int m = data.m; // columnas
		double temp;
		double pivot = 0;
		int k; // pivot

		double A[][] = data.A;
		double X[][] = new double[n][m];

		System.out.println("______________");
		System.out.println("|Gauss Jordan|");
		
		for(k = 0; k < n ; k++){

			pivot = Math.abs(A[k][k]); 		   // pivot element
			int p = k;						   // pivot row
			for(int i = k+1; i < n; i++){
				if(Math.abs(A[i][k]) > pivot){
					pivot = Math.abs(A[i][k]); // updated pivot element
					p = i;					   // updated pivot row
				}
			}
			//System.out.println("PIVOTE MAYOR ---> "+ pivot);
				if (p > k){
					for(int j = 0; j < n+m; j++){
						temp = A[k][j];
						A[k][j] = A[p][j];
						A[p][j] = temp;
					}
				}

			// scale row k
			double pivotS = A[k][k];
			for(int j = k; j < n+m; j++){
				A[k][j] = A[k][j]/pivotS;
			}
				
			// Foward elimination method			
			for(int i = k+1; i < n+m-1; i++){
				double s = -A[i][k]/A[k][k];
				A[i][k] = 0;
				for(int j = k+1; j < n+m; j++){
					A[i][j] = A[i][j] + s*A[k][j];
				}				
			}
			
		}

		System.out.println("");
		System.out.println("Foward elimination:");
		for(int x = 0; x < A.length; x++) {
			for(int y = 0; y < A[x].length; y++)
				System.out.print((new StringBuilder(String.valueOf(A[x][y]))).append(" ").toString());
			System.out.println("");
		}        

		
		// Back elimination method
		
	      for(k=n-1; k <=1; k--){
	    	  for(int i = k-1; i <= 0; i--){
	    		 for(int j=n+m-1; j <= n; j--){
	    			 A[i][j] = A[i][j] - A[i][k]*A[k][j];
	    		 }
	    	  }
		   }
		
		for (int j = 0; j < m; j++){
			for(int i = 0; i < n; i++){
				X[i][j] = A[i][n+j];
			}
		}

		System.out.println("");
		System.out.println("Back Elimination:");
		for(int x = 0; x < X.length; x++) {
			for(int y = 0; y < X[x].length; y++){
            	System.out.println("X[" + (x+1) + "] = " + 
            			(new StringBuilder(String.valueOf(X[x][y]))).append(" ").toString());
            }
            	System.out.println("");
        }

        System.out.println("");
		System.out.println("Seleccione lo que desea hacer:");
		System.out.println("   1 =| Escribir una nueva matriz");
		System.out.println("   2 =| Volver a la seleccion de metodos");
		System.out.println("   3 =| Exit");
		int decision = kb.nextInt();
        
		if (decision == 1){
			MainRun.main(null);
		}
		else if (decision == 2){
			MainRun.selection();
		}
		else if(decision == 3){
			System.exit(0);
		}
		else{
			System.out.println("Error! Invalid input!");
		}
		System.out.println("________________________________________");
		
	}
	
}

