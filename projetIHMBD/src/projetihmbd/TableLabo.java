/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  projetihmbd;



import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import projetihmbd.TableLabo.Experience;



/*
*
*Table destiner au laboratin afin de comminquer les date debut, date fin et la date de transmission des information. 
*@author Khadra ABDI JIBRIL
*/


 
public class TableLabo extends Application {

 
    private TableView<Experience> table = new TableView<Experience>();
    private final ObservableList<Experience> data = 
            FXCollections.observableArrayList(
            new Experience("01-02-2019", "25-02-2019", "27-02-2019"));
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }

  
 
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table laboratin");
        stage.setWidth(450);
        stage.setHeight(550);
 
        final Label label = new Label("Gestion des expériences");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
             new Callback<TableColumn, TableCell>() {
                 public TableCell call(TableColumn p) {
                    return new EditingCell();
                 }
             };
 
        TableColumn dateDebutCol = new TableColumn("Date de Debut");
        dateDebutCol.setMinWidth(100);
        dateDebutCol.setCellValueFactory(
            new PropertyValueFactory<Experience, String>("dateDebut"));
        dateDebutCol.setCellFactory(cellFactory);
        dateDebutCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Experience, String>>() {
                @Override
                public void handle(CellEditEvent<Experience, String> t) {
                    ((Experience) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setDateDebut(t.getNewValue());
                }
             }
        );
 
 
        TableColumn dateFinCol = new TableColumn("Date de Fin");
        dateFinCol.setMinWidth(100);
        dateFinCol.setCellValueFactory(
            new PropertyValueFactory<Experience, String>("dateFin"));
        dateFinCol.setCellFactory(cellFactory);
        dateFinCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Experience, String>>() {
                @Override
                public void handle(CellEditEvent<Experience, String> t) {
                    ((Experience) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setDateFin(t.getNewValue());
                }
            }
        );
 
        TableColumn dateTransmissionCol = new TableColumn("Date de Transmission");
        dateTransmissionCol.setMinWidth(200);
        dateTransmissionCol.setCellValueFactory(
            new PropertyValueFactory<Experience, String>("dateTransmission"));
        dateTransmissionCol.setCellFactory(cellFactory);
        dateTransmissionCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Experience, String>>() {
                @Override
                public void handle(CellEditEvent<Experience, String> t) {
                    ((Experience) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setDateTransmission(t.getNewValue());
                }
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(dateDebutCol, dateFinCol, dateTransmissionCol);
 
        final TextField addDateDebut = new TextField();
        addDateDebut.setPromptText("date de début");
        addDateDebut.setMaxWidth(dateDebutCol.getPrefWidth());
        final TextField addDateFin = new TextField();
        addDateFin.setMaxWidth(dateFinCol.getPrefWidth());
        addDateFin.setPromptText("date de fin");
        final TextField addDateTransmission = new TextField();
        addDateTransmission.setMaxWidth(dateTransmissionCol.getPrefWidth());
        addDateTransmission.setPromptText("date de transmission");

        // le button d'ajout 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Experience(
                        addDateDebut.getText(),
                        addDateFin.getText(),
                        addDateTransmission.getText()));
                addDateDebut.clear();
                addDateFin.clear();
                addDateTransmission.clear();
            }
        });
 
        hb.getChildren().addAll(addDateDebut, addDateFin, addDateTransmission, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
    
 // classe experience pour gérer les information 
    
    public static class Experience  {
 
        private final SimpleStringProperty dateDebut;
        private final SimpleStringProperty dateFin;
        private final SimpleStringProperty dateTransmission;
 
        public Experience( String debutE, String finE, String tranE) {
            
            this.dateDebut = new SimpleStringProperty(debutE);
            this.dateFin = new SimpleStringProperty(finE);
            this.dateTransmission = new SimpleStringProperty(tranE);
        }
 
        public String getDateDebut() {
            return dateDebut.get();
        }
 
        public void setDateDebut(String debutE) {
             dateDebut.set(debutE);
        }
 
        public String getDateFin() {
            return dateFin.get();
        }
 
        public void setDateFin(String debutE) {
            dateFin.set(debutE);
        }
 
        public String getDateTransmission() {
            return dateTransmission.get();
        }
 
        public void setDateTransmission(String debutE) {
            dateTransmission.set(debutE);
        }

        
    }
 // Gère la classe d'édition des textes ou des numéros dans le tableau
    class EditingCell extends TableCell<Experience, String> {
 
        private TextField textField;
 
        public EditingCell() {
        }
 
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(null);
        }
// dans une case vide, il permet d'ajouter le texte et date  
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }
 //  insérer ou changer un texte directement dans le tableau mais dans notre cas il permet d'insérer les dates de début et fin de l'expérience 
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, 
                    Boolean arg1, Boolean arg2) {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                }
            });
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}