import android.app.Application;

import com.parse.Parse;

/**
 * Created by mimo-android on 2015/8/15.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "GGtET1gfeRFGu6BhW8OEhP6nLb9nZ79maJDaxXrE", "0rLkRTr7RVt58nVe9GUOFTemVCR2cqiHRqFGI3iS");

    }
}
