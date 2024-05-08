package coeur;

public class Position {

    private int x=0,y=0;


    /**
    * Constructeur de Position avec les coordonnées spécifiées.
    * @param x La coordonnée de x .
    * @param y La coordonnée de y .
    */
    public Position(int x,int y){
        this.x = x;
        this.y =y;
    }


    //getters
    public int getX(){return this.x;}
    public int getY(){return this.y;}

    //setters
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}

    //ajouter une position avec une instance de Position
    public void ajouter(Position p){
        this.x += p.getX();
        this.y += p.getY();
    }

    /**
     * Méthode pour ajouter des coordonnées à la position actuelle.
     * @param x La coordonnée x à ajouter.
     * @param y La coordonnée y à ajouter.
     */
    public void ajouter(int x, int y){
        this.x +=x;
        this.y += y;
    }


    /**
    * @param obj L'objet à comparer.
    * @return true si les positions sont égales, false sinon.
    */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Position)) return false;
        Position p = (Position) obj;

        return (p.getX() == this.x) && (p.getY() == this.y);
    }
    
}