package projetihmbd;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        root.setStyle("-fx-background-color: white");
        
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
        toolBar.setStyle("-fx-background-color: white ; -fx-border-color: lightgrey");
        //toolBar.setStyle(");
        
        VBox vBox = new VBox(toolBar);
        VBox vBox2 = new VBox(root);
        
        vBox2.setStyle("-fx-background-color: white");
        
        Scene scene = new Scene(vBox,600, 600);
        vBox.getChildren().add(vBox2);
        

        primaryStage.setTitle("Gestion d'expériences de laboratoire");
        primaryStage.setScene(scene);
        
        String IDLE_DECO_STYLE = "-fx-background-color: FIREBRICK;";
        String HOVERED_DECO_STYLE = "-fx-background-color: RED;";
        
        String IDLE_OTHER_STYLE = "-fx-background-color: lightgrey;";
        String HOVERED_OTHER_STYLE = "-fx-background-color: grey;";
        
         //  création des boutons
        Button buttonConnexion= new Button("Connexion");
        Button buttonGestionExp= new Button("Gestion des expériences");
        Button buttonTableauBord = new Button ("Tableau de bord");
        Button buttonDeconnexion = new Button ("Déconnexion");
        buttonDeconnexion.setStyle(IDLE_DECO_STYLE);
        buttonDeconnexion.setOnMouseEntered(e -> buttonDeconnexion.setStyle(HOVERED_DECO_STYLE));
        buttonDeconnexion.setOnMouseExited(e -> buttonDeconnexion.setStyle(IDLE_DECO_STYLE));
        buttonGestionExp.setStyle(IDLE_OTHER_STYLE);
        buttonGestionExp.setOnMouseEntered(e -> buttonGestionExp.setStyle(HOVERED_OTHER_STYLE));
        buttonGestionExp.setOnMouseExited(e -> buttonGestionExp.setStyle(IDLE_OTHER_STYLE));
        buttonTableauBord.setStyle(IDLE_OTHER_STYLE);
        buttonTableauBord.setOnMouseEntered(e -> buttonTableauBord.setStyle(HOVERED_OTHER_STYLE));
        buttonTableauBord.setOnMouseExited(e -> buttonTableauBord.setStyle(IDLE_OTHER_STYLE));
        
        Text textSeConnecter = new Text("Se connecter");
        
        final Pane rightSpacer = new Pane(); 
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        
        toolBar.getItems().add(textSeConnecter);
        
        Connexion connexion = new Connexion(utilisateurs);
        connexion.getUserField().setStyle("-fx-border-color: GREY;");
        connexion.getMdpField().setStyle("-fx-border-color: GREY;");
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
            connexion.setUserFieldVal("U1 lab ou U2 chercheur");
            connexion.setMdpFieldVal("111 lab ou 222 chercheur");
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
        
        // Evénement pour le bouton connexion de la fenêtre de connexion
        
        connexion.getButtonValider().setOnAction(j -> {
              String co = connexion.connexionUtilisateur(connexion.getUserField().getText(), connexion.getMdpField().getText(), utilisateurs);
              gestionConnexion(co, toolBar, buttonConnexion, rightSpacer, textSeConnecter, buttonTableauBord, buttonDeconnexion, buttonGestionExp, tableauBordLab, tableGestionExp, connexion, root, scene, primaryStage);
        });
        
        // Permet la validation des informations de connexion avec la touche "Entrer"
        
        connexion.getMdpField().setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                     String co = connexion.connexionUtilisateur(connexion.getUserField().getText(), connexion.getMdpField().getText(), utilisateurs);
                    gestionConnexion(co, toolBar, buttonConnexion, rightSpacer, textSeConnecter, buttonTableauBord, buttonDeconnexion, buttonGestionExp, tableauBordLab, tableGestionExp, connexion, root, scene, primaryStage);
                }
            }
        });
        
        // dialogue pour confirmer la fermeture du programme
        
        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Quitter");
            alert.setContentText("Souhaitez-vous vraiment quiter ?");
            //alert.setY();
            //alter.setX();
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                   
                alert.close();
            }
            else{
               event.consume();
            }
        });
        
        primaryStage.show(); 
      
    }
    
    /**
     * Méthode permettant de gérer les évènements lors d'une tentative de connexion.
     * Si les informations sont correctes, le panel de l'application est modifié en fonction
     * du type d'utilisateur. Sinon le visuel de la fenêtre change pour informer
     * l'utilisateur de son erreur.
     * @param typeU
     * @param toolBar
     * @param buttonConnexion
     * @param rightSpacer
     * @param textSeConnecter
     * @param buttonTableauBord
     * @param buttonDeconnexion
     * @param buttonGestionExp
     * @param tableauBordLab
     * @param tableGestionExp
     * @param connexion
     * @param root
     * @param scene
     * @param primaryStage 
     */
    
    public void gestionConnexion(String typeU, ToolBar toolBar, Button buttonConnexion, Pane rightSpacer, Text textSeConnecter, Button buttonTableauBord, Button buttonDeconnexion, Button buttonGestionExp, TableauBordLab tableauBordLab, TableGestionExp tableGestionExp, Connexion connexion, Group root, Scene scene, Stage primaryStage){
        if (!typeU.equals("")){
                  if(typeU.equals("Laborantin")){
                        toolBar.getItems().remove(buttonConnexion);
                        toolBar.getItems().remove(rightSpacer);
                        toolBar.getItems().remove(textSeConnecter);
                        toolBar.getItems().add(buttonTableauBord);
                        toolBar.getItems().add(rightSpacer);
                        toolBar.getItems().add(buttonDeconnexion);
                        root.getChildren().clear();
                        root.getChildren().add(tableauBordLab);
                        connexion.getUserField().setStyle("-fx-border-color: GREY;");
                        connexion.getMdpField().setStyle("-fx-border-color: GREY;");
                        primaryStage.setResizable(false);
                        primaryStage.setHeight(540);
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
                        connexion.getUserField().setStyle("-fx-border-color: GREY;");
                        connexion.getMdpField().setStyle("-fx-border-color: GREY;");
                        primaryStage.setResizable(false);
                        primaryStage.setHeight(540);
                        primaryStage.setWidth(800);
                        primaryStage.hide();
                        primaryStage.show();
                  }
                  
                  connexion.setValidationText("");
              }
              else{
                  connexion.setValidationText("Utilisateur inconnu");
                  connexion.getValidationText().setFill(Color.FIREBRICK);
                  connexion.getUserField().setStyle("-fx-border-color: FIREBRICK;");
                  connexion.getMdpField().setStyle("-fx-border-color: FIREBRICK;");
              }
        }
    
    public static void main(String[] args) {
    launch(args);
    
    }

}