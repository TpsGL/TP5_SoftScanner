package views.activities;

import views.activities.kernels.Activity;
import views.factory.ClientFactory;
import views.mapper.MyActivityMapper;
import views.places.LoginPlace;
import views.places.MainPlace;
import views.places.kernels.Place;
import views.screens.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActivity implements Activity,LoginView.Presenter {

    ClientFactory factory;

    String name;

    LoginView view;

    public LoginActivity(LoginPlace loginPlace, ClientFactory clientFactory) {
        this.factory = clientFactory;
        this.name = loginPlace.getPlaceName();
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
        view = this.factory.getLoginView();

        view.setTitle("Login Form");
        view.setVisible(true);
        view.setBounds(10,10,370,600);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setResizable(false);

        view.setPresenter(this);
        bindEvents();

    }

    private void bindEvents() {
        loginButtonEvent();
    }

    @Override
    public void goTo(Place place) {
        view.setVisible(false);
        MyActivityMapper.getInstance(factory).getActivity(place);
    }

    @Override
    public void loginButtonEvent() {
        factory.getLoginView().getLoginButton().addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == factory.getLoginView().getLoginButton()) {
                            checkYourItem();
                            goTo(new MainPlace("MainPlace"));
                        }

                    }
                }
        );
    }

    public void checkYourItem() {
        System.out.println("Hello World !");
    }

}
