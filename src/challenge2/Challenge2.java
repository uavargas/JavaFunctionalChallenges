package challenge2;

/**
 * Dada una lista de números enteros del 1 al 20, calcular la suma total de los
 * números pares después de duplicar cada uno de ellos.
 */

public class Challenge2 {
    public static void main(String[] args) {

        System.out.println("----------Usando programacion estructurada-------------");

        int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int suma = 0;

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                suma += numero * 2;
            }
        }
        System.out.println("Suma total: " + suma);

        System.out.println("----------Usando Programacion Funcional--------------");

        int sumaFuncional = java.util.Arrays.stream(numeros)// Convertimos el array a un stream
                .filter(n -> n % 2 == 0)// Filtramos los numeros pares del array
                .map(n -> n * 2)// multiplicamos cada numero par del array por 2
                .sum(); // funcion que suma todos los elementos del stream y devuelve un int

        System.out.println("Suma total: " + sumaFuncional);

    }

}
