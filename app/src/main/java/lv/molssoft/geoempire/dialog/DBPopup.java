package lv.molssoft.geoempire.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lv.molssoft.geoempire.R;

/**
 * Created by Creators Corp 9 on 21/8/2018.
 */

public class DBPopup extends DialogFragment {

    public static DBPopup newInstance() {
        DBPopup dbPopup = new DBPopup();
        return dbPopup;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View v = inflater.inflate(R.layout.dialog_popup, null);
        return v;
    }
}
