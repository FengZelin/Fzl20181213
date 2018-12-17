package soexample.umeng.com.fzl20181213.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.fzl20181213.R;
import soexample.umeng.com.fzl20181213.adapter.MyReAdapter;
import soexample.umeng.com.fzl20181213.bean.Bean;
import soexample.umeng.com.fzl20181213.presenter.Presenter;

public class SalesFragment extends Fragment implements soexample.umeng.com.fzl20181213.view.View<Bean> {
    private List<Bean.DataBean> list;
    private RecyclerView recycler;
    private MyReAdapter adapter;
    private Presenter presenter;
    private  List<Bean.DataBean> mList=new ArrayList<>();
    private ImageView image;
    String url="http://www.zhaoapi.cn/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_sales_fragment, null);
        initView(view);
        show();
        return view;
    }

    private void show() {
        presenter = new Presenter();
        presenter.attch(this);
        presenter.get(url);
        Toast.makeText(getActivity(),url+"",Toast.LENGTH_SHORT).show();
        list=new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);

    }

    private void initView(View view) {
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        image = getActivity().findViewById(R.id.image_qh);
    }

    @Override
    public void success(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        adapter = new MyReAdapter(data, getActivity());
        recycler.setAdapter(adapter);

        if(data!=null){
            list.clear();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failed(Exception e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.delete();
    }
}
