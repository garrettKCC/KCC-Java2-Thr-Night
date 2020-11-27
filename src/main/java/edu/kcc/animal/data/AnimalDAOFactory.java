/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kcc.animal.data;

/**
 *
 * @author PSUser
 */
public class AnimalDAOFactory {

    private static final String DAO_SOURCE = "CSV";

    public static AnimalDAO getAnimalDAO() {
        AnimalDAO dao = null;
        switch (DAO_SOURCE) {
            case "CSV":
                //dao = new AnimalDAOCSV();
                break;
            case "XML":
                break;
            case "MYSQL":
                break;
            default:
        }
        return dao;
    }
}

