package main.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.models.comporator.AnimalIterator;

public class FamilyTree<T extends Animal> implements Iterable<T>, Serializable {
    private List<T> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addFamilyTree(T human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
    }

    @Override
    public String toString() {
        String res = "At famiy" + familyTree.size() + " human:\n";
        for (int i = 0; i < familyTree.size(); i++) {
            res += (i + 1) + ") " + familyTree.get(i).toString() + "\n";
        }
        return res;
    }

    public T getByName(String humanName) {
        for (T human : familyTree) {
            if (human.getName().equalsIgnoreCase(humanName)) {
                return human;
            }
        }
        return null;
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new AnimalIterator<T>(familyTree);
    }

    public void saveObj(IO save) {
        save.save("FamilyTree.data", this);
    }
}