package Modele;

public class AnneeScolaire {
      private int id;
    private int note;
    private String appreciation;
    
    public AnneeScolaire()
    {
        id=0;
        
    }
    public AnneeScolaire(int id)
    {
        this.id=id;
       
    }
    
    public int getId(){
        return id;
    }
    
}
