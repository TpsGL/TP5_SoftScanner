package views.places;

import views.places.kernels.Place;
import views.places.kernels.PlaceTokenizer;

public class MainPlace extends Place {


    String name;

    public MainPlace(String placeName) {
        this.name = placeName;
    }

    public String getPlaceName() {
        return name;
    }

    public void setPlaceName(String name) {
        this.name = name;
    }

    public static class Tokenizer implements PlaceTokenizer<MainPlace> {

        @Override
        public String getToken(MainPlace place) {
            return place.getPlaceName();
        }

        @Override
        public MainPlace getPlace(String token) {
            return new MainPlace(token);
        }
    }
}
