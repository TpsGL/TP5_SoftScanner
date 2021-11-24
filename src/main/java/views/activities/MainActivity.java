package views.activities;

import views.activities.kernels.Activity;
import views.factory.ClientFactory;
import views.places.MainPlace;
import views.places.kernels.Place;
import views.screens.ProductsView;

import javax.swing.*;

public class MainActivity implements Activity, ProductsView.Presenter {

    ClientFactory factory;

    String name;

    ProductsView productsView;

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

        productsView = factory.getMainView();


        productsView.setTitle("Crud Product");

        productsView.setVisible(true);
        productsView.setBounds(590,120,800,600);

        productsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productsView.setResizable(true);

        productsView.setPresenter(this);

        bindEvents();
    }

    private void bindEvents() {

    }

    @Override
    public void goTo(Place place) {

    }
}
