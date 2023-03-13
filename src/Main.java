import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keabord=new Scanner(System.in);

        ArrayList<Articolo> libreria= new ArrayList<>();
        libreria = leggifile();

        System.out.println("\n MENU:");
        System.out.println("1 visualizza articoli");
        System.out.println("2 visulizza libri ");
        System.out.println("3 visulizza film ");
        System.out.println("4 aggiungi libro ");
        System.out.println("5 aggiungi film ");
        System.out.println("0 esci");


        int scelta= keabord.nextInt();
        keabord.nextLine();

        while (scelta!=0){
            switch (scelta){
                case 1:
                    for ( Articolo articolo: libreria ){
                        System.out.println(articolo.toString());

                    }
                    break;
                case 2:
                    for ( Articolo articolo: libreria ){
                        if ( articolo instanceof Libro ) {
                            System.out.println(articolo.toString());
                        }


                    }
                    break;
                case 3: for ( Articolo articolo: libreria ) {
                    if (articolo instanceof Film){
                        System.out.println(articolo.toString());
                }

                }
                    break;
                case 4:
                    System.out.println("id");
                  int id= keabord.nextInt();
                    keabord.nextLine();
                    System.out.println("titolo");
                    String titolo= keabord.nextLine();
                    keabord.nextLine();
                    System.out.println("autore");
                    String autore= keabord.nextLine();
                    keabord.nextLine();

                    libreria.add(new Libro(id,titolo,autore));


                    break;
                case 5:
                    System.out.println("id");
                    int id_= keabord.nextInt();
                    keabord.nextLine();
                    System.out.println("titolo");
                    String titolo_= keabord.nextLine();
                    keabord.nextLine();
                    System.out.println("regista");
                    String regista= keabord.nextLine();
                    keabord.nextLine();

                    libreria.add(new Film(id_,titolo_,regista));

                    break;
                case 0:
                    break;

            }

            System.out.println("\n MENU:");
            System.out.println("1 visualizza articoli");
            System.out.println("2 visulizza libri ");
            System.out.println("3 visulizza film ");
            System.out.println("4 aggiungi libro ");
            System.out.println("5 aggiungi film ");
            System.out.println("0 esci");
            scelta= keabord.nextInt();


        }

        salvafile(libreria);



    }

    public static void salvafile( ArrayList<Articolo> libreria){
        Gestionefile gestostore =new Gestionefile();
        for(Articolo articolo: libreria){

            gestostore.appendtofile(articolo.toFile());




        }

    }

    public  static ArrayList leggifile(){
        Gestionefile gestostore =new Gestionefile();
        ArrayList<Articolo> libreriadafile =new ArrayList<>();
        ArrayList<String>righe;
        gestostore.redfile();
        righe=gestostore.righe;

        for (String stringa: righe) {
            String[] stringhe= stringa.split("#",4);
            String tipo = stringhe[0];
            int id=Integer.parseInt(stringhe[1]);
            String titolo=stringhe[2];
            String autoreregista =stringhe[3];

            // ad ogni riga letta la divido in 4 stringhe divise dal separatore #  e le salvo in un arrey di stringhe

            if ( tipo.equals("libro")){
                libreriadafile.add(new Libro(id,titolo,autoreregista));
            } else if (tipo.equals("film")) {
                libreriadafile.add(new Film(id,titolo,autoreregista));
            }
        }

        return libreriadafile;

    }

}