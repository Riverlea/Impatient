package Four;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/20 15:59
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloWorld extends Application {
    public void start(Stage stage) {
        Label message = new Label("Hello, JavaFX!");
        message.setFont(new Font(100));
        stage.setScene(new Scene(message));
        stage.setTitle("Hello");
        stage.show();
    }
}
