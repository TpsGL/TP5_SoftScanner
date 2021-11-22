package views.places;

import views.places.kernels.Place;
import views.places.kernels.PlaceTokenizer;

public class LoginPlace extends Place {

    String name;

    public LoginPlace(String placeName){
        this.name = placeName;
    }

    public String getPlaceName() {
        return name;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

        @Override
        public LoginPlace getPlace(String token) {
            return new LoginPlace(token) ;
        }

        @Override
        public String getToken(LoginPlace place) {
            return place.getPlaceName();
        }
    }
}
