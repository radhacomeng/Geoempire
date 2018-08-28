package lv.molssoft.geoempire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lv.molssoft.geoempire.adapter.HomeRecyclerAdapter;
import lv.molssoft.geoempire.dialog.DBPopup;
import lv.molssoft.geoempire.fragments.FragmentGeneral;
import lv.molssoft.geoempire.fragments.FragmentHome;

public class ActivityHome extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.container)
    FrameLayout container;
    HomeRecyclerAdapter adapter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.tvBlueText)
    TextView tvBlueText;
    @BindView(R.id.tvOrangeText)
    TextView tvOrangeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);
        setUpActionBar();
        setLayoutManager();
        setDashBoardAdapter();
        replaceFragment(FragmentHome.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    void setUpActionBar() {
        tvUserName.setText(getResources().getString(R.string.user_name));
    }

    void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    void setDashBoardAdapter() {
        adapter = new HomeRecyclerAdapter(getResources().getStringArray(R.array.dashboard_data));
        recyclerview.setAdapter(adapter);
        adapter.setHomeClickListener(new HomeRecyclerAdapter.HomeClick() {
            @Override
            public void onAdapterClick(int position) {
                switch (position) {
                    case 0:
                        replaceFragment(FragmentHome.getInstance());
                        break;
                    case 1:
                        DBPopup dbPopup = DBPopup.newInstance();
                        dbPopup.show(getSupportFragmentManager(), "DIALOG_SHOW_POPUP");
                        break;
                    case 2:
                        replaceFragment(FragmentGeneral.getInstance());
                        break;
                    case 3:
                        replaceFragment(FragmentHome.getInstance());
                        break;
                }
            }
        });
    }

    void setLayoutManager() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}