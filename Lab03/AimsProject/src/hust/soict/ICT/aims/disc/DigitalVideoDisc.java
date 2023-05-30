package hust.soict.ICT.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    public String getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public int getId() {
        return id;
    }

    public DigitalVideoDisc(String title, String category, String director) {
        this.title = title;
        this.category = category;
        this.director = director;
        updateDiscId();
    }
    public DigitalVideoDisc(int length) {
        this.length = length;
        updateDiscId();
    }
    public DigitalVideoDisc(float cost) {
        this.cost = cost;
        updateDiscId();
    }
    public DigitalVideoDisc(String title) {
        this.title = title;
        updateDiscId();
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        updateDiscId();
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        updateDiscId();
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        updateDiscId();
    }
    public void updateDiscId() {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        System.out.println("Id: " + nbDigitalVideoDiscs);
    }
    public boolean isMatchTitle(String title) {
        if(this.getTitle().contains(title)) {
            return true;
        } else return false;
    }
    public boolean isMatchId(int id) {
        if(this.getId() == id) {
            return true;
        }
        else return false;
    }

    public String toString() {
        return this.getId() + ". "
                + this.getTitle() + " - "
                + this.getCategory() + " - "
                + this.getDirector() + " - "
                + this.getLength() + ": "
                + this.getCost() + "$\n" ;
    }

}

