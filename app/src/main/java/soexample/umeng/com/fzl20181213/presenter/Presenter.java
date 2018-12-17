package soexample.umeng.com.fzl20181213.presenter;




import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import soexample.umeng.com.fzl20181213.bean.Bean;
import soexample.umeng.com.fzl20181213.inter.ICallBack;
import soexample.umeng.com.fzl20181213.model.Model;
import soexample.umeng.com.fzl20181213.view.View;


/**
 * date:2018/12/10
 * author:冯泽林(asus)
 * function:
 */
public class Presenter {
    private View iv;
    private Model model;

    public void attch(View iv){
        this.iv=iv;
        model=new Model();
    }

    public void get(String url){
        Type type = new TypeToken<Bean>() {
        }.getType();
        model.get(url, new ICallBack() {
            @Override
            public void OnSuccess(Object o) {
                iv.success(o);
            }

            @Override
            public void OnFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void delete(){
        if(iv!=null){
            iv=null;
        }
    }
}
