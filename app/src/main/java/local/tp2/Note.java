package local.tp2;

public class Note {
    private String titre;
    private String date;
    private String contenu;
    private String chemin;

    public Note(String titre, String date, String contenu, String chemin) {
        this.titre = titre;
        this.date = date;
        this.contenu = contenu;
        this.chemin = chemin;
    }

    public Note(String chemin) {
        this.chemin = chemin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
}
