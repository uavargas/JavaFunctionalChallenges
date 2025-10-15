package challenge1;

import java.util.List;

/*
Escribe un programa en Java que, dada una lista de palabras, 
obtenga una nueva lista que contenga únicamente aquellas palabras cuya longitud sea mayor a 5 caracteres, y las convierta a mayúsculas.
Utilizar streams para realizar esta operación de manera eficiente.
*/
public class Challenge1 {

    public static void main(String[] args) {

        System.out.println("----------Usando programacion estructurada-------------");

        String[] palabras = { "Alonso", "Vargas", "java", "programacion", "stream", "challenge", "Hola", "mundo" };
        String[] resultado = new String[palabras.length];

        int i = 0;
        for (String palabra : palabras) {
            if (palabra.length() > 5) {
                resultado[i] = palabra.toUpperCase();
                i++;
            }
        }

        for (String palabra : resultado) {
            if (palabra != null) {
                System.out.println(palabra);
            }
        }
        System.out.println("----------Usando Programacion Funcional--------------");

        List<String> resultadoFuncional = List.of(palabras).stream()
                .filter(p -> p.length() > 5)
                .map(String::toUpperCase)
                .toList();

        System.out.println(resultadoFuncional);

    }

}
