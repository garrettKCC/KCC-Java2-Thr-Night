package edu.kcc.taskhandler;

import edu.kcc.animal.Animal;
import edu.kcc.ui.UIUtility;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PSUser
 */
public class FindAnimal {

    private static final int PORT = 5555;
    private static final String HOST_NAME = "localhost";

    public void handleTask() {
        UIUtility.showSectionTitle("Find an Animal");

        String prompt = "Enter an animal's name:";
        String animalName = UIUtility.getUserString(prompt);

        Animal animal;

        try {
            animal = getAnimalFromServer(animalName);
            if (null == animal) {
                UIUtility.showMessage("There isn't an animal by the name of "
                        + animalName);
            } else {
                UIUtility.showMessage("Here is your animal " + animal);
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            System.out.println("Client: IOException");
        }

        UIUtility.showMessage("\nFind an Animal is complete.");
        UIUtility.pressEnterToContinue();
    } //handleTask

    
    public Animal getAnimalFromServer(String animalName)
            throws IOException {

        Socket socket = new Socket(HOST_NAME, PORT);

        DataInputStream inputStream
                = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream
                = new DataOutputStream(socket.getOutputStream());

        //send user input to server
        outputStream.writeUTF(animalName);
        outputStream.flush();

        //receive result from server
        //need 10 methods
        String id = inputStream.readUTF();
        String name = inputStream.readUTF();
        String species = inputStream.readUTF();
        String gender = inputStream.readUTF();
        int age = inputStream.readInt();
        boolean fixed = inputStream.readBoolean();
        int legs = inputStream.readInt();
        double doubleWeight = inputStream.readDouble();
        String stringDateAdded = inputStream.readUTF();
        String stringLastFeedingTime = inputStream.readUTF();

        inputStream.close();
        outputStream.close();

        //convert weight, dateAdded, lastFeedingTime
        BigDecimal weight = new BigDecimal(doubleWeight);
        LocalDate dateAdded = null;
        LocalDateTime lastFeedingTime = null;
        try {
            dateAdded = LocalDate.parse(stringDateAdded);
            lastFeedingTime = LocalDateTime.parse(stringLastFeedingTime);
        } catch (DateTimeParseException dtpe) {
            System.out.println("ERROR: " + dtpe.getMessage());
        }

        return new Animal(id, name, species, gender, age, fixed, legs, weight,
                dateAdded, lastFeedingTime);
    } //getAnimal
} //class
