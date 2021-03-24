package pr2.org.dominio;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
* Esta clase es responsable de leer el tablero de un
* fichero en forma de ceros y unos, ir transitando de
* estados e ir mostrando dichos estados.
*/


/* Las reglas son las habituales:
a) Si una célula está viva y dos o tres de sus vecinas también lo están, entonces continúa viva en el estado siguiente.
b) Si una célula está muerta y tres de sus vecinas están vivas, enton- ces pasa a estar viva en el estado siguiente.
c) El resto de células pasan a estar muertas en el estado siguiente.
2. Asuma un tablero con 30 celdas (células).
3. El estado inicial del tablero estará almacenado en un fichero (llamado matriz) con 30 filas y 30 columnas en que cada celda será un uno o un cero. Por ejemplo,*/

public class Tablero {
    private static int DIMENSION = 30;
         public static int[][] estadoActual = new int[DIMENSION+2][DIMENSION+2]; //matriz que representa el estado actual.
         public static int[][] estadoSiguiente = new int[DIMENSION+2][DIMENSION+2]; // Matriz que representa el estado siguiente.
         
         // Lee el estado inicial de un fichero llamado ‘Matriz.txt‘. 

         public static void leerEstadoActual() throws IOException{
            
                    File fichero = new File("Matriz.txt");
                    Scanner leerFichero = new Scanner(fichero);
                    	
                    int i =0;
                    while (leerFichero.hasNextLine()) {
                        String fila = leerFichero.nextLine(); 	
                            
                         for (int r=0; r<fila.length()-1; r++) {
                            estadoActual[i][r]= Character.getNumericValue(fila.charAt(r));
                         }
                         i++;
                        System.out.println(fila);
                     }

                     leerFichero.close();

        }

         /** Genera un estado inicial aleatorio. Para cada celda
         genera un número aleatorio en el intervalo [0, 1). Si
         el número es menor que 0,5, entonces la celda está
         inicialmente viva. En caso contrario, está muerta. */
         
         public static void generarEstadoActualPorMontecarlo(){

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i+1][j+1] = (int) Math.round(Math.random());
            }
        }

        /* La secuencia de ceros y unos del fichero es guardada
         en ‘estadoActual‘ y, utilizando las reglas del juego
         de la vida, se insertan los ceros y unos
         correspondientes en ‘estadoSiguiente‘. */

        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                int vecinasVivas = estadoActual[i - 1][j - 1] + estadoActual[i - 1][j] + estadoActual[i - 1][j + 1]
                        + estadoActual[i][j - 1] + estadoActual[i][j + 1] + estadoActual[i + 1][j - 1] +
                        estadoActual[i + 1][j] + estadoActual[i + 1][j + 1];
                     if (estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                        estadoSiguiente[i][j] = 1;
                }    else if (estadoActual[i][j] == 0 && vecinasVivas == 3) {
                        estadoSiguiente[i][j] = 1;
                }    else {
                        estadoSiguiente[i][j] = 0;
                }
            }
        }
    }

         //Transita al estado siguiente según las reglas del juego de la vida (@throws IOException) 

         public static void transitarAlEstadoSiguiente() throws IOException{

         // La variable ‘estadoActual‘ pasa a tener el contenido
         // de ‘estadoSiguiente‘ y, éste útimo atributo pasar a
         // reflejar el siguiente estado.

         int nUnos=0;
            for (int r=1; r<(DIMENSION-2); r++) {
                for(int i=1; i<(DIMENSION-2) ; i++) {
                    //System.out.print(estadoSiguiente[r][i]);
                    if(estadoActual[r][i]==1) {	
                        nUnos = 0;
                                
                                if(estadoActual[r+1][i-1]==1) {
                                    nUnos++;
                                }
                                    if(estadoActual[r+1][i]==1) {
                                        nUnos++;
                                    }	
                                        if(estadoActual[r+1][i+1]==1) {
                                            nUnos++;
                                        }	
                                            if(estadoActual[r][i-1]==1) {
                                                nUnos++;
                                            }	
                                                if(estadoActual[r][i+1]==1) {
                                                    nUnos++;
                                                }	
                                                    if(estadoActual[r-1][i-1]==1) {
                                                        nUnos++;
                                                    }	
                                                        if(estadoActual[r-1][i]==1) {
                                                            nUnos++;
                                                        }	
                                                            if(estadoActual[r-1][i+1]==1) {
                                                                nUnos++;
                                                                
                                                            }if(nUnos==2 || nUnos==3) estadoSiguiente[r][i]=1;
                                                                
                                                            else estadoSiguiente[r][i]=0;
                                                            System.out.println();
                    }else{
                        nUnos = 0;
                                if(estadoActual[r+1][i-1]==1) {
                                    nUnos++;
                                }
                                    if(estadoActual[r+1][i]==1) {
                                        nUnos++;
                                    }	
                                        if(estadoActual[r+1][i+1]==1) {
                                            nUnos++;
                                        }	
                                            if(estadoActual[r][i-1]==1) {
                                                nUnos++;
                                            }	
                                                if(estadoActual[r][i+1]==1) {
                                                    nUnos++;
                                                }	
                                                    if(estadoActual[r-1][i-1]==1) {
                                                        nUnos++;
                                                    }	
                                                        if(estadoActual[r-1][i]==1) {
                                                            nUnos++;
                                                        }	
                                                            if(estadoActual[r-1][i+1]==1) {
                                                                nUnos++;
                                                                
                                                            }if(nUnos==3) estadoSiguiente[r][i]=1;
                                                                
                                                            else estadoSiguiente[r][i]=0;
    
                    }
                }
            }

         //System.out.println();
	     estadoSiguiente= estadoActual;
         
    }
          /* Devuelve, en modo texto, el estado actual.
         @return el estado actual. */
        
          @Override
         public String toString(){
             StringBuilder secuencia = new StringBuilder();
                for(int r = 1; r < DIMENSION -1; r++){
                    for(int i = 1; i < DIMENSION -1; i++){
                        if (estadoActual[r][i]== 0){
                            secuencia.append("");
                        } else{
                            secuencia.append("x");
                        }
                    }
                    secuencia.append("\n");
                }
             return secuencia.toString(); 
         }
}
