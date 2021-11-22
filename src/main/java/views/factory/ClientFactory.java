package views.factory;


import views.screens.LoginView;
import views.screens.MainView;

public interface ClientFactory {

    LoginView getLoginView();

    MainView getMainView();
}
