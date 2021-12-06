package productApp.views.mapper;
import productApp.entities.User;
import productApp.views.activities.LoginActivity;
import productApp.views.activities.MainActivity;
import productApp.views.activities.kernels.Activity;
import productApp.views.activities.kernels.ActivityMapper;
import productApp.views.factory.ClientFactory;
import productApp.views.places.LoginPlace;
import productApp.views.places.MainPlace;
import productApp.views.places.kernels.Place;
public class MyActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    private MyActivityMapper(ClientFactory factory) {
        this.clientFactory = factory;
    }

    private static MyActivityMapper instance;

    public static MyActivityMapper getInstance(ClientFactory factory) {
        if (instance == null) {
            instance = new MyActivityMapper(factory);
        }
        return instance;
    }

    @Override
    public Activity getActivity(Place place, User user) {
        if (place instanceof LoginPlace) {
            return new LoginActivity(((LoginPlace) (place)), clientFactory);
        } else if (place instanceof MainPlace) {
            return new MainActivity(((MainPlace) (place)), clientFactory, user);
        }
        return null;
    }
}