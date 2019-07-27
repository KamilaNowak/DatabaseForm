package Controls;

import Converters.DateConverter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import db.BaseManager;
import db.FormDbModel;
import db.PropertyClass;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FormMethods {
    ObservableList<PropertyClass> observableList = FXCollections.observableArrayList();
    ObjectProperty<PropertyClass> objectProperty = new SimpleObjectProperty<>(new PropertyClass());

    public void addToDatabse() throws SQLException, IOException {
        Dao dao = DaoManager.createDao(BaseManager.getConnection(), FormDbModel.class);
        FormDbModel dbModel = new FormDbModel();
        dbModel.setName(getObjectProperty().getName());
        dbModel.setSurname(getObjectProperty().getSurname());
        dbModel.setDate(DateConverter.convertToDate(getObjectProperty().getDate()));
        dao.createOrUpdate(dbModel);
        BaseManager.closeConnection();
    }

    public void fillObservableList() throws SQLException, IOException {
        Dao dao = DaoManager.createDao(BaseManager.getConnection(), FormDbModel.class);
        List<FormDbModel> formDbModelList = dao.queryForAll();
        formDbModelList.forEach(form -> {
            PropertyClass propertyClass = new PropertyClass();
            propertyClass.setName(form.getName());
            propertyClass.setSurname(form.getSurname());
            propertyClass.setDate(DateConverter.convertToLocalDate(form.getDate()));
            observableList.add(propertyClass);
        });
        BaseManager.closeConnection();
        // observableList.forEach(x-> System.out.println(x));
        String fileName = getFileName();
        saveInFile(fileName, observableList);
    }

    public static void saveInFile(String fileName, ObservableList observableList) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName));
        for (Object o : observableList)
            printWriter.println(o.toString());
        printWriter.close();
    }
    public static  String getFileName(){
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("SAVE");
        textInputDialog.setHeaderText("Enter File Name");
        textInputDialog.setGraphic(new ImageView("icons/test.png"));
        Optional<String> result = textInputDialog.showAndWait();
            return result.get();
    }

    public ObservableList<PropertyClass> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<PropertyClass> observableList) {
        this.observableList = observableList;
    }

    public PropertyClass getObjectProperty() {
        return objectProperty.get();
    }

    public ObjectProperty<PropertyClass> objectPropertyProperty() {
        return objectProperty;
    }

    public void setObjectProperty(PropertyClass objectProperty) {
        this.objectProperty.set(objectProperty);
    }
}
