/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import javafx.scene.control.CheckBox;

/**
 * classe permet de gérer des expériences 
 * @author Khadra ABDI JIBRIL
 */

public class Experience {
  private CheckBox checkbox1 = new CheckBox(); //bouton de sélection danns la table da charcheur 
  private String idExperience; 
  private String typeExperience;
  private String soumisPar;
  private String urgent; 
  private String dateSoumission;
  private String dateDebut; 
  private String dateFin;
  private String dateTransmission; 
  private String validation;   
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
     * Getter pour l'attribut idExperience d'un expérience.
     * @return 
     */
    
    public String getidExperience() {
        return idExperience;
    }
  /**
     * Getter pour l'attribut typeExperience d'un expérience.
     * @return 
     */
    
    public String gettypeExperience() {
        return typeExperience;
    }
    /**
     * Getter pour l'attribut soumis_par d'un expérience.
     * @return 
     */
    
    public String getsoumisPar() {
        return soumisPar;
    }
  
   /**
     * Getter pour l'attribut urgent d'un expérience.
     * @return 
     */
    
    public String geturgent() {
        return urgent;
    }
    /**
     * Getter pour l'attribut date_soumission d'un expérience.
     * @return 
     */
    
    public String getdate_soumission() {
        return dateSoumission;
    }
    /**
     * Getter pour date_transmission d'un expérience.
     * @return 
     */
    
    public String getdateTransmission() {
        return dateTransmission;
    }
     public String getdateDebut() {
        return dateDebut;
    }
    /**
     * Getter pour date de début d'un expérience.
     * @return 
     */
    
    public String getdateFin() {
        return dateFin;
    }
     /**
     * Getter pour validation d'un expérience.
     * @return 
     */
    
    public String getvalidation() {
        return validation;
    }
     /**
     * Setter pour l'id d'expérience d'un expérience.
     * @param idExperience
     */
    
    public void setidExperience (String idExperience){
        this.idExperience = idExperience; 
    }
        
  
     /**
     * Setter pour le type d'expérience d'un expérience.
     * @param typeExperience
     */
    
    public void settypeExperience (String typeExperience){
        this.typeExperience = typeExperience;
    }
    /**
     * Setter pour la soumission d'un expérience.
     * @param soumisPar
     */
    
    public void setsoumisPar (String soumisPar){
        this.soumisPar = soumisPar;
    }
    /**
     * Setter pour l'urgence d'un expérience.
     * @param urgent
     */
    
    public void seturgnet (String urgent){
        this.urgent = urgent;
    }
    /**
     * Setter pour la date de soumsission d'un expérience.
     * @param dateSoumission
     */
    
    public void setdateSoumission (String dateSoumission){
        this.dateSoumission= dateSoumission;
    }
    /**
     * Setter pour la date de transmission d'un expérience.
     * @param dateTransmission
     */
    
    public void setdateTransmission (String dateTransmission){
        this.dateTransmission = dateTransmission;
    }
      /**
     * Setter pour la date de début d'un expérience.
     * @param dateDebut
     */
    
    public void setdateDebut (String dateDebut){
        this.dateDebut = dateDebut;
    }
    /**
     * Setter pour la date de fin d'un expérience.
     * @param dateFin
     */
    
    public void setdateFin (String dateFin){
        this.dateFin = dateFin;
    }
    /**
     * Setter pour la validation d'un expérience.
     * @param validation
     */
    
    public void setvalidation(String validation){
        this.validation = validation;
    
    }
     /**
     * Getter pour déterminer si le statut de la checkbox dans la 
     * tableview de tableau de bord de chercheur = 1 
     * @return 
     */
    
    public CheckBox getCheckbox1() {
        return checkbox1;
    }
    
    /**
     * Setter pour la checkbox de l'expérience.
     * @param checkbox1 
     */
 
    public void setCheckBox1(CheckBox checkbox1) {
        this.checkbox1 = checkbox1;
    }
    /**
     * Getter pour déterminer si le statut de la checkbox dans la 
     * tableview de tableau de bord de laboratin= 2 
     * @return 
     */
    
    public CheckBox getCheckbox2() {
        return checkbox2;
    }
    
    /**
     * Setter pour la checkbox de l'expérience.
     * @param checkbox2 
     */
 
    public void setCheckBox2(CheckBox checkbox2) {
        this.checkbox2 = checkbox2;
    }
}
