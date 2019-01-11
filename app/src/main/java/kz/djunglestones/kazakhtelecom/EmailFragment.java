package kz.djunglestones.kazakhtelecom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment{
    public EmailFragment() {
        // Required empty public constructor
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:{
                    webViewGoBack();
                }break;
            }
        }
    };

    private void webViewGoBack() {
        webView.goBack();
    }

    private WebView webView;
    private Bundle webViewBundle1;
    private Button button;

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ll = inflater.inflate(R.layout.fragment_portal,
                container, false);

        webView = ll.findViewById(R.id.portal_webview);
        webView.setWebViewClient(new WebViewClient());
        button = ll.findViewById(R.id.buy_ticket);
        webView.addJavascriptInterface(new JavaScriptInterface(getContext()), "Android");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        if (webViewBundle1 == null) {
            webView.loadUrl("https://qel.mobi/test-2");
//            webView.getId();
        } else {
            webView.restoreState(webViewBundle1);
        }





        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && webView.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }
        });



        return ll;

    }

    @Override
    public void onPause() {
        super.onPause();

        webViewBundle1 = new Bundle();
        webView.saveState(webViewBundle1);
    }



//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.i("onStart: ", "onStart: ");
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.i("onResume: ", "onResume: ");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.i("onDestroy: ", "onDestroy: ");
//    }
}
