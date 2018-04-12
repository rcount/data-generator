package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Services.OSValidator;


import java.util.logging.Logger;

/**
 * Public {@code MainController} for the {@code main.fxml} file that wires the {@code FXML} file to the
 * {@code Java} controller.
 *
 * <p>Copyright 2018 Stephen Vickers, Shane May</p>
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:</p>
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>
 *
 * @author Stephen Vickers
 */
public class MainController  {

    //TODO: Comment File.

    private static final Logger LOG = Logger.getLogger(MainController.class.getName());

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Pane menuPane;

    @FXML
    private Pane inputPane;

    private MenuController menu;

    private InputController input;

    /**
     * Public void initialize method. This method is automatically called by {@link FXMLLoader}
     */
    public void initialize(){
        this.menu = new MenuController();
        this.input = new InputController();

        this.setupMenu();
    }


    private void setupMenu(){

        if(OSValidator.IS_MAC){
            this.menuPane.setVisible(false);
            this.menuPane.setManaged(false);

            AnchorPane.setTopAnchor(this.scrollPane, 0.0);

        }else{

            AnchorPane.setTopAnchor(this.scrollPane, 25.0);
            this.mainPane = new AnchorPane();

        }
    }




}
