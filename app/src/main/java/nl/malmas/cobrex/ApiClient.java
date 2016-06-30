package nl.malmas.cobrex;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by Almas on 20-6-2016.
 */
public class ApiClient {
    private static AsyncHttpClient ourInstance = new AsyncHttpClient();
    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }
}
