package sample.Services;


/**
 * Public class that hold the name of the {@code FXML} files
 *
 * <p>This class only contains static final {@code Strings} and as such the only way
 * to access the attributes in this group are {@code FXMLViews.X} where X
 * is the name of the view you want to access
 * </p>
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
public final class FXMLViews {

    public class Id {
        /**
         * Public static final {@code String} to hold the id of the {@code FXMLViews#MAIN_FILE}
         */
        public static final String MAIN = "main";

        /**
         * Public static final {@code String} to hold the id of the {@code FXMLViews#ABOUT_FILE}
         */
        public static final String ABOUT = "aboutID";

        /**
         * Public static final {@code String} to hold the id of the {@code FXMLViews#INPUT_GROUP_FILE}
         */
        public static final String INPUT_GROUP= "inputGroup";

        /**
         * Public static final {@code String} to hold the id of the {@code FXMLViews#INPUT_LABELS_FILE}
         */
        public static final String INPUT_LABELS = "inputLabels";

        /**
         * Public static final {@code String} to hold the id of the {@code FXMLViews#MENU_FILE}
         */
        public static final String MENU = "menu";

        public static final String OUTPUT_OPTIONS_ID = "outputOptions";

    }


    public class Files{
        /**
         * Public Static final {@code String} to access the {@code main.fxml} file
         */
        public static final String MAIN = "FXML_files/main.fxml";


        /**
         * Public Static final {@code String} to access the {@code about.fxml} file
         */
        public static final String ABOUT = "FXML_files/about.fxml";



        /**
         * Public Static final {@code String} to access the {@code input_group.fxml} file
         */
        public static final String INPUT_GROUP = "FXML_files/input_group.fxml";


        /**
         * Public Static final {@code String} to access the {@code type_labels.fxml} file
         */
        public static final String INPUT_LABELS = "FXML_files/input_labels.fxml";



        /**
         * Public static final {@code String} to access the {@code menu.fxml} file
         */
        public static final String MENU = "FXML_files/menu.fxml";

        public static final String OUTPUT_OPTIONS = "FXML_files/output_options.fxml";
    }

}
