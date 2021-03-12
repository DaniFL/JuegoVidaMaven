package JuegoVida.src.dominio;

import java.util.Scanner;

/*Las reglas son las habituales:
a) Si una célula está viva y dos o tres de sus vecinas también lo están, entonces continúa viva en el estado siguiente.
b) Si una célula está muerta y tres de sus vecinas están vivas, enton- ces pasa a estar viva en el estado siguiente.
c) El resto de células pasan a estar muertas en el estado siguiente.
2. Asuma un tablero con 30 celdas (células).
3. El estado inicial del tablero estará almacenado en un fichero (llamado matriz) con 30 filas y 30 columnas en que cada celda será un uno o un cero. Por ejemplo,*/

public class Tablero {
    private static int DIMENSION = 30;
         private int[][] estadoActual = new int[DIMENSION][DIMENSION]; //matriz que representa el estado actual.
         private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION]; // Matriz que representa el estado siguiente.
         
         public void instaurarMatriz(){
             File fichero = new File("Matriz.txt"); 
             Scanner martinEsUnaZorra = new Scanner (fichero); 

             //Recorer fichero de texto de arriba abajo 
            int i=0;
             while (martinEsUnaZorra.hasNextLine()){
                 String fila = martinEsUnaZorra.nextLine();
                 for (int j = 0; j < fila.length(); j++){
                     int k = fila.charAt(j);
                     estadoActual[i][j] = k;
                 }
                 i++;
                 System.out.println(fila);
             }

         }
         public void leerEstadoActual(){
         }
         // La secuencia de ceros y unos del fichero es guardada
         // en ‘estadoActual‘ y, utilizando las reglas del juego
         // de la vida, se insertan los ceros y unos
         // correspondientes en ‘estadoSiguiente‘.
         /********************************************************
          * Genera un estado inicial aleatorio. Para cada celda
          * genera un número aleatorio en el intervalo [0, 1). Si
          * el número es menor que 0,5, entonces la celda está
          * inicialmente viva. En caso contrario, está muerta.
          *******************************************************/
          public void generarEstadoActualPorMontecarlo(){}
          // La secuencia de ceros y unos generada es guardada
          // en ‘estadoActual‘ y, utilizando las reglas del juego
          // de la vida, se insertan los ceros y unos
          // correspondientes en ‘estadoSiguiente‘.
         /********************************************************
          * Transita al estado siguiente según las reglas del
          * juego de la vida.
          ********************************************************/
         public void transitarAlEstadoSiguiente(){}
         // La variable ‘estadoActual‘ pasa a tener el contenido
         // de ‘estadoSiguiente‘ y, éste útimo atributo pasar a
         // reflejar el siguiente estado.
         /*******************************************************
          * Devuelve, en modo texto, el estado actual.
          * @return el estado actual.
          *******************************************************/
         

          @Override
         public String toString(){
             return ""; // Esta línea hay que modificarla.
         }
}
