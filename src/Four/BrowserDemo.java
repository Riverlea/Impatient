package Four;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/20 19:07
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class BrowserDemo extends Application {
    @Override public void start(Stage stage) {
        String location = "http://horstmann.com";
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load(location);
        Scene scene = new Scene(browser);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }

}
