package kz.djunglestones.kazakhtelecom;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CustomJavaScriptInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    CustomJavaScriptInterface(Context c) {
        mContext = c;
    }


    /** retrieve the ids */
    public static void getIds(final String myIds) {
//        Log.d("Message", "getIds: "+myIds);
    }

}
