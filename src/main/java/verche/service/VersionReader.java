package verche.service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

import verche.model.Mod;
import verche.model.ModList;
import verche.model.Version;

public class VersionReader extends JsonReader {

    private static final String VERSION_FILES = "/data/config/version_files.csv";

    public void addVersionInfo(ModList list) {
        for (Mod mod : list) {
            var localInputStream = getLocalStream(mod.getDirectory());
            var localVersion = getVersion(localInputStream);
            var remoteInputStream = getRemoteStream(localVersion.getRemoteLocation());
            var remoteVersion = getVersion(remoteInputStream);
            mod.setForumThread(localVersion.getForumThread());
            mod.setStatus(localVersion.getVersion(), remoteVersion.getVersion());
        }
    }

    private InputStream getLocalStream(String directory) {
        var localCsvFilePath = Path.of(directory, VERSION_FILES);
        if (!Files.isReadable(localCsvFilePath)) {
            return InputStream.nullInputStream();
        }
        // TODO
        // fetch location of local version from local csv file
        // read from location
        return InputStream.nullInputStream();
    }

    private InputStream getRemoteStream(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            return connection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
            return InputStream.nullInputStream();
        }
    }

    private Version getVersion(InputStream inputStream) {
        Version version;
        try {
            version = objectMapper.readValue(inputStream, Version.class);
        } catch (Exception e) {
            version = new Version();
            e.printStackTrace();
        }
        return version;
    }
}
