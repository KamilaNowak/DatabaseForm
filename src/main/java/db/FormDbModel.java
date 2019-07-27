package db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "FORM")
public class FormDbModel {

    @DatabaseField(columnName = "No",generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME")
    private String name;

    @DatabaseField(columnName = "SURNAME")
    private String Surname;

    @DatabaseField(columnName = "BIRTH DATE", dataType = DataType.DATE_STRING)
    private Date date;

    public FormDbModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name.toString() + '\'' +
                ", Surname='" + Surname.toString() + '\'' +
                ", date=" + date.toString();
    }
}
