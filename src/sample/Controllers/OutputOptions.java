package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import sample.Models.Tablable;
import sample.Services.GeneratableFactory;
import sample.Services.OutputService;
import sample.Services.ResourceNames;

import java.util.ResourceBundle;
import java.util.logging.Logger;


public class OutputOptions {

    @FXML
    Label nameLabel;

    @FXML
    Label dataTypeLabel;

    @FXML
    Label attributeLabel;

    @FXML
    TextField nameTextField;

    @FXML
    ComboBox<String> dataComboBox;

    @FXML
    ComboBox attributeComboBox;

    @FXML
    Button cancelButton;

    @FXML
    Button saveAddButton;

    @FXML
    Button saveCloseButton;

    @FXML
    VBox mainVBox;

    @FXML
    VBox labelVBox;

    @FXML
    VBox inputVBox;

    @FXML
    HBox buttonHBox;

    @FXML
    Region buttonRegion;

    private ResourceBundle resources;

    private TableView<Tablable> tableView;

    private OutputService service = new OutputService();

    private Logger LOG = Logger.getLogger(getClass().getName());

    public OutputOptions(){

    }

    public void initialize(){
        this.resources = ResourceBundle.getBundle(ResourceNames.RESOURCE_BUNDLE);
        this.inputVBox.prefWidthProperty().bind(this.mainVBox.widthProperty().multiply(0.70));
        this.labelVBox.prefWidthProperty().bind(this.mainVBox.widthProperty().multiply(0.30));

        this.nameLabel.setText(this.resources.getString(ResourceNames.OUTPUT_NAME_LABEL));
        this.dataTypeLabel.setText(this.resources.getString(ResourceNames.OUTPUT_DATA_LABEL));
        this.attributeLabel.setText(this.resources.getString(ResourceNames.OUTPUT_ATTRIBUTES));

        this.nameTextField.maxWidthProperty().bind(this.dataComboBox.widthProperty());


        this.dataComboBox.getItems().addAll(this.service.getGeneratableTypes().values());

        this.cancelButton.setText(this.resources.getString(ResourceNames.OUTPUT_CANCEL));
        this.cancelButton.setMaxWidth(Double.MAX_VALUE);
        this.cancelButton.setOnAction(e -> this.close());

        this.saveAddButton.setText(this.resources.getString(ResourceNames.OUTPUT_SAVE_ADD));
        this.saveAddButton.setOnAction(e -> this.saveAddButtonClicked());
        this.saveAddButton.setMaxWidth(Double.MAX_VALUE);

        this.saveCloseButton.setText(this.resources.getString(ResourceNames.OUTPUT_SAVE_EXIT));
        this.saveCloseButton.setOnAction(e -> this.saveCloseButtonClicked());
        this.saveCloseButton.setMaxWidth(Double.MAX_VALUE);
    }

    public void setTableView(TableView<Tablable> tableView){
        this.tableView = tableView;
    }

    private boolean save(){
        GeneratableFactory factory = new GeneratableFactory();
        String alertString = "";
        if(!this.nameTextField.getText().isEmpty() && !this.dataComboBox.getSelectionModel().isEmpty()){
            Tablable tablable = (Tablable)factory.getGeneratable(this.dataComboBox.getSelectionModel().getSelectedIndex());

            tablable.setColumnName(this.nameTextField.getText());
            tablable.setDataType(this.dataComboBox.getSelectionModel().getSelectedItem());
            tablable.setAttribute(" ");

            this.tableView.getItems().add(tablable);


            return true;
        } else if(this.nameTextField.getText().isEmpty()){
           alertString = this.resources.getString(ResourceNames.OUTPUT_TEXT_WARNING);
        } else {
            alertString = this.resources.getString(ResourceNames.OUTPUT_COMBO_WARNING);
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(alertString);
        alert.showAndWait();

        return false;
    }

    private void saveAddButtonClicked(){
        if(this.save()){
            this.nameTextField.setText("");
            this.dataComboBox.getSelectionModel().clearSelection();
            this.attributeComboBox.getSelectionModel().clearSelection();
        }


    }

    private void saveCloseButtonClicked(){
        this.save();
        this.close();
    }

    private void close(){
        this.labelVBox.getScene().getWindow().hide();
    }


}
