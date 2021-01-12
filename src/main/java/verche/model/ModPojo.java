package verche.model;

public class ModPojo {

    private String name;
    private String version;

    public ModPojo() {
    }

    public ModPojo(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String v) {
        version = v;
    }
}
