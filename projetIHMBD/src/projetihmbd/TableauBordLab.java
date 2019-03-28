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
 * Tableau de bord du laborantin
 * @author Jérémie
 */
public class TableauBordLab extends Parent {
    
    
    private final TableView<Experience> tableBord = new TableView<>();
    private final ObservableList<Experience> data =
                FXCollections.observableArrayList();
    
    public TableauBordLab (ListeExperiences listeExperiences){
        
        updateTable(listeExperiences);
        
        
        //tableBord.setPrefSize( 600, 300 );
        
        final Label label = new Label("Expériences");
        label.setFont(new Font("Arial", 20));
    
    // titre
        
        Text textTitre = new Text();
        textTitre.setText("Tableau de bord laborantin");
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
        
        TableColumn UrgCol = new TableColumn("Urgent");
        UrgCol.setMinWidth(100);
        UrgCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("urgent"));
        
        TableColumn dateSouCol = new TableColumn("Soumission");
        dateSouCol.setMinWidth(100);
        dateSouCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateSoumission"));
        
        TableColumn dateDebutCol = new TableColumn("Début");
        dateDebutCol.setMinWidth(100);
        dateDebutCol.setCellValueFactory(
        new PropertyValueFactory<Experience, String>("dateDebut"));

        tableBord.setItems(data);
        tableBord.getColumns().addAll(selectCol, IdCol, tExpCol, UrgCol, dateSouCol, dateDebutCol);
        
        Button buttonValid = new Button ("Valider");
        Button buttonEtditer = new Button ("Editer");
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableBord);
        BorderPane border = new BorderPane();
        border.setLeft(buttonValid);
        border.setRight(buttonEtditer);
        
        BorderPane main = new BorderPane();
        main.setPadding(new Insets(20));
        main.setCenter(vbox);
        main.setBottom(border);
        
        
        this.getChildren().add(main);
        
        
    }
    
    public void updateTable(ListeExperiences listeExperiences){
        for (int i=0 ; i<listeExperiences.getSizeListExp() ; i++){
            
            data.add(listeExperiences.getExp(i));
        }
    }
    
}
