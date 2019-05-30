package Modele;

public class Enseignement {
    
    private int id;
    private Classe classe;
    private Discipline discipline;
    private Enseignant enseignant;
    
    public Enseignement(){
      this.id=0;
      this.classe=new Classe();
      this.discipline=new Discipline();
      this.enseignant= new Enseignant();
      
    }
    
    public Enseignement(int id,Classe c, Discipline d, Enseignant e){
      this.id=id;
      this.classe=c;
      this.discipline=d;
      this.enseignant= e;
      
    }
    
    public int getId(){
        return this.id;
    }
    
    public Discipline getDiscipline(){
        return this.discipline;
    }
    public Classe getClasse(){
        return this.classe;
    }
    public Enseignant getEnseignant(){
        return this.enseignant;
    }
    
}
