package main;

import java.io.IOException;

import main.models.FamilyTree;
import main.models.Human;
import main.models.IO;
import main.models.comporator.HumanComporatorByAge;
import main.presenter.Presenter;
import main.ui.Console;
import main.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    FamilyTree<Human> familyTree = new FamilyTree<>();

    familyTree.addFamilyTree(new Human("Alexey", "male", 25));
    familyTree.addFamilyTree(new Human("Julia", "female", 25));
    familyTree.getByName("Alexey");

    View view = new Console();
    IO serialize = new IO();
    new Presenter(view, familyTree, serialize, sortAge);
    view.start();
    }
}
