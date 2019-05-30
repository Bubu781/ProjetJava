package Modele;

public class Evaluation {
    
    private int id;
    private int note;
    private String appreciation;
    private DetailBulletin detail;
    
    public Evaluation(){
        this.id=0;
        this.note=0;
        this.appreciation="";
        this.detail=null;
    }
    public Evaluation(int id, int note, String appreciation, DetailBulletin d){
        this.id=id;
        this.note=note;
        this.appreciation=appreciation;
        this.detail=d;
    }
    public int getNote(){
        return this.note;
    }
    public String getAppreciation(){
        return this.appreciation;
    }
    public int getId(){
        return this.id;
    }
    
    public DetailBulletin getDetailBulletin(){
        return this.detail;
    }
}
