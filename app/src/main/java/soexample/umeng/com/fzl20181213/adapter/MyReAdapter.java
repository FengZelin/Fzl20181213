package soexample.umeng.com.fzl20181213.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import soexample.umeng.com.fzl20181213.R;
import soexample.umeng.com.fzl20181213.bean.Bean;
import soexample.umeng.com.fzl20181213.utils.Http2Utils;

/**
 * date:2018/12/13
 * author:冯泽林(asus)
 * function:
 */
public class MyReAdapter extends RecyclerView.Adapter<MyReAdapter.ViewHodel> {
    private List<Bean.DataBean> list;
    private Context context;

    public MyReAdapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyReAdapter.ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view=View.inflate(context,,null);
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHodel hodel=new ViewHodel(view);
        return hodel;
    }

    @Override
    public void onBindViewHolder(@NonNull MyReAdapter.ViewHodel holder, int position) {

        holder.text_name.setText(list.get(position).getTitle());
        holder.text_price.setText(list.get(position).getPrice()+"");
        String images = list.get(0).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(Http2Utils.htt2utils(split[0])).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView text_name,text_price;
        public ViewHodel(View itemView) {
            super(itemView);
        image=itemView.findViewById(R.id.image);
        text_name=itemView.findViewById(R.id.text_name);
        text_price=itemView.findViewById(R.id.text_price);
        }
    }
}
