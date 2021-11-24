package views.activities;

import views.activities.kernels.Activity;
import views.factory.ClientFactory;
import views.mapper.MyActivityMapper;
import views.places.LoginPlace;
import views.places.MainPlace;
import views.places.kernels.Place;
import views.screens.LoginView;
import views.validator.IValidator;
import views.validator.ValidatorImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity implements Activity,LoginView.Presenter {

    ClientFactory factory;

    String name;

    LoginView view;

    IValidator iValidator = new ValidatorImpl();

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
        view.setPresenter(this);
        bindEvents();

    }

    private void bindEvents() {
        loginButtonEvent();
        resetButtonEvent();
    }

    @Override
    public void goTo(Place place) {
        view.setVisible(false);
        MyActivityMapper.getInstance(factory).getActivity(place);
    }

    @Override
    public void loginButtonEvent() {
        view.getLoginButton().addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == view.getLoginButton()) {
                            checkYourItem();
                            goTo(new MainPlace("MainPlace"));
                        }

                    }
                }
        );
    }

    @Override
    public void resetButtonEvent() {

        view.getResetButton().addActionListener(

                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == view.getResetButton()) {
                            view.getPasswordField().setText("");
                            view.getAgeField().setText("");
                            view.getUserTextField().setText("");
                            view.getEmailField().setText("");
                        }
                    }
                }
        );
    }

    private void checkYourItem() {
        String username = view.getUserTextField().getText();
        iValidator.isValidStr(username,"[A-Za-z0-9_]+" );


        String email = view.getEmailField().getText();
        iValidator.isValidStr(email, "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");


        String str = view.getAgeField().getText();
        iValidator.isNumeric(str, 120.0);

    }

}
