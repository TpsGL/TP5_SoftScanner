package productApp.bootstrap;

import productApp.entities.User;
import productApp.views.activities.kernels.ActivityMapper;
import productApp.views.factory.ClientFactory;
import productApp.views.factory.ClientFactoryImpl;
import productApp.views.mapper.MyActivityMapper;
import productApp.views.places.LoginPlace;

public class App implements EntryPoint{

    private LoginPlace welcomePlace = new LoginPlace("login");


    @Override
    public void onModuleLoad() {

        ClientFactory clientFactory = new ClientFactoryImpl();

        ActivityMapper activityMapper = MyActivityMapper.getInstance(clientFactory);

        activityMapper.getActivity(welcomePlace, new User());

    }



}
