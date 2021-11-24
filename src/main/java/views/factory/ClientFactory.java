package views.factory;


import views.screens.LoginView;
import views.screens.ProductsView;

public interface ClientFactory {

    LoginView getLoginView();

    ProductsView getMainView();
}
