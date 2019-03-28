/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetihmbd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Cette classe permet au chercheur d'afficher et gérer ses expériences.
 * @author Jérémie
 */
public class TableGestionExp extends Parent {
    
    
    private final TableView<Experience> tableBord = new TableView<>();
    private final ObservableList<Experience> data =
                FXCollections.observableArrayList(
                    new Experience("1", "Colorimétrique", "Chercheur", "Non", "27-03-2019", "", "", "",""));
    
    /**
     * Constructeur de la classe
     */
    
    public TableGestionExp (){
        
        //tableBord.setPrefSize( 600, 300 );
        
        final Label label = new Label("Expériences");
        label.setFont(new Font("Arial", 20));
    
    // titre
        
        Text textTitre = new Text();
        textTitre.setText("Gestion des expériences");
        textTitre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));    
        textTitre.setX(220);
        textTitre.setY(220);   
        textTitre.setFill(javafx.scene.paint.Color.BLACK);
        textTitre.setStrokeWidth(2);
        
                TableColumn selectCol = new TableColumn("[]");
        selectCol.setMinWidth(50);
        selectCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("checkbox2"));
        
                TableColumn IdCol = new TableColumn("ID");
        IdCol.setMinWidth(100);
        IdCol.setCellValueFactory(
            new PropertyValueFactory<Experience, String>("idExperience"));
       
        TableColumn tExpCol = new TableColumn("Type Expérience");
        tExpCol.setMinWidth(125);
        tExpCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("typeExperience"));
        
        TableColumn dateSouCol = new TableColumn("Soumission");
        dateSouCol.setMinWidth(100);
        dateSouCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateSoumission"));
        
        TableColumn dateTransCol = new TableColumn("Transmission");
        dateTransCol.setMinWidth(100);
        dateTransCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateTransmission"));
        
        TableColumn dateDebutCol = new TableColumn("Début");
        dateDebutCol.setMinWidth(100);
        dateDebutCol.setCellValueFactory(
        new PropertyValueFactory<Experience, String>("dateDebut"));
        
        TableColumn labCol = new TableColumn("Laborantin");
        labCol.setMinWidth(100);
        labCol.setCellValueFactory(
        new PropertyValueFactory<Experience, String>("laborantin"));
        
        TableColumn urgCol = new TableColumn("Urgent");
        urgCol.setMinWidth(100);
        urgCol.setCellValueFactory(
        new PropertyValueFactory<Experience, String>("urgent"));
        
        TableColumn valCol = new TableColumn("Validée");
        valCol.setMinWidth(100);
        valCol.setCellValueFactory(
        new PropertyValueFactory<Experience, String>("validee"));

        tableBord.setItems(data);
        tableBord.getColumns().addAll(selectCol, IdCol, tExpCol, dateSouCol, dateTransCol, dateDebutCol, labCol, urgCol, valCol);
        
        Button buttonAjouter = new Button ("Ajouter");
        Button buttonEtditer = new Button ("Editer");
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableBord);
        BorderPane border = new BorderPane();
        border.setLeft(buttonAjouter);
        border.setRight(buttonEtditer);
        
        BorderPane main = new BorderPane();
        main.setPadding(new Insets(20));
        main.setCenter(vbox);
        main.setBottom(border);
        
        
        this.getChildren().add(main);
        
        
    }
    
}
