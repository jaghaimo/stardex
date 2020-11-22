package verche.model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ModifiableObservableListBase;

public class ModList extends ModifiableObservableListBase<Mod> {

    private List<Mod> delegate;

    public ModList() {
        delegate = new ArrayList<Mod>();
    }

    @Override
    public Mod get(int index) {
        return delegate.get(index);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    protected void doAdd(int index, Mod element) {
        delegate.add(index, element);
    }

    @Override
    protected Mod doSet(int index, Mod element) {
        return delegate.set(index, element);
    }

    @Override
    protected Mod doRemove(int index) {
        return delegate.remove(index);
    }
}
