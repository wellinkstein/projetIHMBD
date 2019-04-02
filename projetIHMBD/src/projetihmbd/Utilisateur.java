package projetihmbd;

/**
 * Classe pour gérer les utilisateurs
 * @author Jérémie
 * @date 25/03/2019
 */
public class Utilisateur {
    
    private String nomUtilisateur;
    private String mdp;
    private String typeUtilisateur;
    private Boolean estConnecte = false;
    
    /**
     * Constructeur pour la classe utilisateur.
     * @param nomUtilisateur
     * @param mdp
     * @param typeUtilisateur
     */
    
    public Utilisateur(String nomUtilisateur, String mdp, String typeUtilisateur){
        this.nomUtilisateur = nomUtilisateur;
        this.mdp = mdp;
        this.typeUtilisateur = typeUtilisateur;
    }
    
    /**
     * Getter pour le type utilisateur
     * @return
     */
    
    public String getTypeUtilisateur (){
        return typeUtilisateur;
    }
    
    /**
     * Getter pour le nom d'utilisateur
     * @return
     */
    
    public String getNomUtilisateur(){
        return nomUtilisateur;
    }
    
    /**
     * Getter pour le mot de passe
     * @return
     */
    public String getMdp(){
        return mdp;
    }
    
    /**
     * Getter pour retourner si l'utilisateur est connecté ou non.
     * @return
     */
    public boolean getEstConnecte(){
        return estConnecte;
    }
    
    /**
     * Setter pour le type utilisateur
     * @param typeUtilisateur
     */
    public void setTypeUtilisateur(String typeUtilisateur){
        this.typeUtilisateur = typeUtilisateur;
    }
    
    /**
     * Setter pour le nom utilisateur
     * @param nomUtilisateur
     */
    public void setNomUtilisateur (String nomUtilisateur){
        this.nomUtilisateur = nomUtilisateur;
    }
    
    /**
     * Setter pour le mot de passe
     * @param mdp
     */
    public void setMdp(String mdp){
        this.mdp = mdp;
    }
    
    /**
     * Setter pour estConnecte
     * @param estConnecte
     */
    public void setEstConnecte(boolean estConnecte){
        this.estConnecte = estConnecte;
    }
}
