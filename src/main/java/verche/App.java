package verche;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import verche.model.ModDirectory;
import verche.model.ModList;
import verche.service.ModReader;
import verche.ui.ModTableView;
import verche.ui.TopToolBar;

public class App extends Application {

    private ModDirectory modDirectory;
    private ModList modList;
    private ModReader reader;

    public App() {
        modDirectory = new ModDirectory();
        modList = new ModList();
        reader = new ModReader();
    }

    @Override
    public void start(Stage stage) {
        var toolBar = new TopToolBar(stage, modDirectory);
        var tableView = new ModTableView(modList);
        var borderPane = new BorderPane();
        var scene = new Scene(borderPane, 800, 600);

        borderPane.setTop(toolBar);
        borderPane.setCenter(tableView);

        modDirectory.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                var dir = modDirectory.getDirectory();
                toolBar.getLabel().setText(dir.getAbsolutePath());
                reader.read(dir, modList);
            }
        });

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
