/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
    
    /**
     * Constructeur pour la classe connexion
     */
    
    public Connexion(){
        
        // titre
        
        Text textTitre = new Text();
        textTitre.setText("Connexion");
        textTitre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));    
        textTitre.setX(220);
        textTitre.setY(220);   
        textTitre.setFill(javafx.scene.paint.Color.BLACK);
        textTitre.setStrokeWidth(2);
        
        // texte pour décrire les champs
        
        Text userText = new Text("Nom utilisateur"); 
        Text mdpText = new Text("Mot de passe");
        Text typeUserText = new Text("Type d'utilisateur");
        Text validationText = new Text(""); // texte pour valider la connexion
        
        Button buttonValider = new Button ("Valider");
        
// création des champs
        
        TextField userField = new TextField();
        TextField mdpField = new TextField();
        ChoiceBox typeUser = new ChoiceBox(); 
        typeUser.getItems().addAll("Laborantin","Chercheur");
        typeUser.getSelectionModel().select(0);
        
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        
        //ajout du texte et de l'image dans le gridpane
        gridpane.add(textTitre,1,0);
        
        gridpane.add(userText,0,2);
        gridpane.add(userField,1,2);
    
        gridpane.add(mdpText,0,3);
        gridpane.add(mdpField,1,3);
    
        gridpane.add(typeUserText,0,4);
        gridpane.add(typeUser,1,4);
 
        gridpane.add(buttonValider, 1, 8);      
        
        gridpane.add(validationText,1,9);
        
        
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        gridpane.setPadding(new Insets(50));
        //gridpane.setGridLinesVisible(true);
    
        //alignement des champs du gridpane
        GridPane.setHalignment(textTitre, HPos.CENTER);
        
        GridPane.setHalignment(userText, HPos.RIGHT);
        GridPane.setHalignment(userField, HPos.LEFT);
    
        GridPane.setHalignment(mdpText, HPos.RIGHT);
        GridPane.setHalignment(mdpField, HPos.LEFT);
    
        GridPane.setHalignment(typeUserText, HPos.LEFT);
        GridPane.setHalignment(typeUser, HPos.LEFT);
        
        this.getChildren().add(gridpane); 
        
    }
    
    
}
