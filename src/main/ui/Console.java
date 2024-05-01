package main.ui;

import java.util.Scanner;

import main.presenter.Presenter;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    private boolean go;

    @Override
    public void start() {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go) {
            header();
            menuUi();
            System.out.print("Select a Menu item -> ");
            String command = scan.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Enter a number!");
            }
        }
    }

    private void header() {
        System.out.println("\nA program for working with the family tree");
    }

    private void menuUi() {
        System.out.println(menu.printMenu());
    }

    public void addHumanNew() {
        System.out.print("Enter a name-> ");
        String name = scan();
        System.out.print("Enter the gender (male/female)-> ");
        String sex = scan();
        System.out.print("Enter the age-> ");
        int age = Integer.parseInt(scan());
        presenter.addHumanNew(name, sex, age);
    }

    public void familyPrint() {
        presenter.familyPrint();
    }

    public void humanSearch() {
        System.out.print("Enter the name of the person to search for-> ");
        String name = scan();
        presenter.humanSearch(name);
    }

    public void saveFamily() {
        presenter.saveFamily();
    }

    public void loadFamily() {
        presenter.loadFamily();
    }

    public void sortFamilyName() {
        presenter.sortFamilyName();
    }

    public void sortFamilyAge() {
        presenter.sortFamilyAge();
    }

    public void end() {
        go = false;
        System.out.println("Thank you for using our service :D");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scan = new Scanner(System.in, "Cp866");
        return scan.nextLine();
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}