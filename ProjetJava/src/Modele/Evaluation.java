package Modele;

public class Evaluation {
    
    private int id;
    private int note;
    private String appreciation;
    
    public Evaluation()
    {
        id=0;
        note=0;
        appreciation="";
    }
    public Evaluation(int id, int note, String appreciation)
    {
        this.id=id;
        this.note=note;
        this.appreciation=appreciation;
    }
    public int getNote(){
        return note;
    }
    public String getAppreciation(){
        return appreciation;
    }
    public int getId(){
        return id;
    }
    
}
