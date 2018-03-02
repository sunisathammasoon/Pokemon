
package pokemongame;


import java.util.Random; 
import java.util.Scanner;


public class RandomPoke {
    private Scanner sc = new Scanner(System.in);
    private Bag  bag;
    Random rand = new Random(); 
    
    public void find(){
        
        String name[] = {"weedle","wurmple","caterpie"};
        String type = name[rand.nextInt(3)];
        System.out.println("Pokemon is "+ type);
        
        catchMon(type);
        
        
    }
    
    private void catchMon(String type){
        
        int mood = rand.nextInt(10)+1;
        int ball = selectBall();
        int result = 0;
        switch (ball) {
            case 1:
                result = mood*8;
                break;
            case 2:
                result = mood*9;
                break;
            case 3: 
                result = mood*10;
                break;
            default:
                break;
        }
        
        if(result >= 50){
            System.out.println("Success");
             bag = new Bag();
             addPokemon(type);
             
        }else{
            System.out.println("Fail");
        }
        
        
    }
    
    private int selectBall(){
        System.out.println("\nSelect Ball:");
        System.out.println("Type 1 is Pokeball");
        System.out.println("Type 2 is Greatball");
        System.out.println("Type 3 is Ultraball");
        int ball = sc.nextInt();
        return ball;
    }
    
    	private void addPokemon(String type){
                //sc.nextLine();
                System.out.print("name :");
		String name = sc.next();
                System.out.print("weight :");
		float weight = sc.nextFloat();
                System.out.print("step length :");
		float stepLength = sc.nextFloat();
                int level=(int)Math.random()*10;
                

            switch(type){
                case "charmander":
                    Charmander charmander = new Charmander(name, weight, stepLength);
                    bag.addPokemon(charmander);
                    break;
                case "evvee":
                    Eevee evvee = new Eevee(name, weight, stepLength);
                    bag.addPokemon(evvee);
                    break;
                case "snorlax": 
                    Snorlax snorlax = new Snorlax(name, weight, stepLength);
                    bag.addPokemon(snorlax);
                    break;
                default:
                    break;
            }

	}
}
