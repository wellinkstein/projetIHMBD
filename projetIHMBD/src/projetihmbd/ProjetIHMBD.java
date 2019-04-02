package projetihmbd;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
        
        // création de la liste des expériences
        
        ListeExperiences listeExperiences;
        listeExperiences = new ListeExperiences();
        listeExperiences.addExperience("1", "Colorimétrique", "Chercheur", "Non", "27-03-2019", "", "", "","");
        
        //création d'une liste d'utilisateurs
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        Utilisateur u1 = new Utilisateur ("U1", "111", "Laborantin");
        Utilisateur u2 = new Utilisateur ("U2", "222", "Chercheur");
        utilisateurs.add(u1);
        utilisateurs.add(u2);

        ToolBar toolBar = new ToolBar();
        
        VBox vBox = new VBox(toolBar);
        VBox vBox2 = new VBox(root);
        
        Scene scene = new Scene(vBox,600, 600);
        vBox.getChildren().add(vBox2);

        primaryStage.setTitle("Gestion d'expériences de laboratoire");
        primaryStage.setScene(scene);
        
         //  création des boutons
        Button buttonConnexion= new Button("Connexion");
        Button buttonGestionExp= new Button("Gestion des expériences");
        Button buttonTableauBord = new Button ("Tableau de bord");
        Button buttonDeconnexion = new Button ("Déconnexion");
        Text textSeConnecter = new Text("Se connecter");
        
        final Pane rightSpacer = new Pane(); 
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        
        toolBar.getItems().add(textSeConnecter);
        
        Connexion connexion = new Connexion(utilisateurs);
        TableauBordLab tableauBordLab = new TableauBordLab(listeExperiences);
        TableGestionExp tableGestionExp = new TableGestionExp(listeExperiences);
        
        // évenement pour le bouton gestion des expériences
        buttonGestionExp.setOnAction(h -> {
            root.getChildren().clear();
            root.getChildren().add(tableGestionExp);
        });
        
        buttonDeconnexion.setOnAction(h -> {
            root.getChildren().clear();
            toolBar.getItems().remove(buttonDeconnexion);
            toolBar.getItems().remove(rightSpacer);
            toolBar.getItems().remove(buttonGestionExp);
            toolBar.getItems().remove(buttonTableauBord);
            toolBar.getItems().add(textSeConnecter);
            root.getChildren().add(connexion);
            connexion.setUserFieldVal("U1 pour lab ou U2 pour chercheur");
            connexion.setMdpFieldVal("111 pour lab ou 222 pour chercheur");
            primaryStage.setResizable(false);
            primaryStage.setHeight(300);
            primaryStage.setWidth(400);
            primaryStage.hide();
            primaryStage.show();

        });
        
        //évenement pour le bouton Tableau de bord des laborantins
        
        buttonTableauBord.setOnAction(h -> {
           root.getChildren().clear();
           root.getChildren().add(tableauBordLab);
        });
        
        //évenement pour le bouton connexion
        
        buttonConnexion.setOnAction(h -> {
            root.getChildren().clear();
            root.getChildren().add(connexion);
        });
        
        // Affichage de la connexion lors du démarrage de l'application
        primaryStage.setResizable(false);
        primaryStage.setHeight(300);
        primaryStage.setWidth(400);
        primaryStage.hide();
        primaryStage.show();
        root.getChildren().add(connexion);
        
        // Evénement pour le bouton valider de la fenêtre de connexion
        
        connexion.getButtonValider().setOnAction(j -> {
              String co = connexion.connexionUtilisateur(connexion.getUserField().getText(), connexion.getMdpField().getText(), utilisateurs);
              
              // Affichage des items du panel en fonction du type d'utilisateur connecté
              
              if (!co.equals("")){
                  if(co.equals("Laborantin")){
                        toolBar.getItems().remove(buttonConnexion);
                        toolBar.getItems().remove(rightSpacer);
                        toolBar.getItems().remove(textSeConnecter);
                        toolBar.getItems().add(buttonTableauBord);
                        toolBar.getItems().add(rightSpacer);
                        toolBar.getItems().add(buttonDeconnexion);
                        root.getChildren().clear();
                        root.getChildren().add(tableauBordLab);
                        primaryStage.setResizable(true);
                        primaryStage.setHeight(800);
                        primaryStage.setWidth(800);
                        primaryStage.hide();
                        primaryStage.show();
                  
                  }
                  else{
                        toolBar.getItems().remove(buttonConnexion);
                        toolBar.getItems().remove(rightSpacer);
                        toolBar.getItems().remove(textSeConnecter);
                        toolBar.getItems().add(buttonGestionExp);
                        toolBar.getItems().add(rightSpacer);
                        toolBar.getItems().add(buttonDeconnexion);
                        root.getChildren().clear();
                        root.getChildren().add(tableGestionExp);
                        primaryStage.setResizable(true);
                        primaryStage.setHeight(800);
                        primaryStage.setWidth(800);
                        primaryStage.hide();
                        primaryStage.show();
                  }
                  
                  connexion.setValidationText("");
              }
              else{
                  connexion.setValidationText("Utilisateur inconnu");
                  connexion.getValidationText().setFill(Color.RED);
                  
              }
              

        });
        
        primaryStage.show(); 
      
    }
    
    

    public static void main(String[] args) {
    launch(args);
    
    }

}