package kz.djunglestones.kazakhtelecom;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JavaScriptInterface {

    Context mContext;

    /** Instantiate the interface and set the context */
    JavaScriptInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void onObjectSelected(String toast) {
        Log.d("onObjectSelected: ", "Toast "+toast);
    }
}
