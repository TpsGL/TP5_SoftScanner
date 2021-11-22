package bootstrap;

import views.activities.kernels.ActivityMapper;
import views.factory.ClientFactory;
import views.factory.ClientFactoryImpl;
import views.mapper.MyActivityMapper;
import views.places.LoginPlace;

public class App implements EntryPoint{

    private LoginPlace welcomePlace = new LoginPlace("login");


    @Override
    public void onModuleLoad() {

        ClientFactory clientFactory = new ClientFactoryImpl();

        ActivityMapper activityMapper = MyActivityMapper.getInstance(clientFactory);

        activityMapper.getActivity(welcomePlace);

    }



}
