package main.presenter;

import main.models.FamilyTree;
import main.models.Human;
import main.models.IO;
import main.models.comporator.HumanComporatorByAge;
import main.ui.View;

public class Presenter {
    private View view;
    private IO serialize;
    private FamilyTree<Human> familyConnect;
    private HumanComporatorByAge sortAge;

    public Presenter(View view, FamilyTree<Human> familyConnect, IO serialize, HumanComporatorByAge sortAge) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String sex, int age) {
        familyConnect.addFamilyTree(new Human(name, sex, age));
        view.print("A new family member has been added!");
    }

    public void familyPrint() {
        String family = familyConnect.toString();
        view.print(family);
    }

    public void humanSearch(String name) {
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("There is no such person in the family!");

        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }

    public void saveFamily() {
        familyConnect.saveObj(serialize);
        view.print("The family tree has been saved!");
    }

    public void loadFamily() {
        serialize.load("TreeFamily.data");
    }

    public void sortFamilyName() {
        familyConnect.getFamilyTree().sort(null);
        view.print("Sorting is complete!");
    }

    public void sortFamilyAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Sorting is complete!");
    }
}