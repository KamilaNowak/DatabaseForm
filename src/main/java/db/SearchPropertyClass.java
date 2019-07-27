package db;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class SearchPropertyClass {
    private StringProperty nameEq = new SimpleStringProperty();
    private StringProperty surnameEq = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dateEq = new SimpleObjectProperty<>();


    public SearchPropertyClass() {
    }

    public String getNameEq() {
        return nameEq.get();
    }

    public StringProperty nameEqProperty() {
        return nameEq;
    }

    public void setNameEq(String nameEq) {
        this.nameEq.set(nameEq);
    }

    public String getSurnameEq() {
        return surnameEq.get();
    }

    public StringProperty surnameEqProperty() {
        return surnameEq;
    }

    public void setSurnameEq(String surnameEq) {
        this.surnameEq.set(surnameEq);
    }

    public LocalDate getDateEq() {
        return dateEq.get();
    }

    public ObjectProperty<LocalDate> dateEqProperty() {
        return dateEq;
    }

    public void setDateEq(LocalDate dateEq) {
        this.dateEq.set(dateEq);
    }
}
