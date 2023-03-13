import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Gestionefile {
    final String nomefile = "libreria.txt";
    public ArrayList< String>righe;

    public void appendtofile ( String string ) {
        try {
            FileWriter writer= new FileWriter(nomefile, true);
            writer.write(string+ " \n");
            writer.close();


        }catch (IOException e ){
            System.out.println("file non trovato ");

        }


    }

    public void redfile(){

        righe=new ArrayList<>();

        try {
            FileReader reader= new FileReader(nomefile);
            BufferedReader br = new BufferedReader(reader);
            String riga;
            while ((riga = br.readLine()) != null) {
                righe.add(riga);// asegnoa righa la succesiva read line  e faccio il controllo che non sia vuota se non lo e l'aggiungo all'arrey list
            }
        } catch (IOException e){



            System.out.println("file non trovato ");
        }
    }

}
