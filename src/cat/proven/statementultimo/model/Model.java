/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.statementultimo.model;


import cat.proven.statementultimo.persist.ProductDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ProvenSoft
 */
public class Model {
    
    private ProductDao productDao;
    
    //constructor
    public Model() {
        //DbConnect.loadDriver();
        productDao = new ProductDao();
    }
    
    //methods.
    public Product updateRow(Product p){
        
        Product result = null;
        result = productDao.updateRow(p);
        return result;
    }
    
    
    public void insertRow(Product p){
       
        productDao.insertRow(p);
        
        
    }
    public int deleteRow(){
        int result =0;
        result = productDao.deleteRow();
        return result;
        
    }
    public Product next(){
        Product result = null;
        result= productDao.next();
        return result;
    }
    public Product first(){
        Product result = null;
        result= productDao.first();
        return result;
    }
    public void firstStart(){
         productDao.firstStart();
    }
    public Product previus(){
        Product result = null;
        result= productDao.previus();
        return result;
    }
    public Product last(){
        Product result = null;
        result= productDao.last();
        return result;
    }
    public void quit(){
        productDao.closeConnection();
        
    }
    
        
        
}

