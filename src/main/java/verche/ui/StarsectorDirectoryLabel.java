package verche.ui;

import java.io.File;

import javafx.scene.control.Label;

public class StarsectorDirectoryLabel extends Label {

    public StarsectorDirectoryLabel(File directory) {
        super("Please select Starsector directory.");

        if (directory != null) {
            setText(directory);
        }
    }

    public void setText(File directory) {
        setText("Starsector directory: " + directory.getAbsolutePath());
    }
}
