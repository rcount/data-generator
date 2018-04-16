package sample.Controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Main;
import sample.Models.DataType;
import sample.Models.NumberData;
import sample.Models.Tablable;
import sample.Services.*;


import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputController{

    //TODO: Comment File

    //MARK: - FXML attributes for the InputController class -

    @FXML
    BorderPane inputBorderPane;

    @FXML
    Label rowsLabel;

    @FXML
    VBox labelVBox;

    @FXML
    VBox dataVBox;

    @FXML
    VBox rightVBox;

    @FXML
    Label separatorLabel;

    @FXML
    Label quoteLabel;

    @FXML
    TextField rowsTextField;

    @FXML
    ComboBox<String> separatorComboBox;

    @FXML
    ComboBox<String> quoteComboBox;

    @FXML
    HBox addDataHBox;

    @FXML
    TableView<Tablable> dataTypeTable;

    @FXML
    TableColumn<Tablable, String> nameColumn;

    @FXML
    TableColumn<Tablable, String> dataTypeColumn;

    @FXML
    TableColumn<Tablable, String> detailsColumn;

    @FXML
    TableColumn<String, Integer> countColumn;

    @FXML
    Button addDataButton;

    @FXML
    Button deleteButton;

    @FXML
    Button generateButton;

    @FXML
    Region rightFreeRegion;

    //MARK: - Private attributes for the class -

    private static final double MAX_COLUMN_PERCENT = 0.30;


    private static final double COUNT_COLUMN_WIDTH_PERCENT = .10;

    private int numberOfRows = 0;

    private String separator = "";

    private String quote = "";

    private static final int MAX_ROWS = 1_000_000;

    private ResourceBundle resources = ResourceBundle.getBundle(ResourceNames.RESOURCE_BUNDLE);

    private Logger LOG = Logger.getLogger(InputController.class.getName());

    /**
     * Public void initialize method. This method is automatically called by {@link FXMLLoader}
     */
    public void initialize(){

        //set the text on the labels
        this.rowsLabel.setText(this.resources.getString(ResourceNames.NUMBER_OF_ROWS));
        this.separatorLabel.setText(this.resources.getString(ResourceNames.SEPARATOR));
        this.quoteLabel.setText(this.resources.getString(ResourceNames.QUOTE));

        DoubleProperty labelWidth = new SimpleDoubleProperty(130);
        this.labelVBox.prefWidthProperty().bind(labelWidth);

        //set up textField
        //add textProperty ChangeListener
        this.rowsTextField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.replace(",", "").matches("-?([1-9][0-9]*)?")) {
                    int temp = Integer.parseInt(newValue.replace(",", ""));
                    if (temp <= MAX_ROWS) {
                        numberOfRows = Integer.parseInt(newValue.replace(",", ""));
                        rowsTextField.setText(String.format("%,d", numberOfRows));
                    } else {
                        rowsTextField.setText(String.format("%,d", numberOfRows));
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle(resources.getString(ResourceNames.MAX_REACHED_ALERT));
                        alert.setHeaderText(resources.getString(ResourceNames.MAX_REACHED_ALERT));
                        alert.setContentText(MessageFormat.format(resources.getString(ResourceNames.MAX_REACHED_ALERT_CONTENT), MAX_ROWS));
                        alert.showAndWait();
                    }


                } else {

                    rowsTextField.setText(String.format("%,d", numberOfRows));
                }

            }
        });

        //set the prompt Text
        this.rowsTextField.setPromptText(this.resources.getString(ResourceNames.NUMBER_OF_ROWS));

        this.setUpComboBoxes();
        this.setupTableView();

        this.rowsTextField.maxWidthProperty().bind(this.separatorComboBox.widthProperty());

        //Setup the buttons
        this.addDataButton.setText(this.resources.getString(ResourceNames.ADD_DATA_ROW_BUTTON));
        this.addDataButton.setOnAction(e -> this.addDataButtonClicked());

        this.deleteButton.setText(this.resources.getString(ResourceNames.DELETE_DATA_ROW_BUTTON));
        this.deleteButton.setOnAction(e -> this.deleteButtonClicked());

        this.generateButton.setText(this.resources.getString(ResourceNames.GENERATE_BUTTON));
        this.generateButton.setOnAction(e -> this.generateButtonClicked());
        this.generateButton.getStyleClass().add(".generateButton");
        this.dataVBox.prefWidthProperty().bind(Main.primaryStage.widthProperty());


    }

    public BorderPane getInputBorderPane(){
        return this.inputBorderPane;
    }


    private void setUpComboBoxes(){
        //set up comboBoxes
        //set up the separatorListComboBox
        List<String> separatorList = Arrays.asList(this.resources.getString(ResourceNames.SEPARATOR_LIST).split(","));
        this.separatorComboBox.getItems().addAll(separatorList);
        this.separatorComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue.replace(" ", "").toLowerCase()){
                    case "comma":
                        separator = ",";
                        break;
                    case "pipe":
                        separator = "|";
                        break;
                    case "tab":
                        separator = "\t";
                        break;
                    case "semicolon":
                        separator = ";";
                        break;
                    case "colon":
                        separator = ":";
                        break;
                    default:
                        separator = ",";
                }

            }
        });
        this.separatorComboBox.getSelectionModel().selectFirst();

        //set up the quoteComboBox
        List<String> quoteList = Arrays.asList(this.resources.getString(ResourceNames.QUOTE_LIST).split(","));
        this.quoteComboBox.getItems().addAll(quoteList);
        this.quoteComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue.replace(" ", "").toLowerCase()){
                    case "double":
                        quote = "\"";
                        break;
                    case "single":
                        quote = "\'";
                        break;
                    default:
                        quote = "\"";
                        break;
                }

            }
        });
        this.quoteComboBox.getSelectionModel().selectFirst();
    }

    private void setupTableView(){

        String columnName = this.resources.getString(ResourceNames.NUMBER_TABLE_COLUMN);
        this.setupTableColumn(this.countColumn, columnName, COUNT_COLUMN_WIDTH_PERCENT);
        this.countColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<String, Integer> param) {
                return new ReadOnlyObjectWrapper(dataTypeTable.getItems().indexOf(param.getValue()) + 1);
            }
        });


        columnName = this.resources.getString(ResourceNames.NAME_TABLE_COLUMN);
        this.setupTableColumn(this.nameColumn, columnName, MAX_COLUMN_PERCENT);
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("columnName"));

        columnName = this.resources.getString(ResourceNames.DATA_TYPE_TABLE_COLUMN);
        this.setupTableColumn(this.dataTypeColumn, columnName, MAX_COLUMN_PERCENT);
        this.dataTypeColumn.setCellValueFactory(new PropertyValueFactory<>("dataType"));

        columnName = this.resources.getString(ResourceNames.DETAILS_TABLE_COLUMN);
        this.setupTableColumn(this.detailsColumn, columnName, MAX_COLUMN_PERCENT);
        this.detailsColumn.setCellValueFactory(new PropertyValueFactory<>("attribute"));

        this.dataTypeTable.setEditable(false);

    }

    private void setupTableColumn(TableColumn column, String name, double percent) {
        column.setText(name);
        column.prefWidthProperty().bind(this.dataTypeTable.widthProperty().multiply(percent));
        column.setSortable(false);
    }

    private void addDataButtonClicked(){
        LOG.log(Level.INFO, "Add Data Button Clicked");

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLViews.Files.OUTPUT_OPTIONS));


        Scene newScene;
        Stage output = new Stage();
        output.initOwner(Main.getPrimaryStage());
        try {
            newScene = new Scene(loader.load(), 400, 200);
            output.setScene(newScene);
        }catch (IOException ex){
            LOG.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();

        }

        OutputOptions outputOptions = loader.<OutputOptions>getController();
        outputOptions.setTableView(this.dataTypeTable);

        output.initModality(Modality.APPLICATION_MODAL);
        output.showAndWait();


    }

    private void deleteButtonClicked(){
        this.dataTypeTable.getItems().removeAll(this.dataTypeTable.getSelectionModel().getSelectedItem());
    }


    private void generateButtonClicked(){
        if(this.numberOfRows > 0){

            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"),
                                                 new FileChooser.ExtensionFilter("Text", "*.txt"),
                                                 new FileChooser.ExtensionFilter("JSON", "*.json"),
                                                 new FileChooser.ExtensionFilter("XML", "*.xml"));

            chooser.getExtensionFilters().addListener(new ListChangeListener<FileChooser.ExtensionFilter>() {
                @Override
                public void onChanged(Change<? extends FileChooser.ExtensionFilter> c) {

                }
            });
            chooser.setTitle(this.resources.getString(ResourceNames.SAVE_DATA));
            File file = chooser.showSaveDialog(Main.getPrimaryStage());

            if(file != null){
                int factoryType = 0;
                String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1);
                switch (extension){
                    case "csv":
                        factoryType = OutFileFactory.CSV_FILE;
                        break;
                    case "txt":
                        factoryType = OutFileFactory.TEXT_FILE;
                        break;
                    case "json":
                        factoryType = OutFileFactory.JSON_FILE;
                        break;
                    case "xml":
                        factoryType = OutFileFactory.XML_FILE;
                        break;
                    default:
                        factoryType = OutFileFactory.TEXT_FILE;
                }


                OutFileService fileService = OutFileFactory.getOutFileService(factoryType, file, this.numberOfRows, this.separator, this.quote, this.dataTypeTable.getItems());

                fileService.writeFile();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(this.resources.getString(ResourceNames.INPUT_TEXT_WARNING));
            alert.showAndWait();
        }

    }

}
