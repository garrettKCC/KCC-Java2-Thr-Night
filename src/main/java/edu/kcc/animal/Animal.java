/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.animal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k0519415
 */
public class Animal implements Comparable<Animal> {

    private String id;
    private static List<String> idList = new ArrayList<>();
    private String name;
    private String species;
    private String gender;
    private int age;
    private boolean fixed;
    private int legs;
    private BigDecimal weight;
    private LocalDate dateAdded;
    private LocalDateTime lastFeedingTime;

    // TODO: Need full constructor (Cash) - DONE
    public Animal(String id, String name, String species,
            String gender, int age, boolean fixed, int legs, BigDecimal weight,
            LocalDate dateAdded, LocalDateTime lastFeedingTime) {
        setId(id);
        idList.add(id);
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setFixed(fixed);
        setLegs(legs);
        setWeight(weight);
        setDateAdded(dateAdded);
        setLastFeedingTime(lastFeedingTime);
    }

    public Animal() {
        id = "0";
        idList.add(id);
        name = "Unknown";
        species = "Unknown";
        gender = "Unknown";
        age = 0;
        fixed = false;
        legs = 4;
        weight = BigDecimal.valueOf(0);
        dateAdded = LocalDate.of(2020, 9, 1); // September 1, 2020
        lastFeedingTime = LocalDateTime.of(2020, 10, 1, 23, 59); // October 1, 2020 at 11:59pm
    }

    // TODO: Need getId method - DONE
    public String getId() {
        return id;
    }

    // TODO: Call the validator method before assigning the value
    public void setId(String id) {
        //idValidator(id);
        this.id = id;
    }

    // TODO: Fix idValidator - Can't compare strings with ==. 
    // Move second if statement out of the loop. Set to private.
    // Only allow it to change if it's "0".   
    //SG:  this can't be right - new Animals will have id not equal to "0"???
    // Do not allow an id to be set if the id is already in the idList - DONE
    // TODO: Need idValidator method (Nate)
    private void idValidator(String id) {
        if (idList.indexOf(id) >= 0) {
            throw new IllegalArgumentException("The id enterd is "
                    + "already taken");
        }
        if (!id.equals("0")) {
            throw new IllegalArgumentException("Cannot reasign the id");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    // TODO: Call the validator method before assigning the value
    public void setSpecies(String species) {
        //speciesValidator(species);
        this.species = species.toLowerCase();
    }

    // TODO: Need speciesValidator method (Musab)
    // Only allow cat and dog. 
    //Only allow it to change if it's "Unknown".
    //SG:  This won't work for new Animals??? Why are we doing this???
    private void speciesValidator(String species) {
        //If species is null, this will return to the method that called it, setSpecies()
        //no further validation is needed if species is null
        //but this allows null????
        if (this.species == null) {
            return;
        }

        //if (this.species.compareTo("Unknown") != 0) {
        //    throw new IllegalArgumentException("Species has already been set");
        //}
        if (!(species.equalsIgnoreCase("cat") || species.equalsIgnoreCase("dog"))) {
            throw new IllegalArgumentException("Species must be cat or dog");
        }
    }

    public String getGender() {
        return gender;
    }

    // TODO: Call the validator method before assigning the value - DONE
    public void setGender(String g) {
        //genderValidator(g);
        gender = g.toLowerCase();
    }

    // TODO: Need genderValidator method
    //Only allow male and female. 
    //Only allow it to change if it's "Unknown".
    //SG: that won't work for new Animals
    private void genderValidator(String gender) {
        if (this.gender == null) {
            return;
        }
        if (this.gender.compareTo("Unknown") != 0) {
            throw new IllegalArgumentException("Gender has already been set");
        }
        if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            throw new IllegalArgumentException("Gender must be male or female.");
        }
    }

    public int getAge() {
        return age;
    }

    // TODO: Need setAge method. Call the validator method before assigning the value - DONE
    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    private void validateAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
    }

    // TODO: Need getFixed method - DONE
    // TODO: Need getFixed method (Richard)
    public boolean getFixed() {
        return fixed;
    }

    // TODO: Call the validator method before assigning the value
    public void setFixed(boolean fix) {
        fixed = fix;
    }

    // TODO: Need fixedValidator method (Thomas)
    // don't allow an animal that is already fixed to be fixed again
    //SG:  doesn't really matter if you set the same value???
    private void fixedValidator() {

    }

    // TODO: Need getLegs method (Nathaniel)- DONE
    public int getLegs() {
        return legs;
    }

    // TODO: Call the validator method before assigning the value - DONE
    public void setLegs(int legs) {
        legsValidator(legs);
        this.legs = legs;
    }

    // TODO: Need legsValidator method - only allow legs 0 to 4(Christopher) - DONE
    private void legsValidator(int legs) {
        if (legs < 0 || legs > 4) {
            throw new IllegalArgumentException("Legs must be between 0 and 4");
        }
    }

    public BigDecimal getWeight() {
        return weight;
    }

    // TODO: Call the validator method before assigning the value - DONE
    public void setWeight(BigDecimal animalWeight) {
        weightValidator(animalWeight);
        weight = animalWeight;
    }

    // TODO: Need weightValidator method - only allow weight 0.0 to 1000.0 - DONE
    private void weightValidator(BigDecimal animalWeight) {
        if (animalWeight.compareTo(new BigDecimal(0)) < 0
                || animalWeight.compareTo(new BigDecimal(1000)) > 0) {
            throw new IllegalArgumentException("Animal weight must be between 0 and 1000");
        }
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    // TODO: Call the validator method before assigning the value
    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    // TODO - Include a string inside the parenthesis of the 
    //IllegalArgumentException to say what is wrong. - DONE
    //Set to private. - DONE
    // TODO - Don't allow future dates.
    private void dateValidator(LocalDate date) {
        if (date.isBefore(LocalDate.now().minusWeeks(1))) {
            throw new IllegalArgumentException("Date added cannot be in the future.");
        }
    }

    public LocalDateTime getLastFeedingTime() {
        return lastFeedingTime;
    }

    // TODO: Call the validator method before assigning the value
    public void setLastFeedingTime(LocalDateTime ldt) {
        lastFeedingTime = ldt;
    }

    //SG: I don't think this is right???
    private void feedingValidator(LocalDateTime lastFeedingTime) {
        if (LocalDateTime.now().minusDays(2).isBefore(lastFeedingTime)) {
            throw new IllegalArgumentException("Last feeding time "
                    + "cannot me more than two days in the past");
        }
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", name=" + name + ", species=" + species
                + ", gender=" + gender + ", age=" + age + ", fixed=" + fixed
                + ", legs=" + legs + ", weight=" + weight
                + ", dateAdded=" + dateAdded + ", lastFeedingTime=" + lastFeedingTime + '}';
    }

    // TODO: Need compareTo method //Musab
    // Compare by their species first, then by their name 
    public int compareTo(Animal other) {
        int result;
        result = this.getSpecies().compareTo(other.getSpecies());
        if (result == 0) {
            result = this.getName().compareTo(other.getName());
        }
        return result;
    }

}
