package cn.bobo.budejie.pro.mine.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import cn.bobo.budejie.R;

import cn.bobo.budejie.bean.UserBean;
import cn.bobo.budejie.mvp.presenter.impl.MvpBaseaPresenter;
import cn.bobo.budejie.pro.base.presenter.BasePresener;
import cn.bobo.budejie.pro.base.view.BaseActivity;
import cn.bobo.budejie.pro.mine.presenter.LoginPresenter;
import cn.bobo.budejie.pro.mine.view.navigation.LoginNavigationBuilder;
import cn.bobo.budejie.utils.ToastUtil;

/**
 * Created by Leon on 2018/9/24.
 * Functions:
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private LoginPresenter loginPresenter;
    private EditText et_phone;
    private EditText et_password;


    @Override
    public MvpBaseaPresenter bindPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolBar();
        initView();
    }

    private void initToolBar(){
       LinearLayout ll_login = (LinearLayout)findViewById(R.id.ll_login);
        LoginNavigationBuilder builder = new LoginNavigationBuilder(LoginActivity.this);
        builder.setLeftIcon(R.drawable.login_close_selector)
                .setTitle(R.string.login_and_register_text)
                .setLeftIconOnClickLisener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        builder.createAndBind(ll_login);
    }

    private void initView(){
         et_phone = (EditText)findViewById(R.id.et_phone);
         et_password = (EditText)findViewById(R.id.et_password);
         findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        loginPresenter.login(et_phone.getText().toString(), et_password.getText().toString(),
                new BasePresener.OnUIThreadListener<UserBean>() {
            @Override
            public void onResult(UserBean result) {
                if (result == null){
                    ToastUtil.showToast(LoginActivity.this,"登陆失败!");
                }else {
                   // ToastUtil.showToast(LoginActivity.this,"登陆成功");
                    ToastUtil.showToast(LoginActivity.this,"code:"+
                            String.valueOf(result.getCode())+" message:"+result.getMessage());
                }
            }
        });
    }
}
