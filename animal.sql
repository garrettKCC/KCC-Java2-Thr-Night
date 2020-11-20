DROP DATABASE IF EXISTS Animaldb;
CREATE DATABASE Animaldb;
USE Animaldb;

/* *****************************************************************************
	Create statement for table Animal
***************************************************************************** */
DROP TABLE IF EXISTS Animal;
CREATE TABLE Animal(
    ID VARCHAR(12) NOT NULL,
    AnimalName VARCHAR(200) NOT NULL,
    Species VARCHAR(50) NOT NULL,
    Gender VARCHAR(1) NOT NULL,
    Age INT(2) NOT NULL,
    Fix BOOLEAN NOT NULL,
    Legs INT(1) NOT NULL,
    Weight DECIMAL(5,2) NOT NULL,
    DateAdded DATE NOT NULL,
    LastFeedingTime DATETIME,
    PRIMARY KEY(ID)    
)
;

/* *****************************************************************************
	Build Stored Procedure sp_add_Animal
***************************************************************************** */
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_add_Animal$$
CREATE PROCEDURE sp_add_Animal(
    IN p_ID VARCHAR(12),
    IN p_AnimalName VARCHAR(200),
    IN p_Species VARCHAR(50),
    IN p_Gender VARCHAR(1),
    IN p_Age INT(2),
    IN p_Fix BOOLEAN,
    IN p_Legs INT(1),
    IN p_Weight DECIMAL(5,2),
    IN p_DateAdded DATE,
    IN p_LastFeedingTime DATETIME
)
BEGIN
    INSERT INTO Animal(
		ID,
        AnimalName,
        Species,
        Gender,
        Age,
        Fix,
        Legs,
        Weight,
        DateAdded,
        LastFeedingTime
    )
    VALUES (
		p_ID,
        p_AnimalName,
        p_Species,
        p_Gender,
        p_Age,
        p_Fix,
        p_Legs,
        p_Weight,
        p_DateAdded,
        p_LastFeedingTime
    );
END$$
DELIMITER ;



/* *****************************************************************************
	Build Stored Procedure sp_get_Animal
***************************************************************************** */
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_get_an_Animal$$
CREATE PROCEDURE sp_get_an_Animal( 
	IN p_AnimalName VARCHAR(200)
) 
BEGIN
	SELECT *
	FROM animal
    WHERE AnimalName = p_AnimalName;
END$$
DELIMITER ;


/* *****************************************************************************
	Add some data
***************************************************************************** */
CALL sp_add_Animal('000000000001','Fido','dog', 'M', 2, 1, 4, 12.2, '2020-11-19', '2020-11-19 08:00:00');
CALL sp_add_Animal('000000000002','Preston','cat', 'M', 4, 1, 4, 10.55, '2020-11-18', '2020-11-18 13:30:00');
CALL sp_add_Animal('000000000003','JB','cat', 'M', 3, 1, 4, 10.125, '2020-11-18', '2020-11-18 13:35:00');
CALL sp_add_Animal('000000000004','Muffin','dog', 'F', 12, 1, 3, 15.75, '2009-03-25', '2020-11-19 18:00:00');

/* *****************************************************************************
                               END OF SCRIPT	
***************************************************************************** */
CALL sp_get_an_Animal('Fido');
CALL sp_get_an_Animal('Preston');


select * from animal;
