/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author andrea
 */
public class ExternalProgramAction implements Action, Serializable{
    private String programPath;

    public ExternalProgramAction(String programPath) {
        this.programPath = programPath;
    }
    

    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inserisci il comando per eseguire il programma: ");
        String interprete = scanner.nextLine();
        
        System.out.println("Inserisci il numero di argomenti da voler inserire: ");
        while(!scanner.hasNextInt()){
            scanner.nextLine();
            System.out.println("Errore: non hai inserito un numero!");
        }
        int numarg=scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Inserisci gli argomenti: ");

        
        
        String[] argomenti = new String[numarg];
        for(int i = 0; i < numarg; i++){
            System.out.println("Argomento " + (i+1) + ":");
            argomenti[i]=scanner.nextLine();
        }
//        scanner.close();
        
        List<String> comandoEsterno = new ArrayList<>();
        comandoEsterno.add(interprete);
        comandoEsterno.add(programPath);
        comandoEsterno.addAll(Arrays.asList(argomenti));
        
        // Crea un oggetto ProcessBuilder per avviare il programma esterno con gli argomenti
        ProcessBuilder processoBuilder = new ProcessBuilder(comandoEsterno);
        
        try {
            // Avvia il processo
            Process processo = processoBuilder.start();
            
            // Gestisci lo standard output del processo Python
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String outputLine;
            while ((outputLine = outputReader.readLine()) != null) {
                System.out.println("Output del programma esterno: " + outputLine);
            }
            
            // Attendere che il processo termini
            int exitCode = processo.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getErrorStream()));
            
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("Il programma esterno è estato eseguito e ha restituito il codice di uscita: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.out.println("Si è verificato un errore durante l'esecuzione del programma esterno: " + e.getMessage());
        }
    }

    @Override
    public StringProperty actionAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("External Program Action: "+this.programPath);
        return p;
    }
    
}
