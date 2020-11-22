package verche.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;

public class ModDirectory {

    private PropertyChangeSupport propertyChangeSupport;
    private File directory;

    public ModDirectory() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File d) {
        var propertyChangeEvent = getPropertyChangeEvent(directory, d);
        directory = d;
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void firePropertyChange(File oldDirectory, File newDirectory) {
        var propertyChangeEvent = getPropertyChangeEvent(directory, directory);
        propertyChangeSupport.firePropertyChange(propertyChangeEvent);
    }

    private PropertyChangeEvent getPropertyChangeEvent(File oldDirectory, File newDirectory) {
        return new PropertyChangeEvent(this, "directory", oldDirectory, newDirectory);
    }
}
