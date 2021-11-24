package views.factory;

import views.screens.LoginView;
import views.screens.ProductsView;

public class ClientFactoryImpl implements ClientFactory{

    LoginView loginView = new LoginView();

    ProductsView mainView = new ProductsView();

    @Override
    public LoginView getLoginView() {
        return loginView;
    }

    @Override
    public ProductsView getMainView() { return mainView; }
}
