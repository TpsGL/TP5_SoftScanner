package views.activities.kernels;

public interface Activity {

    /**
     * Called when the user is trying to navigate away from this activity.
     *
     * @return A message to display to the user, e.g. to warn of unsaved work, or
     *         null to say nothing
     */
    String mayStop();

    /**
     * Called when {@link #start} has not yet replied to its callback, but the
     * user has lost interest.
     */
    void onCancel();

    /**
     * Called when the Activity's widget has been removed from view. All event
     * handlers it registered will have been removed before this method is called.
     */
    void onStop();

    /**
     * Called when the Activity should ready its widget for the user. When the
     * widget is ready (typically after an RPC response has been received),
     * receiver should present it by calling
     * <p>
     * Any handlers attached to the provided event bus will be de-registered when
     * the activity is stopped, so activities will rarely need to hold on to the
     *
     */
    void start();
}
