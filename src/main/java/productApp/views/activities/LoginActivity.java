package productApp.views.activities;

import productApp.entities.User;
import productApp.repository.UserRepository;
import productApp.strategy.InMemoryStrategy;
import productApp.views.activities.kernels.Activity;
import productApp.views.factory.ClientFactory;
import productApp.views.mapper.MyActivityMapper;
import productApp.views.places.LoginPlace;
import productApp.views.places.MainPlace;
import productApp.views.places.kernels.Place;
import productApp.views.screens.LoginView;
import productApp.views.validator.IValidator;
import productApp.views.validator.ValidatorImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginActivity implements Activity,LoginView.Presenter {

    ClientFactory factory;

    String name;

    LoginView view;

    IValidator iValidator = new ValidatorImpl();

    UserRepository userRepository = UserRepository.getInstance();

    String username;

    String email;

    int age;

    String password;

    public LoginActivity(LoginPlace loginPlace, ClientFactory clientFactory) {
        this.factory = clientFactory;
        this.name = loginPlace.getPlaceName();
        userRepository.init(new InMemoryStrategy<User>());
        start();
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
    public void goTo(Place place, User user) {
        view.setVisible(false);
        MyActivityMapper.getInstance(factory).getActivity(place, user);
    }

    @Override
    public void loginButtonEvent() {
        view.getLoginButton().addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == view.getLoginButton()) {
                            checkYourItem();

                            User user = new User();

                            user.setUserName(username);
                            user.setAge(age);
                            user.setEmail(email);
                            user.setPassword(password);
                            userRepository.add(user);

                           // System.out.println(user.toString());

                            goTo(new MainPlace("MainPlace"), user);
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


        username = view.getUserTextField().getText();
        iValidator.isValidStr(username,"[A-Za-z0-9_]+" );


        email = view.getEmailField().getText();
        iValidator.isValidStr(email, "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");

        password = view.getPasswordField().getText();

        String str = view.getAgeField().getText();
        age = iValidator.isNumeric(str, 120);

    }

}
