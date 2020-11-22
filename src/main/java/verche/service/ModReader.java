package verche.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import verche.model.Mod;
import verche.model.ModList;
import verche.model.ModPojo;

public class ModReader extends JsonReader {

    private static final String BROKEN_MOD = "BROKEN";
    private static final String MOD_INFO_JSON = "mod_info.json";

    public void read(File dir, ModList list) {
        list.clear();

        try (Stream<Path> walker = Files.list(dir.toPath())) {
            List<String> paths = walker.filter(Files::isDirectory).map(x -> x.toString()).collect(Collectors.toList());
            parseMods(list, paths);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseMods(ModList list, List<String> paths) {
        for (String path : paths) {
            var modJson = Path.of(path, MOD_INFO_JSON);
            if (!Files.isReadable(modJson)) {
                continue;// not a valid mod
            }
            var mod = parseModInfo(modJson);
            list.add(mod);
        }
    }

    private Mod parseModInfo(Path path) {
        ModPojo modPojo;
        try {
            modPojo = objectMapper.readValue(path.toFile(), ModPojo.class);
        } catch (Exception e) {
            modPojo = new ModPojo(path.getParent().getFileName().toString(), BROKEN_MOD);
            e.printStackTrace();
        }
        return new Mod(path.toFile().getParent(), modPojo);
    }
}
