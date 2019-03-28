/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import java.util.ArrayList;

/**
 * Classe de gestion de la liste des expériences.
 * @author Jérémie
 */
public class ListeExperiences {
    private ArrayList<Experience> listeExperiences = new ArrayList<>();
    
    public ListeExperiences(){
        
    }
    
    /**
     * Méthode pour ajouter une experience.
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
    public void addExperience(String idExperience, String typeExperience, String soumisPar, String urgent, String dateSoumission,  String dateTransmission,  String dateDebut, String dateFin, String validation){
        Experience experience = new Experience(idExperience, typeExperience, soumisPar, urgent, dateSoumission,  dateTransmission,  dateDebut, dateFin, validation);
        listeExperiences.add(experience);
    }
    
    /**
     * Getter pour la taille de la liste des expériences.
     * @return 
     */
    public int getSizeListExp(){
        return listeExperiences.size();
    }
    
    /**
     * Getter pour récupérer l'experience avec un indice.
     * @param indice
     * @return 
     */
    
    public Experience getExp(int indice){
        return listeExperiences.get(indice);
    }
            
    
}


