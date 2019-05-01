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
            FXCollections.observableArrayList();
    
    /**
     * Constructeur de la classe TableGestionExp
     * @param listeExperiences
     */
    
    public TableGestionExp (ListeExperiences listeExperiences){
        
        updateTable(listeExperiences);
        
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
        
        //Création des colonnes
        
        TableColumn selectCol = new TableColumn("Sélectionner");
        selectCol.setMinWidth(75);
        selectCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("checkbox1"));
        
        TableColumn IdCol = new TableColumn("ID");
        IdCol.setMinWidth(100);
        IdCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("idExperience"));
        
        TableColumn tExpCol = new TableColumn("Type Expérience");
        tExpCol.setMinWidth(125);
        tExpCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("typeExperience"));
        
        TableColumn soumParCol = new TableColumn("Soumis par");
        soumParCol.setMinWidth(100);
        soumParCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("soumisPar"));
        soumParCol.setVisible(false);
        
        TableColumn urgCol = new TableColumn("Urgent");
        urgCol.setMinWidth(100);
        urgCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("urgent"));
        
        TableColumn dateSouCol = new TableColumn("Soumission");
        dateSouCol.setMinWidth(100);
        dateSouCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateSoumission"));
        
        TableColumn dateDebutCol = new TableColumn("Début");
        dateDebutCol.setMinWidth(100);
        dateDebutCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateDebut"));
        
        TableColumn dateFinCol = new TableColumn("Fin");
        dateFinCol.setMinWidth(100);
        dateFinCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateFin"));
        dateFinCol.setVisible(false);
        
        TableColumn dateTransCol = new TableColumn("Transmission");
        dateTransCol.setMinWidth(100);
        dateTransCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("dateTransmission"));
        dateTransCol.setVisible(false);
        
        TableColumn dateValCol = new TableColumn("Validée");
        dateValCol.setMinWidth(100);
        dateValCol.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("validation"));
        
        TableColumn checkbox2Col = new TableColumn("Checkbox");
        checkbox2Col.setMinWidth(100);
        checkbox2Col.setCellValueFactory(
                new PropertyValueFactory<Experience, String>("checkbox2"));
        checkbox2Col.setVisible(false);
        
        // ajout des données et colonnes au tableau de bord
        
        tableBord.setItems(data);
        tableBord.getColumns().addAll(selectCol, IdCol, tExpCol, soumParCol, urgCol, dateSouCol, dateDebutCol, dateFinCol, dateTransCol, dateValCol, checkbox2Col);
        
        String IDLE_OTHER_STYLE = "-fx-background-color: lightgrey;";
        String HOVERED_OTHER_STYLE = "-fx-background-color: grey;";
        
        
        Button buttonAjouter = new Button ("Ajouter");
        Button buttonEtditer = new Button ("Editer");
        buttonAjouter.setStyle(IDLE_OTHER_STYLE);
        buttonAjouter.setOnMouseEntered(e -> buttonAjouter.setStyle(HOVERED_OTHER_STYLE));
        buttonAjouter.setOnMouseExited(e -> buttonAjouter.setStyle(IDLE_OTHER_STYLE));
        buttonEtditer.setStyle(IDLE_OTHER_STYLE);
        buttonEtditer.setOnMouseEntered(e -> buttonEtditer.setStyle(HOVERED_OTHER_STYLE));
        buttonEtditer.setOnMouseExited(e -> buttonEtditer.setStyle(IDLE_OTHER_STYLE));
        
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
        
        buttonAjouter.setOnAction(j -> {
            AjoutExperience ajoutExperience = new AjoutExperience(listeExperiences);
            this.getChildren().clear();
            this.getChildren().add(ajoutExperience);
        });
        
        
        this.getChildren().add(main);
        
        
    }
    
    public void updateTable(ListeExperiences listeExperiences){
        for (int i=0 ; i<listeExperiences.getSizeListExp() ; i++){
            
            data.add(listeExperiences.getExp(i));
        }
    }
    
}
