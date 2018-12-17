package soexample.umeng.com.fzl20181213;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.fzl20181213.adapter.MyFragment;
import soexample.umeng.com.fzl20181213.fragment.SalesFragment;
import soexample.umeng.com.fzl20181213.fragment.SyntheticalFragment;

public class MainActivity extends FragmentActivity {

    private ImageView image_return;
    private EditText edit_seek;
    private ImageView image_qh;
    private List<Fragment> list;
    private RadioGroup radio;
    private ViewPager pager;
    private MyFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        list = new ArrayList<>();
        list.add(new SalesFragment());
        list.add(new SyntheticalFragment());
        fragment = new MyFragment(getSupportFragmentManager(), list);
        pager.setAdapter(fragment);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.but_one:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.but_two:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radio.check(radio.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        image_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        image_return = (ImageView) findViewById(R.id.image_return);
        edit_seek = (EditText) findViewById(R.id.edit_seek);
        image_qh = (ImageView) findViewById(R.id.image_qh);
        radio = (RadioGroup) findViewById(R.id.radio);
        pager = (ViewPager) findViewById(R.id.pager);
    }

}
