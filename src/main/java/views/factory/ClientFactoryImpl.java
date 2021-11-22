package views.factory;

import views.screens.LoginView;
import views.screens.MainView;

public class ClientFactoryImpl implements ClientFactory{

    LoginView loginView = new LoginView();

    MainView mainView = new MainView();

    @Override
    public LoginView getLoginView() {
        return loginView;
    }

    @Override
    public MainView getMainView() { return mainView; }
}
