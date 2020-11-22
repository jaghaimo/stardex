package verche.ui;

import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.material.Material;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import verche.model.ModDirectory;

public class TopToolBar extends ToolBar {

    private Label label;
    private ModDirectory directory;

    public TopToolBar(Stage stage, ModDirectory d) {
        super();
        directory = d;

        addDirButton(stage);
        addRefreshButton();
        addSpacer();
        addLabel();
    }

    public Label getLabel() {
        return label;
    }

    private void addDirButton(Stage stage) {
        var button = new Button("", new FontIcon(Material.FOLDER_OPEN));

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                var dirChooser = new DirectoryChooser();
                var dir = dirChooser.showDialog(stage);

                if (dir != null) {
                    directory.setDirectory(dir);
                }
            }
        });

        getItems().add(button);
    }

    private void addRefreshButton() {
        var button = new Button("", new FontIcon(Material.REFRESH));

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                directory.firePropertyChange(directory.getDirectory(), directory.getDirectory());
            }
        });

        getItems().add(button);
    }

    private void addSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        getItems().add(spacer);
    }

    private void addLabel() {
        label = new Label("No folder selected");
        getItems().add(label);
    }
}
