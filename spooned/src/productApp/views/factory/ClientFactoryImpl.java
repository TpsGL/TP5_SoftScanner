package productApp.views.factory;
import productApp.views.screens.LoginView;
import productApp.views.screens.ProductsView;
public class ClientFactoryImpl implements ClientFactory {
    LoginView loginView = new LoginView();

    ProductsView mainView = new ProductsView();

    @Override
    public LoginView getLoginView() {
        return loginView;
    }

    @Override
    public ProductsView getMainView() {
        return mainView;
    }
}