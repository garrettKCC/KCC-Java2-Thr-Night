package edu.kcc;

import edu.kcc.ui.UIUtility;
import edu.kcc.animal.Animal;
import edu.kcc.taskhandler.FindAnimal;
import java.net.Socket;

/**
 *
 * @author 
 * @author 
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UIUtility.showMessage("Program starting...");
        
        String menuTitle = "Main Menu";
        String[] menuOptions = {
            "1) Find an Animal",
            "2) Show Lookup History",
            "3) Exit"
        };
        String prompt = "Your choice:";
        
        String errorMessage = "Invalid option.  Please try again.";
        String userChoice;
        // AnimalDAO dao = AnimalDAO.getAnimalDAO();
        
        boolean working = true;
        while(working) {
            userChoice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions);
            //returns userChoice as a String
            switch(userChoice) {
                case "1":
                    // Find an Animal
                    //prompt user for name of an animal
                    new FindAnimal().handleTask();
                    break;
                case "2":
                    // Show Lookup History
                    System.out.println("Here is your Lookup History");
                    break;
                case "3":
                    working = false;
                    break;
                default:
                    UIUtility.showErrorMessage(errorMessage, true);  
            }
        }
        UIUtility.showMessage("\nProgram complete.");
    }
    
}
