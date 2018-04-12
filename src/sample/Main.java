package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sample.Models.DataType;
import sample.Models.Interfaces.Generatable;
import sample.Models.Tablable;
import sample.Services.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.util.*;
import java.util.logging.Logger;


public class Main extends Application {


    //TODO: Figure out City and State output.

    private static Logger LOG = Logger.getLogger(Main.class.getName());

    private static final int DEFAULT_WIDTH = 650;

    private static final int DEFAULT_HEIGHT = 500;

    public static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{

        Main.setPrimaryStage(primaryStage);


        Parent root = FXMLLoader.load(getClass().getResource(FXMLViews.Files.MAIN));

        Main.getPrimaryStage().setTitle(
                ResourceBundle.getBundle(
                    ResourceNames.RESOURCE_BUNDLE)
                        .getString(
                            ResourceNames.APPLICATION_NAME));

        Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Main.getPrimaryStage().setScene(scene);
        Main.getPrimaryStage().show();


    }


    public static void main(String[] args) {


        launch(args);

    }

    public static <T> void print(T... values){
        //TODO: When we are done testing this can be deleted.
        for (T value : values){
            System.out.println(value);
        }
    }

    public static <T>void print(List<T> list){
        print(list.toArray());
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    private static void setPrimaryStage(Stage stage){
        primaryStage = stage;
    }

}
