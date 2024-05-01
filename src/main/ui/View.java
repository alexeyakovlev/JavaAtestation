package main.ui;

import main.presenter.Presenter;
public interface View {
    void setPresenter(Presenter presenter);

    void start();

    void print(String text);

    String scan();
}