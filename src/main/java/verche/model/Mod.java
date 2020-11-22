package verche.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mod {

    private String directory;
    private StringProperty name;
    private StringProperty version;
    private StringProperty status;
    private StringProperty forumLink;

    public Mod(String d, ModPojo m) {
        directory = d;
        setName(m.getName());
        setVersion(m.getVersion());
    }

    public String getDirectory() {
        return directory;
    }

    public String getName() {
        return nameProperty().get();
    }

    public void setName(String n) {
        nameProperty().set(n);
    }

    public StringProperty nameProperty() {
        if (name == null) {
            name = new SimpleStringProperty(this, "name");
        }

        return name;
    }

    public String getVersion() {
        return versionProperty().get();
    }

    public void setVersion(String n) {
        versionProperty().set(n);
    }

    public StringProperty versionProperty() {
        if (version == null) {
            version = new SimpleStringProperty(this, "version");
        }

        return version;
    }

    public String getStatus() {
        return statusProperty().get();
    }

    public void setStatus(int[] lt, int[] rt) {
        statusProperty().set(getStatusText(lt, rt));
    }

    public StringProperty statusProperty() {
        if (status == null) {
            status = new SimpleStringProperty(this, "status");
        }

        return status;
    }

    public String getForumLink() {
        return forumLinkProperty().get();
    }

    public void setForumThread(int threadId) {
        forumLinkProperty().set("https://fractalsoftworks.com/forum/index.php?topic=" + threadId);
    }

    public StringProperty forumLinkProperty() {
        if (forumLink == null) {
            forumLink = new SimpleStringProperty(this, "forumLink");
        }

        return forumLink;
    }

    private String getStatusText(int[] localVersion, int[] remoteVersion) {
        if (localVersion == null || localVersion.length != 3) {
            return "Mod does not support version checker";
        }

        if (remoteVersion == null || remoteVersion.length != 3) {
            return "Failed to fetch latest version";
        }

        if ((localVersion[0] < remoteVersion[0])
                || (localVersion[0] == remoteVersion[0] && localVersion[1] < remoteVersion[1])
                || (localVersion[0] == remoteVersion[0] && localVersion[1] == remoteVersion[1]
                        && localVersion[2] < remoteVersion[2])) {
            return "New version available";
        }

        return "Mod is up to date";
    }
}
