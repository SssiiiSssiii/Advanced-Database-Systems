-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Company
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Company
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Company` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Company` ;

-- -----------------------------------------------------
-- Table `Company`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Company`.`Department` (
  `Dname` VARCHAR(15) NOT NULL,
  `Dno` INT NOT NULL,
  `Mgr_ssn` CHAR(9) NOT NULL,
  `Mgr_start_date` DATE NULL,
  PRIMARY KEY (`Dno`),
  UNIQUE INDEX `Dname_UNIQUE` (`Dname` ASC),
  INDEX `fk_Department_Employee1_idx` (`Mgr_ssn` ASC),
  CONSTRAINT `fk_Department_Employee1`
    FOREIGN KEY (`Mgr_ssn`)
    REFERENCES `Company`.`Employee` (`Ssn`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Company`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Company`.`Employee` (
  `Fname` VARCHAR(15) NOT NULL,
  `Minit` CHAR NULL,
  `Lname` VARCHAR(15) NOT NULL,
  `Ssn` CHAR(9) NOT NULL,
  `Bdate` DATE NULL,
  `Address` VARCHAR(30) NULL,
  `Sex` CHAR NULL,
  `Salary` DECIMAL(10,2) NULL,
  `Super_ssn` CHAR(9) NULL,
  `Dno` INT NOT NULL,
  PRIMARY KEY (`Ssn`),
  INDEX `fk_Employee_Department_idx` (`Dno` ASC),
  INDEX `fk_Employee_Employee1_idx` (`Super_ssn` ASC),
  CONSTRAINT `fk_Employee_Department`
    FOREIGN KEY (`Dno`)
    REFERENCES `Company`.`Department` (`Dno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Employee_Employee1`
    FOREIGN KEY (`Super_ssn`)
    REFERENCES `Company`.`Employee` (`Ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Company`.`Dept_locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Company`.`Dept_locations` (
  `Dno` INT NOT NULL,
  `Dlocation` VARCHAR(15) NOT NULL,
  INDEX `fk_Dept_locations_Department1_idx` (`Dno` ASC),
  PRIMARY KEY (`Dno`, `Dlocation`),
  CONSTRAINT `fk_Dept_locations_Department1`
    FOREIGN KEY (`Dno`)
    REFERENCES `Company`.`Department` (`Dno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Company`.`Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Company`.`Project` (
  `Pnumber` INT NOT NULL,
  `Pname` VARCHAR(15) NOT NULL,
  `Plocation` VARCHAR(15) NOT NULL,
  `Dno` INT NULL,
  PRIMARY KEY (`Pnumber`),
  INDEX `fk_Project_Department1_idx` (`Dno` ASC),
  CONSTRAINT `fk_Project_Department1`
    FOREIGN KEY (`Dno`)
    REFERENCES `Company`.`Department` (`Dno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Company`.`Works_on`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Company`.`Works_on` (
  `Essn` CHAR(9) NOT NULL,
  `Pnumber` INT NOT NULL,
  `Hours` DECIMAL(3,1) NULL,
  PRIMARY KEY (`Essn`, `Pnumber`),
  INDEX `fk_Works_on_Employee1_idx` (`Essn` ASC),
  INDEX `fk_Works_on_Project1_idx` (`Pnumber` ASC),
  CONSTRAINT `fk_Works_on_Employee1`
    FOREIGN KEY (`Essn`)
    REFERENCES `Company`.`Employee` (`Ssn`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Works_on_Project1`
    FOREIGN KEY (`Pnumber`)
    REFERENCES `Company`.`Project` (`Pnumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Company`.`Dependent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Company`.`Dependent` (
  `Essn` CHAR(9) NOT NULL,
  `Dependent_name` VARCHAR(15) NOT NULL,
  `Sex` CHAR NULL,
  `Bdate` DATE NULL,
  `Relationship` VARCHAR(8) NULL,
  PRIMARY KEY (`Essn`, `Dependent_name`),
  INDEX `fk_Dependent_Employee1_idx` (`Essn` ASC),
  CONSTRAINT `fk_Dependent_Employee1`
    FOREIGN KEY (`Essn`)
    REFERENCES `Company`.`Employee` (`Ssn`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `Company`.`Department`
-- -----------------------------------------------------
START TRANSACTION;
USE `Company`;
INSERT INTO `Company`.`Department` (`Dname`, `Dno`, `Mgr_ssn`, `Mgr_start_date`) VALUES ('Headquarters', 1, '888665555', '1981-06-19');
INSERT INTO `Company`.`Department` (`Dname`, `Dno`, `Mgr_ssn`, `Mgr_start_date`) VALUES ('Administration', 4, '987654321', '1955-01-01');
INSERT INTO `Company`.`Department` (`Dname`, `Dno`, `Mgr_ssn`, `Mgr_start_date`) VALUES ('Research', 5, '333445555', '1988-05-22');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Company`.`Employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `Company`;
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('John', 'B', 'Smith', '123456789', '1965-01-09', '731 Fondren,Houston,TX', 'M', 30000, '333445555', 5);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('Franklin', 'T', 'Wong', '333445555', '1955-12-08', '638 Voss,Houston,TX', 'M', 40000, '888665555', 5);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('Alicia', 'J', 'Zelaya', '999887777', '1968-01-19', '3321 Castle,Spring,TX', 'F', 25000, '987654321', 4);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('Jennifer', 'S', 'Wallace', '987654321', '1941-06-20', '291 Berry,Bellaire,TX', 'F', 43000, '888665555', 4);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('James', 'E', 'Borg', '888665555', '1937-11-10', '450 stone,Houston,TX', 'M', 55000, NULL, 1);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('Ramesh', 'K', 'Narayan', '666884444', '1962-09-15', '975 Fire Oak, Humble', 'M', 38000, '333445555', 5);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('Joyce', 'A', 'English', '453453453', '1972-07-31', '5631 Rice, Houston, TX', 'F', 25000, '333445555', 5);
INSERT INTO `Company`.`Employee` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('Ahmed', 'V', 'Jabbar', '987987987', '1969-03-29', '980 Dallas, Houston, TX', 'M', 25000, '987654321', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Company`.`Dept_locations`
-- -----------------------------------------------------
START TRANSACTION;
USE `Company`;
INSERT INTO `Company`.`Dept_locations` (`Dno`, `Dlocation`) VALUES (1, 'Houston');
INSERT INTO `Company`.`Dept_locations` (`Dno`, `Dlocation`) VALUES (4, 'Stafford');
INSERT INTO `Company`.`Dept_locations` (`Dno`, `Dlocation`) VALUES (5, 'Bellaire');
INSERT INTO `Company`.`Dept_locations` (`Dno`, `Dlocation`) VALUES (5, 'Sugarland');
INSERT INTO `Company`.`Dept_locations` (`Dno`, `Dlocation`) VALUES (5, 'Houston');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Company`.`Project`
-- -----------------------------------------------------
START TRANSACTION;
USE `Company`;
INSERT INTO `Company`.`Project` (`Pnumber`, `Pname`, `Plocation`, `Dno`) VALUES (1, 'ProductX', 'Bellaire', 5);
INSERT INTO `Company`.`Project` (`Pnumber`, `Pname`, `Plocation`, `Dno`) VALUES (2, 'ProductY', 'Sugarland', 5);
INSERT INTO `Company`.`Project` (`Pnumber`, `Pname`, `Plocation`, `Dno`) VALUES (3, 'ProductZ', 'Houston', 5);
INSERT INTO `Company`.`Project` (`Pnumber`, `Pname`, `Plocation`, `Dno`) VALUES (10, 'Computerization', 'Stafford', 4);
INSERT INTO `Company`.`Project` (`Pnumber`, `Pname`, `Plocation`, `Dno`) VALUES (20, 'Reorganization', 'Houston', 1);
INSERT INTO `Company`.`Project` (`Pnumber`, `Pname`, `Plocation`, `Dno`) VALUES (30, 'Newbenefits', 'Stafford', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Company`.`Works_on`
-- -----------------------------------------------------
START TRANSACTION;
USE `Company`;
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('123456789', 1, 32.5);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('123456789', 2, 7.5);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('666884444', 3, 40.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('453453453', 1, 20.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('453453453', 2, 20.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('333445555', 2, 10.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('333445555', 3, 10.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('333445555', 10, 10.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('333445555', 20, 10.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('999887777', 30, 30.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('999887777', 10, 10.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('987987987', 10, 35.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('987987987', 30, 5.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('987654321', 30, 20.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('987654321', 20, 15.0);
INSERT INTO `Company`.`Works_on` (`Essn`, `Pnumber`, `Hours`) VALUES ('888665555', 20, null);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Company`.`Dependent`
-- -----------------------------------------------------
START TRANSACTION;
USE `Company`;
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('333445555', 'Alice', 'F', '1986-04-05', 'Daughter');
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('333445555', 'Theodore', 'M', '1983-10-25', 'Son');
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('333445555', 'Joy', 'M', '1958-05-03', 'Spouse');
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('987654321', 'Abner', 'M', '1942-02-28', 'Spouse');
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('123456789', 'Michael', 'M', '1988-01-04', 'Son');
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('123456789', 'Alice', 'F', '1988-12-30', 'Daughter');
INSERT INTO `Company`.`Dependent` (`Essn`, `Dependent_name`, `Sex`, `Bdate`, `Relationship`) VALUES ('123456789', 'Elizabeth', 'F', '1967-05-05', 'Spouse');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
