package views.screens;

import views.places.kernels.Place;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {


    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");
    JCheckBox showPassword = new JCheckBox("Show Password");


    Presenter presenter;


    public LoginView() {

        container.setLayout(null);
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public interface Presenter{

        public void goTo(Place place);
        public void loginButtonEvent();
    }


}
