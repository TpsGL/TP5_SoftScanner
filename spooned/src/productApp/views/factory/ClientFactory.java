package productApp.views.factory;
import productApp.views.screens.LoginView;
import productApp.views.screens.ProductsView;
public interface ClientFactory {
    LoginView getLoginView();

    ProductsView getMainView();
}