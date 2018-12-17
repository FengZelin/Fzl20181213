package soexample.umeng.com.fzl20181213.utils;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import soexample.umeng.com.fzl20181213.inter.ICallBack;

/**
 * date:2018/12/10
 * author:冯泽林(asus)
 * function:
 */
public class HttpUtils {
    private static volatile HttpUtils Insteren;
    private OkHttpClient client;
    private Handler handler=new Handler();

    private HttpUtils(){
        client=new OkHttpClient();
    }

    public static HttpUtils getInsteren(){
        if(Insteren==null){
            synchronized (HttpUtils.class){
                if(Insteren==null){
                    Insteren=new HttpUtils();
                }
            }
        }
        return Insteren;
    }
    public void get(String url, final ICallBack callBack, final Type type){
        Request build = new Request.Builder().get().url(url).build();
        final Call call = client.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.OnFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(s, type);
                Log.i("TAG",o+"");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.OnSuccess(o);
                    }
                });
            }

        });
    }
}
