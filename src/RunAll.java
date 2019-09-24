import java.util.Scanner;
/*
Angel G. Rosario Cintrón - 841127893
Eduardo Perez Cortes - 841-13-6230

*/


public class RunAll {

	public static void main(String[] args) {
		
		System.out.println("==== Basic Gaussian Elimination ====");
		RestArray();
		BGE();
		System.out.println("----------------------");
		
		System.out.println("==== Gaussian Elimination with Row Pivot ====");
		RestArray();
		GERP();
		System.out.println("----------------------");
		
		System.out.println("==== Gauss Jordan ====");
		RestArray();
		GJ();
		System.out.println("----------------------");

		Scanner kb = new Scanner(System.in); 
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

	public static void RestArray(){
		
		double A[][] = MainRun.A;
		double Temp[][] = MainRun.Temp;
		
		for (int x=0; x < A.length; x++) {
			for(int y=0; y < A[x].length; y++) {
				A[x][y] = Temp[x][y];
			}
		}
	}
	
	public static void BGE() {
		MainRun data = new MainRun();
		int n = data.n; // filas
		int m = data.m; // columnas

		double A[][] = data.A;
		double X[][] = new double[n][m];

		// i = recorre filas
		// j = recorre columnas
		for(int k = 0; k < n-1 ; k++){

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

		// Back substitution method
		for (int j = 0; j < m; j++){
			X[n-1][j] = A[n-1][n+j]/A[n-1][n-1];
			for(int k = n - 1; k >= 0; k--){
				double sum = 0;
				for (int col = k + 1; col < n; col++){
					sum = sum + A[k][col] * X[col][j];
					X[k][j] = (A[k][n+j] - sum)/A[k][k];
				}
			}
		}

		System.out.println("");
		System.out.println("Back Substitution:");
		for(int x = 0; x < X.length; x++) {
			for(int y = 0; y < X[x].length; y++){
				System.out.println("X[" + (x+1) + "] = " + 
						(new StringBuilder(String.valueOf(X[x][y]))).append(" ").toString());
			}
			System.out.println("");
		}
	}

	public static void GERP() {
		MainRun data = new MainRun();
		int n = data.n; // filas
		int m = data.m; // columnas
		double temp;
		double pivot = 0;

		double A[][] = data.A;
		double X[][] = new double[n][m];
		
		for(int k = 0; k < n ; k++){

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

			// Foward elimination method
			for(int i = k+1; i < n; i++){
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

		// Back substitution method
		for (int j = 0; j < m; j++){
			X[n-1][j] = A[n-1][n+j]/A[n-1][n-1];
			for(int k = n - 1; k >= 0; k--){
				double sum = 0;
				for (int col = k + 1; col < n; col++){
					sum = sum + A[k][col] * X[col][j];
					X[k][j] = (A[k][n+j] - sum)/A[k][k];
				}
			}
		}

		System.out.println("");
		System.out.println("Back Substitution:");
		for(int x = 0; x < X.length; x++) {
			for(int y = 0; y < X[x].length; y++){
            	System.out.println("X[" + (x+1) + "] = " + 
            			(new StringBuilder(String.valueOf(X[x][y]))).append(" ").toString());
            }
            	System.out.println("");
        }
	}
	
	/// AUN HAY QUE ARREGLAR GAUSS JORDAN !!
	public static void GJ() {
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
				A[i][k] = 0;
				for(int j = k+1; j < n+m; j++){
					A[i][j] = A[i][j] + -A[i][k]*A[k][j];
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
//		for (int i = k-1; i >= 0; i--){
//		    for(int j = n+m-1; j >= n; j--)
//			    A[i][j] = A[i][j] - ( A[i][k-1] * A[k-1][j] );
//	}
		
		for (k = n-1; k > 2; k--){
			for (int i = k-1; i > 0; i--){
				for (int j = n+m-1; i > n; j--){
					A[i][j] = A[i][j] - (A[i][k] * A[k][j]);
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

