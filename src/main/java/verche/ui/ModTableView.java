package verche.ui;

import java.util.Arrays;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import verche.model.Mod;
import verche.model.ModList;

public class ModTableView extends TableView<Mod> {

    public ModTableView(ModList modList) {
        super(modList);

        var name = new TableColumn<Mod, String>("Name");
        var version = new TableColumn<Mod, String>("Version");
        var forumLink = new TableColumn<Mod, String>("Forum Link");
        var status = new TableColumn<Mod, String>("Status");

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        version.setCellValueFactory(new PropertyValueFactory<>("version"));
        forumLink.setCellValueFactory(new PropertyValueFactory<>("forumLink"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        getColumns().setAll(Arrays.asList(name, version, forumLink, status));
    }
}
