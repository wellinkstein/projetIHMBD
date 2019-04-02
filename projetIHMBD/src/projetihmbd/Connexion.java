package projetihmbd;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Classe pour gérer la connexion d'un utilisateur.
 * @author Jérémie
 * @version 25/03/2019
 */
public class Connexion extends Parent {
    
    Button buttonValider = new Button("Connexion");
    TextField userField = new TextField("U1 pour lab ou U2 pour chercheur");
    TextField mdpField = new TextField("111 pour lab ou 222 pour chercheur");
    Text validationText = new Text(""); // texte pour valider la connexion
    
    
    /**
     * Constructeur pour la connexion.
     * @param listeUtilisateurs
     */
    
    public Connexion(ArrayList<Utilisateur> listeUtilisateurs){
        
        // titre
        
        Text textTitre = new Text();
        textTitre.setText("Connexion");
        textTitre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        textTitre.setX(220);
        textTitre.setY(220);
        textTitre.setFill(javafx.scene.paint.Color.BLACK);
        textTitre.setStrokeWidth(2);
        buttonValider.setStyle("-fx-background-color: lightblue");
        //userField.setStyle("-fx-background-color: lightblue");
        
        userField.setTooltip(
                new Tooltip("Utilisateur")
        );
        
        mdpField.setTooltip(
                new Tooltip("Mot de passe")
        );
        
        buttonValider.setTooltip(
                new Tooltip("Se connecter")
        );
        
        // texte pour décrire les champs
        
        Text userText = new Text("Nom utilisateur");
        userText.setStyle("-fx-accent: lightblue");
        
        Text mdpText = new Text("Mot de passe");
        mdpText.setStyle("-fx-accent: lightblue");
        
        GridPane gridpane = new GridPane();
        
        gridpane.setVgap(15);
        gridpane.setHgap(20);
        gridpane.setPadding(new Insets(50));
        
        gridpane.add(textTitre,1,0);
        
        gridpane.add(userText,0,1);
        gridpane.add(userField,1,1);
        
        gridpane.add(mdpText,0,2);
        gridpane.add(mdpField,1,2);
        
        gridpane.add(buttonValider, 1, 3);
        
        gridpane.add(validationText,1,4);
        
        
        this.getChildren().add(gridpane);
        
        userField.setOnMouseClicked(e -> {
            if (userField.getText() != null) {
                if (userField.getText().equals("U1 pour lab ou U2 pour chercheur")){
                    userField.setText(null);
                }
            }
        });
        

        mdpField.setOnMouseClicked(e -> {
            if (mdpField.getText() != null) {
                if (mdpField.getText().equals("111 pour lab ou 222 pour chercheur")) {
                    mdpField.setText(null);
                }
            }
        });
        
    }
    
    
    /**
     * Méthode pour connecter un utilisateur et retourner le type d'utilisateur connecte.
     * @param nomUtilisateur
     * @param mdp
     * @param listeUtilisateurs
     * @return
     */
    
    public String connexionUtilisateur(String nomUtilisateur, String mdp, ArrayList<Utilisateur> listeUtilisateurs){
        for (Utilisateur u : listeUtilisateurs) {
            if (u.getNomUtilisateur().equals(nomUtilisateur) & u.getMdp().equals(mdp)){
                u.setEstConnecte(true);
                return u.getTypeUtilisateur();
            }
        }
        return "";
    }
    
    public Button getButtonValider() {
        return buttonValider;
    }
    
    public void setButtonValider(Button buttonValider) {
        this.buttonValider = buttonValider;
    }
    
    public TextField getUserField() {
        return userField;
    }
    
    public TextField getMdpField() {
        return mdpField;
    }
    
    public void setUserField(TextField userField) {
        this.userField = userField;
    }
    
    public void setMdpField(TextField mdpField) {
        this.mdpField = mdpField;
    }
    
    public void setUserFieldVal(String userField){
        this.userField.setText(userField);
    }
    
    public void setMdpFieldVal(String mdpField){
        this.mdpField.setText(mdpField);
    }
    
    public void setValidationText(String validationText){
        this.validationText.setText(validationText);
    }
    
    public Text getValidationText(){
        return validationText;
    }
    
}
