import java.util.Scanner;
/*
 Angel G. Rosario Cintrón - 841127893
Eduardo Perez Cortes - 841-13-6230
 Main class to run the application
 Asks the user the size of the matrix and the number of solution columns
 Then gives the option of which method to use (BGE, GERP or GJ)
*/
public class MainRun {

	static Scanner kb = new Scanner(System.in); 
	static int n; // filas
	static int m; // columnas
	static int method; // chosen method
	static double A[][];
	static double Temp[][];
	static int choice;
	static boolean loop = true;

	public static void main(String[] args) {
		while(loop = true){
			System.out.println("------------------------------------------------");
			System.out.println("Entre el tamaño de la matriz: (ejemplo: 3 = 3x3)");
			n = kb.nextInt();

			System.out.println("Entre la cantidad de columnas de resultados");
			m = kb.nextInt();

			A = new double[n][n+m];
			Temp = new double[n][n+m];

			System.out.println("Introduzca los elementos de la matriz incluyendo los resultados "
					+ "dejando un espacio entre cada numero.");
			for (int x=0; x < A.length; x++) {
				for(int y=0; y < A[x].length; y++) {
					A[x][y] = kb.nextDouble();
				}
			}
			for (int x=0; x < Temp.length; x++) {
				for(int y=0; y < Temp[x].length; y++) {
					Temp[x][y] = A[x][y];
				}
			}
			
			System.out.println("");
			System.out.println("=========================");
			System.out.println("Este es la matriz correcta? (1 = Si ; 2 = No)");
			for(int x = 0; x < A.length; x++) {
	            for(int y = 0; y < A[x].length; y++)
	                System.out.print((new StringBuilder(String.valueOf(A[x][y]))).append(" ").toString());
	            	System.out.println("");
	        }
	        System.out.println("=========================");
	        choice = kb.nextInt();
	        
	        if (choice == 1){
	        	loop = false;
	        	selection();
	        }
	        else if (choice == 2){
	        	loop = true;
	        }
	        else{
	        	System.out.println("Error! Invalid input!");
	        }
			
		}
	}

	public static void selection(){

		for (int x=0; x < A.length; x++) {
			for(int y=0; y < A[x].length; y++) {
				A[x][y] = Temp[x][y];
			}
		}
		
		System.out.println("Seleccione el metodo que desea usar: (Escriba 1, 2, 3 o 4)");
		System.out.println("   1 =| Basic Gaussian Elimination");
		System.out.println("   2 =| Gaussian Elimination with Row Pivot");
		System.out.println("   3 =| Gauss Jordan");
		System.out.println("   4 =| Todos");
		System.out.println("   5 =| Exit");
		method = kb.nextInt();

		if (method == 1){
			BasicGaussianElimination.main(null);
		}
		else if (method == 2){
			GERP.main(null);
		}
		else if (method == 3){
			GaussJordan.main(null);
		}
		else if(method == 4){
			RunAll.main(null);
		}
		else if(method == 5){
			System.exit(0);
		}
		else{
			System.out.println("Error! Invalid input!");
		}
	}

}
