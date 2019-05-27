package Modele;

public class DetailBulletin {
    
    private int id;
    private String appreciation;
    
    public DetailBulletin()
    {
        id=0;
        appreciation="";
    }
    public DetailBulletin(int id, String appreciation)
    {
        this.id=id;
        this.appreciation=appreciation;
    }
   
    public String getAppreciation(){
        return appreciation;
    }
    public int getId(){
        return id;
    }
    
}
