package pr2.org.dominio;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Las reglas son las habituales:
a) Si una célula está viva y dos o tres de sus vecinas también lo están, entonces continúa viva en el estado siguiente.
b) Si una célula está muerta y tres de sus vecinas están vivas, enton- ces pasa a estar viva en el estado siguiente.
c) El resto de células pasan a estar muertas en el estado siguiente.
2. Asuma un tablero con 30 celdas (células).
3. El estado inicial del tablero estará almacenado en un fichero (llamado matriz) con 30 filas y 30 columnas en que cada celda será un uno o un cero. Por ejemplo,*/

public class Tablero {
    private static int DIMENSION = 32;
         public static int[][] estadoActual = new int[DIMENSION][DIMENSION]; //matriz que representa el estado actual.
         public static int[][] estadoSiguiente = new int[DIMENSION][DIMENSION]; // Matriz que representa el estado siguiente.
         private Scanner leerfichero;
         
         public void instaurarMatriz() throws FileNotFoundException{
             File fichero = new File("Matriz.txt"); 
             leerfichero = new Scanner (fichero); 

             //Lee el estado inicial del fichero (Matriz.txt) y lo recorer fichero de texto de arriba abajo 
            int i=0;
             while (leerfichero.hasNextLine()){
                 String fila = leerfichero.nextLine();
                 for (int j = 0; j < fila.length(); j++){
                     int k = fila.charAt(j);
                     estadoActual[i][j] = k;
                 }
                 i++;
                 System.out.println(fila);
            }
        }
         public static void leerEstadoActual() throws IOException{
            
                    File fichero = new File("Matriz.txt");
                    Scanner s = new Scanner(fichero);
                    	
                    int i =0;
                    while (s.hasNextLine()) {
                        String fila = s.nextLine(); 	
                            
                         for (int r=0; r<fila.length()-1; r++) {
                            estadoActual[i][r]= Character.getNumericValue(fila.charAt(r));
                         }
                         i++;
                        System.out.println(fila);
                     }
                    
                    s.close();

        }
        
        
        
         // La secuencia de ceros y unos del fichero es guardada
         // en ‘estadoActual‘ y, utilizando las reglas del juego
         // de la vida, se insertan los ceros y unos
         // correspondientes en ‘estadoSiguiente‘.
         /********************
          * Genera un estado inicial aleatorio. Para cada celda
          * genera un número aleatorio en el intervalo [0, 1). Si
          * el número es menor que 0,5, entonces la celda está
          * inicialmente viva. En caso contrario, está muerta.
          *******************/
          public static void generarEstadoActualPorMontecarlo(){}
          // La secuencia de ceros y unos generada es guardada
          // en ‘estadoActual‘ y, utilizando las reglas del juego
          // de la vida, se insertan los ceros y unos
          // correspondientes en ‘estadoSiguiente‘.
         /********************
          * Transita al estado siguiente según las reglas del
          * juego de la vida.
         * @throws IOException
          ********************/
         public static void transitarAlEstadoSiguiente() throws IOException{
            int nUnos=0;
            
            for (int r=1; r<(DIMENSION-2); r++) {
                for(int i=1; i<(DIMENSION-2) ; i++) {
                    System.out.print(estadoSiguiente[r][i]);
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

            System.out.println();
			
            estadoSiguiente= estadoActual;
         
    }
         // La variable ‘estadoActual‘ pasa a tener el contenido
         // de ‘estadoSiguiente‘ y, éste útimo atributo pasar a
         // reflejar el siguiente estado.
         /*******************
          * Devuelve, en modo texto, el estado actual.
          * @return el estado actual.
          *******************/
         

          @Override
         public String toString(){
             return ""; // Esta línea hay que modificarla.
         }
}
