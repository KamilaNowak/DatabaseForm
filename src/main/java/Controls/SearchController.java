package Controls;

import Converters.DateConverter;
import db.SearchDbModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class SearchController {
    @FXML
    private TextField nameEqual;
    @FXML
    private TextField surnameEqual;
    @FXML
    private DatePicker dateEqual;

    SearchDbModel searchDbModel;

    public void initialize(){
        searchDbModel = new SearchDbModel();
        searchBinds();
    }
    public void searchBinds(){
        searchDbModel.searchPropertyProperty().get().nameEqProperty().bind(nameEqual.textProperty());
        searchDbModel.searchPropertyProperty().get().surnameEqProperty().bind(surnameEqual.textProperty());
        searchDbModel.searchPropertyProperty().get().dateEqProperty().bind(dateEqual.valueProperty());
    }

    public void searchName() throws FileNotFoundException, SQLException {
        searchDbModel.selectWhereName(searchDbModel.getSearchProperty().getNameEq());
    }

    public void searchSurname() throws FileNotFoundException, SQLException {
        searchDbModel.selectWhereSurname(searchDbModel.getSearchProperty().getSurnameEq());
    }

    public void searchDate() throws FileNotFoundException, SQLException {
       searchDbModel.selectWhereDate(DateConverter.convertToDate(searchDbModel.getSearchProperty().getDateEq()));
    }
}
