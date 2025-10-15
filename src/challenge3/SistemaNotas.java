package challenge3;

import java.util.*;
import java.util.stream.Collectors;

class Estudiante {
    private String nombre;
    private double nota;
    
    // Constructor
    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
    // Getters
    public String getNombre() { return nombre; }
    public double getNota() { return nota; }
    
    // ToString
    @Override
    public String toString() {
        return nombre + ": " + nota;
    }
}

public class SistemaNotas {
    public static void main(String[] args) {
        
        // Lista de estudiantes con sus notas
        List<Estudiante> estudiantes = Arrays.asList(
            new Estudiante("Ana", 8.5),
            new Estudiante("Luis", 6.2),
            new Estudiante("Marta", 9.1),
            new Estudiante("Carlos", 5.8),
            new Estudiante("Elena", 7.9),
            new Estudiante("Pedro", 4.5)
        );
        
        System.out.println("=== TODOS LOS ESTUDIANTES ===");
        estudiantes.forEach(System.out::println);
        
        // === FILTRAR APROBADOS (nota >= 6) ===
        
        //  Paradigma Estructurado
        System.out.println("\n=== ESTRUCTURADO: Aprobados ===");
        List<Estudiante> aprobadosEstructurado = new ArrayList<>();
        for (Estudiante est : estudiantes) {
            if (est.getNota() >= 6.0) {
                aprobadosEstructurado.add(est);
            }
        }
        aprobadosEstructurado.forEach(System.out::println);
        
        // Funcional
        System.out.println("\n=== FUNCIONAL: Aprobados ===");
        List<Estudiante> aprobadosFuncional = estudiantes.stream()
            .filter(e -> e.getNota() >= 6.0)
            .collect(Collectors.toList());
        aprobadosFuncional.forEach(System.out::println);
        
        // === CALCULAR PROMEDIO GENERAL ===
        
        // Estructurado
        System.out.println("\n=== ESTRUCTURADO: Promedio ===");
        double suma = 0;
        for (Estudiante est : estudiantes) {
            suma += est.getNota();
        }
        double promedioEstructurado = suma / estudiantes.size();
        System.out.println("Promedio: " + promedioEstructurado);
        
        // Funcional
        System.out.println("\n=== FUNCIONAL: Promedio ===");
        double promedioFuncional = estudiantes.stream()
            .mapToDouble(Estudiante::getNota)
            .average()
            .orElse(0.0);
        System.out.println("Promedio: " + promedioFuncional);
        
        // === MEJOR ESTUDIANTE ===
        
        // Estructurado
        System.out.println("\n=== ESTRUCTURADO: Mejor estudiante ===");
        Estudiante mejorEstructurado = estudiantes.get(0);
        for (Estudiante est : estudiantes) {
            if (est.getNota() > mejorEstructurado.getNota()) {
                mejorEstructurado = est;
            }
        }
        System.out.println("Mejor: " + mejorEstructurado);
        
        // Funcional
        System.out.println("\n=== FUNCIONAL: Mejor estudiante ===");
        estudiantes.stream()
            .max(Comparator.comparingDouble(Estudiante::getNota))
            .ifPresent(mejor -> System.out.println("Mejor: " + mejor));
            
        // === NOMBRES EN MAYÚSCULAS DE APROBADOS ===
        
        // Estructurado
        System.out.println("\n=== ESTRUCTURADO: Nombres aprobados en mayúsculas ===");
        List<String> nombresAprobados = new ArrayList<>();
        for (Estudiante est : estudiantes) {
            if (est.getNota() >= 6.0) {
                nombresAprobados.add(est.getNombre().toUpperCase());
            }
        }
        System.out.println(nombresAprobados);
        
        // Funcional
        System.out.println("\n=== FUNCIONAL: Nombres aprobados en mayúsculas ===");
        List<String> nombresFuncional = estudiantes.stream()
            .filter(e -> e.getNota() >= 6.0)
            .map(Estudiante::getNombre)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(nombresFuncional);
    }
}