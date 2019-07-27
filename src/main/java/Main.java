import db.BaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/Form.fxml"));
        Parent root = loader.load();
        primarystage.setResizable(false);
        primarystage.setTitle("User Form");
        Scene scene = new Scene(root);
        primarystage.setScene(scene);
        primarystage.show();
        Image icon = new Image(this.getClass().getResourceAsStream("icons/server.png"));
        primarystage.getIcons().add(icon);
        BaseManager.createDBTable();
    }
}
