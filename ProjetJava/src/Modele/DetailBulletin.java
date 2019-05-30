package Modele;

public class DetailBulletin {
    
    private int id;
    private String appreciation;
    private Enseignant enseignant;
    private Bulletin bulletin;

    
    public DetailBulletin(){
        this.id=0;
        this.appreciation="";
        this.enseignant=new Enseignant();
        this.bulletin=new Bulletin();
        
    }
    public DetailBulletin(int id, String appreciation,Enseignant e, Bulletin b){
        this.id=id;
        this.appreciation=appreciation;
        this.enseignant=e;
        this.bulletin=b;
    }
   
    public String getAppreciation(){
        return this.appreciation;
    }
    public int getId(){
        return this.id;
    }
    
    public Enseignant getEnseignant(){
        return this.enseignant;
    }
    
    public Bulletin getBulletin(){
        return this.bulletin;
    }
}
