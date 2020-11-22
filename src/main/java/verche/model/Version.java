package verche.model;

public class Version {

    private int forumThread;
    private int[] version;
    private String remoteLocation;

    public Version() {
    }

    public Version(int forumThread, int[] version, String remoteLocation) {
        this.forumThread = forumThread;
        this.version = version;
        this.remoteLocation = remoteLocation;
    }

    public int getForumThread() {
        return forumThread;
    }

    public int[] getVersion() {
        return version;
    }

    public String getRemoteLocation() {
        return remoteLocation;
    }
}
