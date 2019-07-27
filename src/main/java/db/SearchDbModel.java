package db;

import Controls.FormMethods;
import Converters.DateConverter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Date;
import java.util.List;

public class SearchDbModel {
    private ObjectProperty<SearchPropertyClass> searchProperty = new SimpleObjectProperty<>(new SearchPropertyClass());
    private ObservableList<PropertyClass> searchObservableList = FXCollections.observableArrayList();

    public void selectWhereName(String textValue) throws SQLException, FileNotFoundException {
        Dao dao = DaoManager.createDao(BaseManager.getConnection(), FormDbModel.class);
        QueryBuilder<FormDbModel, String> queryBuilder = (QueryBuilder<FormDbModel, String>) dao.queryBuilder();
        queryBuilder.where().eq("NAME", textValue);
        PreparedQuery<FormDbModel> prepare = queryBuilder.prepare();
        List<FormDbModel> list = dao.query(prepare);
        list.forEach(pos -> {
            PropertyClass propertyClass = new PropertyClass();
            propertyClass.setName(pos.getName());
            propertyClass.setSurname(pos.getSurname());
            propertyClass.setDate(DateConverter.convertToLocalDate(pos.getDate()));
            searchObservableList.add(propertyClass);
        });
        String name = FormMethods.getFileName();
        FormMethods.saveInFile(name,searchObservableList);
        searchObservableList.clear();
    }

    public void selectWhereSurname(String textValue) throws SQLException, FileNotFoundException {
    Dao dao = DaoManager.createDao(BaseManager.getConnection(),FormDbModel.class);
    QueryBuilder<FormDbModel,String> queryBuilder = dao.queryBuilder();
    queryBuilder.where().eq("SURNAME",textValue);
    PreparedQuery<FormDbModel> preparedQuery = queryBuilder.prepare();
    List<FormDbModel> list = dao.query(preparedQuery);
        list.forEach(pos -> {
            PropertyClass propertyClass = new PropertyClass();
            propertyClass.setName(pos.getName());
            propertyClass.setSurname(pos.getSurname());
            propertyClass.setDate(DateConverter.convertToLocalDate(pos.getDate()));
            searchObservableList.add(propertyClass);
        });
        String filename = FormMethods.getFileName();
        FormMethods.saveInFile(filename,searchObservableList);
        searchObservableList.clear();
    }

    public void selectWhereDate(Date date) throws SQLException, FileNotFoundException {
        Dao dao = DaoManager.createDao(BaseManager.getConnection(),FormDbModel.class);
        QueryBuilder<FormDbModel, Date> queryBuilder = dao.queryBuilder();
        queryBuilder.where().eq("BIRTH DATE",date);
        PreparedQuery<FormDbModel> dbModelPreparedQuery = queryBuilder.prepare();
        List<FormDbModel> list = dao.query(dbModelPreparedQuery);
        list.forEach(pos -> {
            PropertyClass propertyClass = new PropertyClass();
            propertyClass.setName(pos.getName());
            propertyClass.setSurname(pos.getSurname());
            propertyClass.setDate(DateConverter.convertToLocalDate(pos.getDate()));
            searchObservableList.add(propertyClass);
        });
        String name = FormMethods.getFileName();
        FormMethods.saveInFile(name, searchObservableList);
        searchObservableList.clear();
    }


    public SearchPropertyClass getSearchProperty() {
        return searchProperty.get();
    }

    public ObjectProperty<SearchPropertyClass> searchPropertyProperty() {
        return searchProperty;
    }

    public void setSearchProperty(SearchPropertyClass searchProperty) {
        this.searchProperty.set(searchProperty);
    }


}
