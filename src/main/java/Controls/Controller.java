package Controls;

import db.PropertyClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnamefield;
    @FXML
    private DatePicker dateField;
    PropertyClass propertyClass;
    FormMethods formMethods;

    public void initialize(){
        propertyClass = new PropertyClass();
        formMethods = new FormMethods();
        binds();
    }
    public void binds(){
        formMethods.objectPropertyProperty().get().nameProperty().bind(nameField.textProperty());
        formMethods.objectPropertyProperty().get().surnameProperty().bind(surnamefield.textProperty());
        formMethods.objectPropertyProperty().get().dateProperty().bind(dateField.valueProperty());

        surnamefield.disableProperty().bind(nameField.textProperty().isEmpty());
        dateField.disableProperty().bind(surnamefield.textProperty().isEmpty());
    }


    public void addForm() throws IOException, SQLException {
    formMethods.addToDatabse();
    }

    public void importToFile() throws IOException, SQLException {
        formMethods.fillObservableList();
    }

    public void searchPositions() throws IOException {
        loadSearch();
    }
    public void loadSearch() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SearchWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.show();
    }
}
