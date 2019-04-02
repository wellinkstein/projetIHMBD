package projetihmbd;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
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
        Text mdpText = new Text("Mot de passe");
        
        GridPane gridpane = new GridPane();
        //gridpane.setAlignment(Pos.CENTER);
        gridpane.setVgap(4);
        gridpane.setHgap(10);
        
        //ajout du texte et de l'image dans le gridpane
        gridpane.add(textTitre,1,0);
        
        gridpane.add(userText,0,1);
        gridpane.add(userField,1,1);
        
        gridpane.add(mdpText,0,2);
        gridpane.add(mdpField,1,2);
        
        
        
        gridpane.add(validationText,1,3);
        
        gridpane.add(buttonValider, 1, 4);
        
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        gridpane.setPadding(new Insets(50));
        
        //alignement des champs du gridpane
        //GridPane.setHalignment(textTitre, HPos.CENTER);
        
        GridPane.setHalignment(userText, HPos.RIGHT);
        GridPane.setHalignment(userField, HPos.LEFT);
        
        GridPane.setHalignment(mdpText, HPos.RIGHT);
        GridPane.setHalignment(mdpField, HPos.LEFT);
        
        
        
        this.getChildren().add(gridpane);
        
        userField.setOnMouseClicked(e -> {
            if (userField.getText().equals("U1 pour lab ou U2 pour chercheur")){
                userField.setText(null);
            }
        });
        
        mdpField.setOnMouseClicked(e -> {
            if (mdpField.getText().equals("111 pour lab ou 222 pour chercheur")) {
                mdpField.setText(null);
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
