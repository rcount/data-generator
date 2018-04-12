package sample.Models;

import com.google.gson.annotations.Expose;
import javafx.beans.property.SimpleStringProperty;
import sample.Models.Interfaces.Generatable;

public abstract class Tablable implements Generatable {


    SimpleStringProperty columnName = new SimpleStringProperty();

    SimpleStringProperty dataType = new SimpleStringProperty();

    SimpleStringProperty attribute = new SimpleStringProperty();

    public void setColumnName(String columnName){
        this.columnName.setValue(columnName);
    }

    public void setDataType(String dataType){
        this.dataType.setValue(dataType);
    }

    public void setAttribute(String attribute){
        this.attribute.setValue(attribute);
    }

    public String getColumnName() {
        return columnName.get();
    }

    public SimpleStringProperty columnNameProperty() {
        return columnName;
    }

    public String getDataType() {
        return dataType.get();
    }

    public SimpleStringProperty dataTypeProperty() {
        return dataType;
    }

    public String getAttribute() {
        return attribute.get();
    }

    public SimpleStringProperty attributeProperty() {
        return attribute;
    }
}
