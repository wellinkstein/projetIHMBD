/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Noyau fonctionnel de l'application : lance l'application et 
 * gère les différentes classes de l'application.
 * @author Jérémie
 * @version 25/03/2019
 */
public class ProjetIHMBD extends Application {
   

    @Override
    
    public void start(Stage primaryStage) {
        
        Group root = new Group();


        //creation d'une toolbar
        ToolBar toolBar = new ToolBar();
        
        
        // création de 2 vBox différentes
        VBox vBox = new VBox(toolBar);
        VBox vBox2 = new VBox(root);
        
        Scene scene = new Scene(vBox,600, 600);
        vBox.getChildren().add(vBox2);

        primaryStage.setTitle("Gestion d'expériences de laboratoire");
        primaryStage.setScene(scene);
        
         //  création du bouton Connexion et ajout à la toolbar
        Button buttonConnexion= new Button("Connexion");
        toolBar.getItems().add(buttonConnexion);
        
        //  création du bouton Gestion des expériences et ajout à la toolbar
        Button buttonGestionExp= new Button("Gestion des expériences");
        toolBar.getItems().add(buttonGestionExp);
        
        // création du bouton tableau de bord et ajout à la toolbar
        
        Button buttonTableauBord = new Button ("Tableau de bord");
        toolBar.getItems().add(buttonTableauBord);
        
        //  création du bouton exit et ajout à la toolbar
        
        final Pane rightSpacer = new Pane(); 
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        
        Button buttonExit = new Button("");
        toolBar.getItems().add(rightSpacer);
        toolBar.getItems().add(buttonExit);
        
        //ajout de l'image cross menu au bouton home
        Image image_cross = new Image (ProjetIHMBD.class.getResourceAsStream("images/cross.png"));
        ImageView mon_imageview_cross = new ImageView(image_cross);
        mon_imageview_cross.setFitHeight(20);
        mon_imageview_cross.setPreserveRatio(true);
        buttonExit.setGraphic(mon_imageview_cross);
        
        //évenement souris pour le bouton exit      
        buttonExit.setOnAction(h -> {            
            primaryStage.close();
         
        });
        primaryStage.show(); 
        
      
    }

    public static void main(String[] args) {
    launch(args);
    
    }

}