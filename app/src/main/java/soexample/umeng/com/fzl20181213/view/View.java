package soexample.umeng.com.fzl20181213.view;

import android.content.Context;

/**
 * date:2018/12/10
 * author:冯泽林(asus)
 * function:
 */
public interface View<T> {
    void success(T t);
    void failed(Exception e);
}
