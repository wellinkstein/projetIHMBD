package projetihmbd;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import projetihmbd.ListeExperiences;
import projetihmbd.Experience;
import projetihmbd.Experience;
import projetihmbd.Experience;
import projetihmbd.Experience;
import projetihmbd.ListeExperiences;
import projetihmbd.ListeExperiences;
import projetihmbd.ListeExperiences;
import projetihmbd.TableGestionExp;
import projetihmbd.TableauBordLab;
import projetihmbd.TableauBordLab;
import projetihmbd.TableauBordLab;

/**
 * Simple Preloader Using the ProgressBar Control
 *
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
        textTitre.setText("Ajouter une nouvelle expérience");
        textTitre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));    
        textTitre.setX(220);
        textTitre.setY(220);   
        textTitre.setFill(javafx.scene.paint.Color.BLACK);
        textTitre.setStrokeWidth(2);

        // texte pour décrire les champs
        
        Text idExperienceText = new Text("Id"); 
        Text typeExperienceText = new Text("TypeExperience"); 
        Text urgentText = new Text("urgent"); 
        
        Text AjouterText = new Text(""); // texte pour valider l'ajout d'un expérience
        
        // création des champs
        
        TextField idExperienceField = new TextField();
        TextField typeExperienceField = new TextField();
        ChoiceBox urgentchoiceBox= new ChoiceBox(); 
        urgentchoiceBox.getItems().addAll
         ("oui","non");
        urgentchoiceBox.getSelectionModel().select(0);
        
        
        
         //Création des boutons
        
        Button buttonAjouter = new Button("Ajouter");  

        
        // effet de style des boutons
        
        buttonAjouter.setStyle(
         "-fx-background-color: #33ff77; -fx-textfill: white;"); //couleur verte
        
        
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        Lighting li = new Lighting();
        li.setLight(light);
        buttonAjouter.setEffect(li);
       
        
        // création d'un gridpane
        
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        
        //ajout du texte et de l'image dans le gridpane
        gridpane.add(textTitre,1,0);
        
        gridpane.add(idExperienceText,0,2);
        gridpane.add(idExperienceField,1,2);
    
        gridpane.add(typeExperienceText,0,3);
        gridpane.add(typeExperienceField,1,3);
   
    
        gridpane.add(urgentText,0,5);
        gridpane.add(urgentchoiceBox,1,5);

        
        gridpane.add(buttonAjouter, 1, 12);       
        gridpane.add(AjouterText,1,13);
        
        
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        gridpane.setPadding(new Insets(50));
      
    
        //alignement des champs du gridpane
        GridPane.setHalignment(textTitre, HPos.CENTER);
        
        GridPane.setHalignment(idExperienceText, HPos.RIGHT);
        GridPane.setHalignment(idExperienceField, HPos.LEFT);
    
        GridPane.setHalignment(typeExperienceText, HPos.RIGHT);
        GridPane.setHalignment(typeExperienceField, HPos.LEFT);
    
        GridPane.setHalignment(urgentText, HPos.RIGHT);
        GridPane.setHalignment(urgentchoiceBox, HPos.LEFT);
        
      
    
          buttonAjouter.setOnAction((ActionEvent f) -> {
              listeExperiences.addExperience(idExperienceField.getText(), typeExperienceField.getText(), "", urgentchoiceBox.getValue().toString(),"","","","","");
              
             
         } );
        this.getChildren().add(gridpane);
  } 
  }

