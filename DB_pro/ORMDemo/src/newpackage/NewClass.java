/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author elsis
 */
public class NewClass {
    public static void main (String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORMDemoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//Query 8
//Delete the employee named Jhon.
Query query1 = em.createNamedQuery("Employee.deleteJohn");
query1.executeUpdate();

Query query2 = em.createNamedQuery("Employee.findAll");
List<Employee> employees = query2.getResultList();

 System.out.println("name" );
 
for(Employee employee : employees){
         System.out.format( "%1s\n",employee.getFname() );
 }
  

    }
    
  
}
