package pr2.org.aplicacion;


import java.util.concurrent.TimeUnit;

import pr2.org.dominio.Tablero;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.InterruptedException;

public class Principal {

    public static void main(String[] args) throws IOException{
        try {
            Tablero tablero = new Tablero();
            System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
            Tablero.leerEstadoActual();
            System.out.println(tablero);
        for(int i = 0; i <= 5; i++){
            TimeUnit.SECONDS.sleep(1);
            Tablero.transitarAlEstadoSiguiente();
            System.out.println(tablero);
        }
            System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
            Tablero.generarEstadoActualPorMontecarlo();
            System.out.println(tablero);

        for(int i = 0; i <= 15; i++){
        TimeUnit.SECONDS.sleep(1);
        Tablero.transitarAlEstadoSiguiente();
        System.out.println(tablero);
        }
    }   catch(InterruptedException e){
        System.out.println(e);
        }
    }
}