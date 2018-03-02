
package pokemongame;
import java.io.*;
import java.util.*;


/**
 *
 * @author ASUS-PC
 */
public class CommandParser {
    private PokemonFarm pokemonFarm;
    private Bag bag;
	private Scanner commandScanner;
	private boolean isRunning;
        private RandomPoke randoms;
        private ArrayList<Pokemon> pokemonsBag;
	public CommandParser(PokemonFarm pokemonFarm){
		this.pokemonFarm = pokemonFarm;
                bag=new Bag();
		commandScanner = new Scanner(System.in);
		isRunning = false;
	}

	public void run(){
		isRunning = true;
		String command;

		System.out.println("Hello Pokemon Game");
		while(isRunning){
			System.out.print("\nWhat do you want? Type: ");
			command = commandScanner.next();
			// System.out.println("You type \'"+command+"\'");
			if(command.equals("quit")){
				isRunning = false;
				System.out.println("Good bye, See you next time.");
			}
			else if(command.equals("add"))
				this.addPokemon();
			else if(command.equals("list"))
				this.listPokemons();
			else if(command.equals("feed"))
				this.feedPokemons();
                        else if(command.equals("exercise"))
				this.exercisePokemons();
                        else if(command.equals("cath"))
				this.cathPokemons();        
                        
		}

	}

	private void addPokemon(){
		//commandScanner.nextLine();
		// input name weight length
                System.out.print("PokemonType: ");
		String pokemonType = commandScanner.next();
                System.out.print("Name: ");
		String name = commandScanner.next();
                System.out.print("Weight: ");
		float weight = commandScanner.nextFloat();
                System.out.print("StepLength: ");
		float stepLength = commandScanner.nextFloat();

		if(pokemonType.equals("Eevee")){
			Eevee eevee = new Eevee(name, weight, stepLength);
			pokemonFarm.addPokemon(eevee);
		}
                else if(pokemonType.equals("Charmander")){
			Charmander charmander = new Charmander(name, weight, stepLength);
			pokemonFarm.addPokemon(charmander);
		}
                else if(pokemonType.equals("Snorlax")){
			Snorlax snorlax = new Snorlax(name, weight, stepLength);
			pokemonFarm.addPokemon(snorlax);
                }     
                else {
                         System.out.print("No pokemonType in Farm!! ");   
                }
	}

	private void listPokemons(){
		System.out.println("==========================================");
		System.out.println("Pokemon List");
		System.out.println("==========================================");
		this.pokemonFarm.list();
		System.out.println("==========================================");
	}

	private void feedPokemons(){
		System.out.print("Which pokemon do you want to feed? ");
		String name = this.commandScanner.next();
		if(name.equals("all")){
			this.pokemonFarm.feed("all");
		}
                else{
                        this.pokemonFarm.feed(name);
                }
	}
        
        private void exercisePokemons(){
            System.out.print("Which pokemon do you want to exercise? ");
		String name = this.commandScanner.next();
		if(name.equals("all")){
			this.pokemonFarm.exercise("all");
		}
                else{
                        this.pokemonFarm.exercise(name);
                }
        }
    
        private void cathPokemons(){
          int i=1;
            while(i==1){
                randoms = new RandomPoke();

                System.out.print("What do you want find or quit ?: ");
                String ans= this.commandScanner.next();
                if(ans.equals("find")){
                    this.randoms.find();
                }
                else if(ans.equals("quit")){
                    
                    int length =(this.bag).getLength();
                   
           
                    for(i=0;i<length;i++){
                        
                        pokemonFarm.addPokemon(this.bag.getPoke(i)); 
                    }
               
                    i=0;
                }
            }
            
        }
            
        }

    
