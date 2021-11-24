package views.screens;

import views.places.kernels.Place;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {


    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel ageLabel = new JLabel("age");
    JLabel emailLabel = new JLabel("Password");
    JLabel passwordLabel = new JLabel("email");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField ageField = new JTextField();
    JTextField emailField = new JTextField();

    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");


    Presenter presenter;


    public LoginView() {

        setTitle("Login Form");
        setVisible(true);
        setBounds(590,120,400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        container.setLayout(null);

        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,200,100,30);
        ageLabel.setBounds(50, 250,100,30);
        emailLabel.setBounds(50, 300,100, 30);

        ageField.setBounds(150,150,150,30);
        emailField.setBounds(150,200,150,30);
        userTextField.setBounds(150,250,150,30);
        passwordField.setBounds(150,300,150,30);

        loginButton.setBounds(70,400,100,30);
        resetButton.setBounds(250,400,100,30);

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(ageLabel);
        container.add(emailLabel);
        container.add(ageField);
        container.add(emailField);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(resetButton);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public interface Presenter{

        public void goTo(Place place);
        public void loginButtonEvent();
        public void resetButtonEvent();
    }


}
