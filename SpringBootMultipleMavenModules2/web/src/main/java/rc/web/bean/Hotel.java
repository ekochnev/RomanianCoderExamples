package rc.web.bean;

public class Hotel {

    private long id;
    private String name;
    private int classification;
    private boolean isOpen;

    protected Hotel(){}

    public Hotel(String name, int classification, boolean isOpen){
        this.name = name;
        this.classification = classification;
        this.isOpen = isOpen;
    }

    public Hotel(long id, String name, int classification, boolean isOpen){
        this.id = id;
        this.name = name;
        this.classification = classification;
        this.isOpen = isOpen;
    }

    public String getName() {
        return name;
    }

    public int getClassification() {
        return classification;
    }

    public long getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
