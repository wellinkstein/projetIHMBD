/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import javafx.scene.control.CheckBox;

/**
 * classe permet de gérer des expériences 
 * @author Jérémie, Khadra ABDI JIBRIL
 */

public class Experience {
  private String idExperience; 
  private String typeExperience;
  private String soumisPar;
  private String urgent; 
  private String dateSoumission;
  private String dateTransmission; 
  private String dateDebut; 
  private String dateFin;
  private String validation; 
  private CheckBox checkbox1 = new CheckBox(); //bouton de sélection danns la table da charcheur 
  private CheckBox checkbox2 = new CheckBox(); //button de sélection dans la table de labortin 
  /** 
 * Constructeur de la classe étudiant.
 * Prend en paramètre les valeurs des attributs d'un étudiant.
 * @param idExperience 
 * @param typeExperience
 * @param soumisPar
 * @param urgent
 * @param dateSoumission
 * @param dateTransmission
 * @param dateDebut
 * @param dateFin
 * @param validation
 */
  
   public Experience(String idExperience, String typeExperience, String soumisPar, String urgent, String dateSoumission,  String dateTransmission,  String dateDebut, String dateFin, String validation) {
        this.idExperience = idExperience;
        this.typeExperience = typeExperience;
        this.soumisPar = soumisPar;
        this.urgent = urgent; 
        this.dateSoumission = dateSoumission; 
        this.dateTransmission = dateTransmission;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.validation = validation; 
    }
   
   /**
    * Getter pour idExperience
    * @return 
    */

    public String getIdExperience() {
        return idExperience;
    }
    
    /**
     * Setter pour idExperience
     * @param idExperience 
     */

    public void setIdExperience(String idExperience) {
        this.idExperience = idExperience;
    }
    
    /**
     * Getter pour typeExperience
     * @return 
     */

    public String getTypeExperience() {
        return typeExperience;
    }

    /**
     * Setter pour typeExperience
     * @param typeExperience 
     */
    
    public void setTypeExperience(String typeExperience) {
        this.typeExperience = typeExperience;
    }

    /**
     * Getter pour soumisPar
     * @return 
     */
    
    public String getSoumisPar() {
        return soumisPar;
    }
    
    /**
     * Setter pour soumisPar
     * @param soumisPar 
     */

    public void setSoumisPar(String soumisPar) {
        this.soumisPar = soumisPar;
    }

    /**
     * Getter pour urgent
     * @return 
     */
    
    public String getUrgent() {
        return urgent;
    }

    /**
     * Setter pour urgent
     * @param urgent 
     */
    
    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }
    
    /**
     * Getter pour dateSoumission
     * @return 
     */

    public String getDateSoumission() {
        return dateSoumission;
    }
    
    /**
     * Setter pour dateSoumission
     * @param dateSoumission 
     */

    public void setDateSoumission(String dateSoumission) {
        this.dateSoumission = dateSoumission;
    }
    
    /**
     * Getter pour dateTransmission
     * @return 
     */

    public String getDateTransmission() {
        return dateTransmission;
    }
    
    /**
     * Setter pour dateTransmission
     * @param dateTransmission 
     */

    public void setDateTransmission(String dateTransmission) {
        this.dateTransmission = dateTransmission;
    }
    
    /**
     * Getter pour dateDebut
     * @return 
     */

    public String getDateDebut() {
        return dateDebut;
    }
    
    /**
     * Setter pour dateDebut
     * @param dateDebut 
     */

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    /**
     * Getter pour dateFin
     * @return 
     */

    public String getDateFin() {
        return dateFin;
    }
    
    /**
     * Setter pour dateFin
     * @param dateFin 
     */

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    
    /**
     * Getter pour validation
     * @return 
     */

    public String getValidation() {
        return validation;
    }
    
    /**
     * Setter pour validation
     * @param validation 
     */

    public void setValidation(String validation) {
        this.validation = validation;
    }
    
    /**
     * Setter pour validation
     * @return 
     */

    public CheckBox getCheckbox1() {
        return checkbox1;
    }
    
    /**
     * Getter pour la checkbox1
     * @param checkbox1 
     */

    public void setCheckbox1(CheckBox checkbox1) {
        this.checkbox1 = checkbox1;
    }
    
    /**
     * Getter pour checkbox2
     * @return 
     */

    public CheckBox getCheckbox2() {
        return checkbox2;
    }
    
    /**
     * Setter pour checkbox2
     * @param checkbox2 
     */

    public void setCheckbox2(CheckBox checkbox2) {
        this.checkbox2 = checkbox2;
    }
   
}