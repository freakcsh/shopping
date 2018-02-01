package com.freak.shopping.activity.official;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/28.
 */

public class OfficialCommentFragment extends Fragment {
    @BindView(R.id.official_comment_bq)
    ImageView officialCommentBq;
    @BindView(R.id.official_comment_edt)
    EditText officialCommentEdt;
    @BindView(R.id.official_comment_send)
    TextView officialCommentSend;
    Unbinder unbinder;
    @BindView(R.id.official_comment_list)
    ListView officialCommentList;
    private List<OfficialCommentBean> beanList;
    private int num = 1;
    private Calendar calendar;
    OfficialCommentAdapter commentAdapter ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View comment = inflater.inflate(R.layout.official_comment_fragment, container, false);
        unbinder = ButterKnife.bind(this, comment);
        return comment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        commentAdapter = new OfficialCommentAdapter(getActivity(), beanList);
//        getList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.official_comment_bq, R.id.official_comment_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.official_comment_bq:
                break;
            case R.id.official_comment_send:
//                commentAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void getList() {
        beanList=new ArrayList<>();
        OfficialCommentBean bean = new OfficialCommentBean();
        calendar = Calendar.getInstance();
        String time = calendar.get(Calendar.MONTH) + "月" + calendar.get(Calendar.DATE) + "日";
        bean.setComment_time(time);
        for (int i = 1; i <= num; i++) {
            beanList.add(new OfficialCommentBean(
                    R.drawable.tx,
                    "恋恋baby",
                    bean.getComment_time(),
                    officialCommentEdt.getText().toString()
            ));
        }

        officialCommentList.setAdapter(commentAdapter);
        commentAdapter.notifyDataSetChanged();
        num++;
    }
}
