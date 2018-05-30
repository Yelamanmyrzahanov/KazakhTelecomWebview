package kz.djunglestones.kazakhtelecom;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class PortalFragment extends Fragment {

    public PortalFragment() {
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
//
//    private WebView mWebView;
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        mWebView.saveState(outState);
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mWebView.restoreState(savedInstanceState);
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View v=inflater.inflate(R.layout.fragment_portal, container, false);
//        mWebView = (WebView) v.findViewById(R.id.portal_webview);
//
//        // Enable Javascript
//        WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.loadUrl("https://isased.telecom.kz/SKYDOCS/SkyDocs.nsf");
//        mWebView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK
//                        && event.getAction() == MotionEvent.ACTION_UP
//                        && mWebView.canGoBack()) {
//                    handler.sendEmptyMessage(1);
//                    return true;
//                }
//                return false;
//            }
//        });
//
//
//
//        return v;
//    }

    private WebView webView;
    private Bundle webViewBundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ll = inflater.inflate(R.layout.fragment_portal,
                container, false);

        webView = ll.findViewById(R.id.portal_webview);
        webView.setWebViewClient(new WebViewClient());


        if (webViewBundle == null) {
            webView.loadUrl("https://isased.telecom.kz/SKYDOCS/SkyDocs.nsf");
        } else {
            webView.restoreState(webViewBundle);
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

        webViewBundle = new Bundle();
        webView.saveState(webViewBundle);
    }




}
