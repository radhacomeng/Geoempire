package lv.molssoft.geoempire.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lv.molssoft.geoempire.R;

/**
 * Created by Creators Corp 9 on 21/8/2018.
 */

public class FragmentGeneral extends Fragment {

    public static FragmentGeneral getInstance() {
        FragmentGeneral fragmentGeneral = new FragmentGeneral();
        return fragmentGeneral;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_general, null);
        return v;
    }
}
