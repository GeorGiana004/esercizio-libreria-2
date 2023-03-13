public class Libro extends Articolo {
    private String autore ;

    public Libro(int id, String titolo,String autore ) {
        super ( id, titolo);
        this.autore = autore;

    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return  getId()+ " "+ getTitolo() + " "+ autore;
    }

    public String toFile(){
        return  "libro#"+ getId()+ "#"+ getTitolo() + "#"+ autore;

    }

}
