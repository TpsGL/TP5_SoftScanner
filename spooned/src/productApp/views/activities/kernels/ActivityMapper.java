package productApp.views.activities.kernels;
import productApp.entities.User;
import productApp.views.places.kernels.Place;
public interface ActivityMapper {
    /**
     * Returns the activity to run for the given {@link Place}, or null.
     *
     * @param place
     * 		a Place object
     */
    Activity getActivity(Place place, User user);
}