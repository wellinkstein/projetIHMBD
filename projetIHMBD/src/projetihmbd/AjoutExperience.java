/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Classe pour gérer l'ajout d'une expérience.
 * @author Khadra ABDI JIBRIL
 */

    public class AjoutExperience extends Parent {
    
    /** Constructeur de la classe AjoutExpéreice.
     * Prend en paramètre une TableExp.
     * @param listeExperiences
     */
    
    public AjoutExperience(ListeExperiences listeExperiences){
        
        // titre
        
        Text textTitre = new Text();
        textTitre.setText("Ajouter un nouvel expérience");
        textTitre.setFont(new Font("Arial",20));    
        textTitre.setX(220);
        textTitre.setY(220);   
        textTitre.setFill(javafx.scene.paint.Color.BLACK);
        textTitre.setStrokeWidth(2);

        // texte pour décrire les champs
        
        Text idExperienceText = new Text("IdExperience"); 
        Text typeExperienceText = new Text("TypeExperience"); 
        Text urgentText = new Text("urgent"); 
        Text soumisParText = new Text ("soumisPar");
        Text dateSoumissionText = new Text ("dateSoumission");
        Text dateTransmissionText = new Text("date de transmission");
        Text validationText = new Text(""); // texte pour valider l'ajout d'un étudiant
        
        // création des champs
        
        TextField idExperienceField = new TextField();
        TextField typeExperienceField = new TextField();
        TextField soumisParField = new TextField();
        TextField dateSoumissionField = new TextField();
        TextField dateTransmissionField = new TextField();
        TextField validationField = new TextField();
        ChoiceBox urgentchoiceBox= new ChoiceBox(); 
        urgentchoiceBox.getItems().addAll
         ("oui","non");
        urgentchoiceBox.getSelectionModel().select(0);
        
         //Création des boutons
        
        Button buttonValider = new Button("Valider");  
        Button buttonReinitialiser = new Button ("Réinitialiser");
        
        // effet de style des boutons
        
        buttonValider.setStyle(
         "-fx-background-color: #33ff77; -fx-textfill: white;"); //couleur verte
        buttonReinitialiser.setStyle(
         "-fx-background-color: #ff8080; -fx-textfill: white;");  // couleur rouge
      
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        Lighting li = new Lighting();
        li.setLight(light);
        buttonValider.setEffect(li);
        buttonReinitialiser.setEffect(li);
        
        // création d'un gridpane
        
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        
        //ajout du texte et de l'image dans le gridpane
        gridpane.add(textTitre,1,0);
        
        gridpane.add(idExperienceText,0,2);
        gridpane.add(idExperienceField,1,2);
    
        gridpane.add(typeExperienceText,0,3);
        gridpane.add(typeExperienceField,1,3);
    
        gridpane.add(soumisParText,0,4);
        gridpane.add(soumisParField,1,4);
    
        gridpane.add(urgentText,0,5);
        gridpane.add(urgentchoiceBox,1,5);
 
        gridpane.add(dateSoumissionText,0,6);
        gridpane.add(dateSoumissionField,1,6);
        
        gridpane.add(dateTransmissionText,0,7);
        gridpane.add(dateTransmissionField,1,7);
        
        gridpane.add(validationText,0,7);
        gridpane.add(validationField,1,7);
        
        gridpane.add(buttonValider, 1, 12);      
        gridpane.add(buttonReinitialiser, 0, 12);
        
        gridpane.add(validationText,1,13);
        
        
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        gridpane.setPadding(new Insets(50));
        //gridpane.setGridLinesVisible(true);
    
        //alignement des champs du gridpane
        GridPane.setHalignment(textTitre, HPos.CENTER);
        
        GridPane.setHalignment(idExperienceText, HPos.RIGHT);
        GridPane.setHalignment(idExperienceField, HPos.LEFT);
    
        GridPane.setHalignment(typeExperienceText, HPos.RIGHT);
        GridPane.setHalignment(typeExperienceField, HPos.LEFT);
    
        GridPane.setHalignment(soumisParText, HPos.LEFT);
        GridPane.setHalignment(soumisParField, HPos.LEFT);
    
        GridPane.setHalignment(urgentText, HPos.RIGHT);
        GridPane.setHalignment(urgentchoiceBox, HPos.LEFT);
        
        GridPane.setHalignment(dateSoumissionText, HPos.LEFT);
        GridPane.setHalignment(dateSoumissionField, HPos.LEFT);
        
        GridPane.setHalignment(dateTransmissionText, HPos.LEFT);
        GridPane.setHalignment(dateTransmissionField, HPos.LEFT);
        
        GridPane.setHalignment(validationText, HPos.LEFT);
        GridPane.setHalignment(validationField, HPos.LEFT);
        
        buttonReinitialiser.setOnAction(e -> {
            initAjout(idExperienceField, idExperienceField, soumisParField, dateSoumissionField, dateTransmissionField ,validationField );
        });

        
        buttonValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent f) {
                listeExperiences.addExperience(idExperienceField.getText(), typeExperienceField.getText(), urgentchoiceBox.getValue().toString(), soumisParField.getText(),dateTransmissionField.getText(), validationField.getText(),"","","");
                boolean res;
//                res = ajoutExperience(newExperience);
//                if (res){
//                    validationText.setText("Ajout effectué");
//                }
//                else{validationText.setText("Erreur saisie expérience");
//                }
//                
//                initAjout(idExperienceField, typeExperienceField, soumisParField, dateTransmissionField);
//            }
//
//            private boolean ajoutExperience(Experience newExperience) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            private void initAjout(TextField idExperienceField, TextField typeExperienceField, TextField soumisParField, TextField dateTransmissionField) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }

            }  
        });
           
    }

    private void initAjout(TextField idExperienceField, TextField idExperienceField0, TextField soumisParField, TextField dateSoumissionField, TextField dateTransmissionField, TextField validationField) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
