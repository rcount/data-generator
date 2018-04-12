package sample.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.Services.OSValidator;
import sample.Services.ResourceNames;


import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuController{

    //TODO: Comment File

    //MARK: - Private attributes for the class -

    private Logger LOG = Logger.getLogger(getClass().getName());

    @FXML
    public VBox menuVBox;

    @FXML
    public MenuBar menuBar;

    @FXML
    private Menu fileMenu;

    @FXML
    private Menu helpMenu;

    @FXML
    private Menu editMenu;

    private MenuItem closeMenu;

    private MenuItem aboutMenu;

    private MenuItem licenseMenu;

    private ResourceBundle resources;

    boolean isMac = false;


    //MARK: - Methods to make the class work with FXMLLoader -

    /**
     * Public void initialize method. This method is automatically called by {@link FXMLLoader}
     */
    public void initialize(){
        this.resources = ResourceBundle.getBundle("sample.resources");


        this.menuVBox.prefHeightProperty().bind(this.menuBar.heightProperty());

        this.setUpMenus();

        this.closeMenu = new MenuItem();
        this.aboutMenu = new MenuItem();
        this.licenseMenu = new MenuItem();

        List<MenuItem> fileItems = Arrays.asList(this.closeMenu); //only one item in the .asList() call for now, that might change.
        List<MenuItem> helpItems = Arrays.asList(this.licenseMenu, this.aboutMenu);

        this.addMenuItems(this.fileMenu, fileItems);
        this.addMenuItems(this.helpMenu, helpItems);

        this.setSystemMenu();

    }

    //MARK: - Public methods for the class -

    /**
     * Public method to get to the menu bar
     *
     * @return  A reference to {@link MenuController#menuBar}
     */
    public MenuBar getMenuBar() {
        return this.menuBar;
    }

    //MARK: - Private methods for the class -


    public void setMac(boolean mac) {
        this.isMac = mac;
    }

    public boolean isMac() {
        return this.isMac;
    }

    /**
     * Private void method to handle the click of the {@link MenuController#closeMenu} MenuItem
     */
    private void closeMenuClicked(){
        Platform.exit();
    }

    /**
     * Private method to handle the click of the {@link MenuController#aboutMenu} MenuItem
     */
    private void aboutMenuClicked(){
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle(this.resources.getString(ResourceNames.ABOUT));
        about.setHeaderText(this.resources.getString(ResourceNames.ABOUT));
        about.setContentText(MessageFormat.format(this.resources.getString(ResourceNames.ABOUT_DATA),
                this.resources.getString(ResourceNames.APPLICATION_NAME),
                this.resources.getString(ResourceNames.VERSION)));
        about.showAndWait();
    }


    /**
     * Private method to handle the click of the {@link MenuController#licenseMenu} MenuItem
     */
    private void licenseMenuClicked(){
        LOG.log(Level.INFO, "License clicked");

        Alert license = new Alert(Alert.AlertType.INFORMATION);
        license.setTitle(this.resources.getString(ResourceNames.LICENSE));
        license.setHeaderText(this.resources.getString(ResourceNames.LICENSE));
        license.setContentText(this.resources.getString(ResourceNames.LICENSE_DATA));
        license.showAndWait();
    }


    /**
     * Private method to add a List of {@link MenuItem}s to a {@link Menu}.
     *
     * @param menu       The {@link Menu} that we want to add the {@code MenuItem}s to
     * @param items      A {@code List<MenuItem>} that contains all the {@code MenuItem}s to add
     *                   to the {@code Menu}
     */
    private void addMenuItems(Menu menu, List<MenuItem> items){
        try {
            for (MenuItem item : items) {
                this.addMenuItem(menu, item);
            }
        }catch (Exception ex){
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Private method to add a {@link MenuItem} to a {@link Menu}.
     *
     * @param menu  The {@code Menu} we want to add the {@code MenuItem} to.
     * @param item  The {@code MenuItem} to be added to the {@code Menu}.
     */
    private void addMenuItem(Menu menu, MenuItem item){

        if(item == this.closeMenu){
            item.setText(this.resources.getString(ResourceNames.MENU_CLOSE_ITEM));
            item.setOnAction(event -> this.closeMenuClicked());
            menu.getItems().add(item);
        }

        else if(item == this.aboutMenu){
            item.setText(this.resources.getString(ResourceNames.MENU_ABOUT_ITEM));
            item.setOnAction(event -> this.aboutMenuClicked());
            menu.getItems().add(item);
        }

        else if(item == this.licenseMenu){
            item.setText(this.resources.getString(ResourceNames.MENU_LICENSE_ITEM));
            item.setOnAction(event -> this.licenseMenuClicked());
            menu.getItems().add(item);
        }

    }


    private void setUpMenus(){
        this.fileMenu.setText(this.resources.getString(ResourceNames.MENU_FILE));
        this.editMenu.setText(this.resources.getString(ResourceNames.MENU_EDIT));
        this.helpMenu.setText(this.resources.getString(ResourceNames.MENU_HELP));
    }



    private void setSystemMenu() {

        this.menuBar.setUseSystemMenuBar(OSValidator.IS_MAC || OSValidator.IS_WINDOWS);

        if(OSValidator.IS_MAC){
            this.setMac(true);
            this.menuBar.getMenus().removeAll(this.fileMenu);
        }

        this.menuBar.prefWidthProperty().bind(Main.primaryStage.widthProperty());


    }

}
