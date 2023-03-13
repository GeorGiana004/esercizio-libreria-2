public class Film extends Articolo {
    private String regista;


    public Film(int id, String titolo, String regista) {
        super(id, titolo);
        this.regista=regista;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    @Override
    public String toString() {
        return   getId()+ " "+ getTitolo() + " "+ regista;
    }

    public String toFile(){
        return  "film#"+ getId()+ "#"+ getTitolo() + "#"+ regista; // distinguo il metodo to string ( che uso per presentare un isatanza  ) dal metodo tofile
                                                                  // che formatto usando un separatore univoco che mi servira per leggere la stringa da file e distringuere le sue varie parti

    }
}
