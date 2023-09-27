package com.example.wear;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_one.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();//
        Bundle args = new Bundle();//
        // 存储参数
        args.putString(ARG_PARAM1, param1);//
        args.putString(ARG_PARAM2, param2);//
        fragment.setArguments(args);//
        return fragment;
    }

    /**
     *   (Fragment和Activity关联时)
     * 当 Fragment 被添加到 Activity 时，这个方法会被调用
     * @param context 用于获取 Activity 的上下文
     *
     * */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    /**
     * 当Fragment不可见时，这个方法会被调用
     * @param savedInstanceState 用于保存数据
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

     /**
      * 当Fragment可见时，这个方法会被调用
      * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    /**
     * 当Activity的onCreate方法执行完后调用
     * */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 当Fragment中的视图被移除时，这个方法会被调用
     * */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 当Fragment和Activity取消关联时，这个方法会被调用
     * */
    @Override
    public void onDetach() {
        super.onDetach();
    }
}