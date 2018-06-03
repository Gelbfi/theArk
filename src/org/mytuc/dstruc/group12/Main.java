package org.mytuc.dstruc.group12;

public class Main {

    public static void main(String[] args) {
        // create Animals
    	
    	Animal Axel = new Animal("horse", "Axel", "m", 150, 100);
    	Animal Mila = new Animal("mouse", "Mila", "w", 20, 25);
    	Animal Marta = new Animal("tiger", "Marta", "w", 200, 60);
    	Animal Lila = new Animal("horse", "Lila", "w", 150, 100);
    	Animal Matra = new Animal("horse", "Matra", "w", 150, 100);
    	Animal Paul = new Animal("spider", "Paul", "m", 15, 5);
    	Animal Elias = new Animal("rabbit", "Elias", "m", 50, 60);
    	Animal Berta = new Animal("cow", "Berta", "w", 200, 200);
    	Animal Master = new Animal("zebra", "Master", "m", 150, 80);
    	Animal Emma = new Animal("hippo", "Emma", "w", 250, 250);
    	Animal Mia = new Animal("crocodile", "Mia", "w", 150, 210);
    	Animal Leonie = new Animal("mouse", "Leonie", "w", 20, 25);
    	Animal Spohie = new Animal("spider", "Spohie", "w", 15, 5);
    	Animal Brumbo = new Animal("cow", "Brumbo", "m", 200, 200);
    	Animal Lina = new Animal("rabbit", "Lina", "w", 50, 60);
    	Animal Jonas = new Animal("hippo", "Jonas", "m", 250, 250);
    	Animal Luca = new Animal("crocodile", "Luca", "m", 150, 210);
    	
    	
    	//create a ship named Noah 
        
        Arche ship =new Arche();
		ship.setName("Noah");
        
        // Animals on boarding (manually)
        
        ship.AddAnimals(Axel);
        ship.AddAnimals(Mila);
        ship.AddAnimals(Marta);
        ship.AddAnimals(Elias);
        ship.AddAnimals(Berta);
        ship.AddAnimals(Luca);
        
        //Sorting 
        ship.show_list();     //print the list before Sorting 
		
		System.out.println("---------");
		
		ship.insertion_Sort();      // Sorting base on feedQuantity
		
		ship.show_list();    // after Sorting 
     
        
        //
        
        
            
        
        
    }
}
