/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author andrea
 */
public class ExternalProgramTrigger implements Trigger{
    private String program;
    private Boolean active=true;//booleano per far attivare una sola volta il trigger in quel giorno dell'anno

    public ExternalProgramTrigger(String program) {
        this.program = program;
    }
    

    @Override
    public boolean isVerified() {
        
        if(this.active){
            active=false;
            boolean confronto=false;
            String[] args = program.split("//");
            String interprete=args[1];
            String path=args[0];
            String[] input=args[2].split(" ");
            String output=args[3];
            String outputProgram = null;
            
            List<String> argomenti=new ArrayList<>();
            argomenti.add(interprete);
            argomenti.add(path);
            for(int i=0;i<input.length;i++){
                argomenti.add(input[i]);
            }
            ProcessBuilder processBuilder = new ProcessBuilder(argomenti);
            
            try {
                Process process=processBuilder.start();
                
                // Gestisci lo standard output del processo Python
                BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String outputLine;
                while ((outputLine = outputReader.readLine()) != null) {
                    System.out.println("Output del programma esterno: " + outputLine);
                    outputProgram=outputLine.toString();
                }
                
                if(outputProgram.equals(output)){
                    confronto = true;
                }
                // Attendere che il processo termini
                int exitCode = process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                

                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("Il programma esterno è estato eseguito e ha restituito il codice di uscita: " + exitCode);
                
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        
            if(confronto)
                return true;
            else
                return false;
        }
        return false;
            
    }

    @Override
    public StringProperty triggerAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("External Program Trigger: "+this.program);
        return p;
    }
    
}
