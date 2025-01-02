public class abstraction {
    public static void main(String[] args) {
        //----------abstraction
        // Horse h= new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        // Chicken c=new Chicken();
        // c.eat();
        // c.walk();
        // System.out.println(c.color);
        // Queen q= new Queen();

        // q.moves();
        // King k= new King();
        // k.moves();;
        Bear b= new Bear();
        b.color="brown";
        b.legs= 4;
        System.out.println(b.color);
        System.out.println(b.legs);
        b.eatsgrass();
        System.out.println(b.type);
        b.eatsmeat();
        System.out.println(b.typeis);
    



    }
}

// abstract class Animal{
//     String color;
//     Animal(){
//         color="brown";
//     }
//     void eat(){
//         System.out.println("animal eats");
//     }
//     abstract void walk();
// }
// class Horse extends Animal{
//     void changeColor(){
//         color= "dark brown";
//     }
//     void walk(){
//         System.out.println("horse walks on 4 legs");
//     }
// }

// class Chicken extends Animal{

//     void changeColor(){
//         color= "yellow";
//     }
//     void walk(){
//         System.out.println("chicken walks on 2 legs");
//     }
// }

//---interfaces
// interface ChessPlayer{
//     void moves();
// }

// class Queen implements ChessPlayer{
//    public void moves(){
//         System.out.println("up, down, left, right, diaglonal in all directions");
//     }
// }

// class Rook implements ChessPlayer{
//     public void moves(){
//          System.out.println("up, down, left, right");
//      }
//  }

//  class King implements ChessPlayer{
//     public void moves(){
//          System.out.println("up, down, left, right, diagonal by One step");
//      }
//  }

interface Herbivore{
    void eatsgrass();
    String type="herbivore";
}
interface Carnivore{
    void eatsmeat();
    String typeis="Carnivore";
}
class Bear implements Herbivore,Carnivore{
    int legs;
    String color;
    public void eatsgrass(){
        System.out.println("eats grasss");
    }
    public void eatsmeat(){
        System.out.println("eats meats");
    }
}