package soexample.umeng.com.fzl20181213.model;

import java.lang.reflect.Type;

import soexample.umeng.com.fzl20181213.inter.ICallBack;
import soexample.umeng.com.fzl20181213.utils.HttpUtils;


/**
 * date:2018/12/10
 * author:冯泽林(asus)
 * function:
 */
public class Model {
    public void get(String url, ICallBack callBack, Type type){
        HttpUtils.getInsteren().get(url,callBack,type);
    }
}
