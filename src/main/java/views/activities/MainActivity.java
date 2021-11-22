package views.activities;

import views.activities.kernels.Activity;
import views.factory.ClientFactory;
import views.places.MainPlace;
import views.places.kernels.Place;
import views.screens.MainView;

import javax.swing.*;

public class MainActivity implements Activity, MainView.Presenter {

    ClientFactory factory;

    String name;

    MainView view;


    public MainActivity(MainPlace mainPlace, ClientFactory clientFactory) {
        this.factory = clientFactory;
        this.name = mainPlace.getPlaceName();
        start();
    }


    @Override
    public String mayStop() {
        return null;
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void start() {
        view = factory.getMainView();

        view.setTitle("Crud Product");
        view.setVisible(true);
        view.setBounds(10,10,370,600);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setResizable(false);

        view.setPresenter(this);
        bindEvents();
    }

    private void bindEvents() {

    }

    @Override
    public void goTo(Place place) {

    }
}
