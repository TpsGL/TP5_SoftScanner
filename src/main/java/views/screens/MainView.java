package views.screens;

import views.places.kernels.Place;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");

    Presenter presenter;

    public MainView() {
        container.setLayout(null);
        userLabel.setBounds(50,150,100,30);
        container.add(userLabel);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public interface Presenter{
        public void goTo(Place place);

    }
}
