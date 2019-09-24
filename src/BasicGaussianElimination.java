import java.util.Scanner;
/*
 Angel G. Rosario Cintrón - 841127893

 Basic Gaussian Elimination
 Using an extended array
*/
public class BasicGaussianElimination {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in); 
		MainRun data = new MainRun();
		int n = data.n; // filas
		int m = data.m; // columnas

		double A[][] = data.A;
		double X[][] = new double[n][m];
		
		System.out.println("____________________________");
		System.out.println("|Basic Gaussian Elimination|");
		
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

