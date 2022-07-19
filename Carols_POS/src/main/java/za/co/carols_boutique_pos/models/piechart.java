/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique_pos.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class piechart {
    List<String> name; 
    List<Float> percentagePosition;
    List<Float> percentageRadius;
    List<Float> tablePercentage;
    List<String> colours;
    float total;
    List<Integer> ivalues;
    List<Float> fvalues;
    
    
    public void calculatePercentages(List<Float> values){
          tablePercentage = new ArrayList<>();
          total =0;
          float percent=0;
          percentagePosition=new ArrayList<>();
          percentageRadius = new ArrayList<>();
          for(int i =0;i<values.size();i++ ){
             total=total+values.get(i);
          }
          float prevPercent=0f;
          for(int i =0;i<values.size();i++ ){
             percent =(values.get(i)/total)*100;
             
             percentagePosition.add(prevPercent+percent);
             try{
             tablePercentage.add(percent);
             }catch(NullPointerException e){
             }
             prevPercent=prevPercent+percent;
          }
    }

    public List<Float> getTablePercentage() {
        return tablePercentage;
    }

    public void setTablePercentage(List<Float> tablePercentage) {
        this.tablePercentage = tablePercentage;
    }
    
    public void calculateColours(List<String> name){
         colours=new ArrayList<>();
         for(int i =0; i<name.size();i++){
         colours.add("rgb("+(int)(Math.random()*256)+","+(int)(Math.random()*256)+","+(int)(Math.random()*256)+")");
         }
    }

    public piechart(List<String> name, List<Float> fvalues) {
        this.name = name;
        this.fvalues = fvalues;
        calculateColours(name);
        calculatePercentages(fvalues);
        
    }
    

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Float> getPercentagePosition() {
        return percentagePosition;
    }

    public void setPercentagePosition(List<Float> percentagePosition) {
        this.percentagePosition = percentagePosition;
    }

    public List<Float> getPercentageRadius() {
        return percentageRadius;
    }

    public void setPercentageRadius(List<Float> percentageRadius) {
        this.percentageRadius = percentageRadius;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Integer> getIvalues() {
        return ivalues;
    }

    public void setIvalues(List<Integer> ivalues) {
        this.ivalues = ivalues;
    }

    public List<Float> getFvalues() {
        return fvalues;
    }

    public void setFvalues(List<Float> fvalues) {
        this.fvalues = fvalues;
    }
    
    

    
     
}
