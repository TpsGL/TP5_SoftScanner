package views.mapper;

import views.activities.MainActivity;
import views.activities.kernels.Activity;
import views.activities.kernels.ActivityMapper;
import views.activities.LoginActivity;
import views.factory.ClientFactory;
import views.places.LoginPlace;
import views.places.MainPlace;
import views.places.kernels.Place;

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
    public Activity getActivity(Place place) {

        if (place instanceof LoginPlace) {

            System.out.println("LoginPlace");

            return new LoginActivity((LoginPlace) place, clientFactory);

        } else if (place instanceof MainPlace) {

            System.out.println("MainPlace");

            return new MainActivity((MainPlace) place, clientFactory);
        }

        return null;
    }
}
