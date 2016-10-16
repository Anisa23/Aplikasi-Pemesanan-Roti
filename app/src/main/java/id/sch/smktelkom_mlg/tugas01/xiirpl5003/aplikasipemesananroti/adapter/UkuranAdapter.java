package id.sch.smktelkom_mlg.tugas01.xiirpl5003.aplikasipemesananroti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.tugas01.xiirpl5003.aplikasipemesananroti.R;

/**
 * Created by SATELLITE on 15/10/2016.
 */
public class UkuranAdapter extends ArrayAdapter<String>
{
    String mBentuk = "";
    public UkuranAdapter(Context context, ArrayList<String> listUkuran)
    {
        super(context, R.layout.row_spinner_ukuran, listUkuran);
    }

    public void setBentuk(String Bentuk) {
        this.mBentuk = Bentuk;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCostumerView(position, convertView, parent);
    }
    private View getCostumerView(int position, View view, ViewGroup parent)
    {

        if(view == null)
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_ukuran, parent, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0,1));
        TextView tvUkuran = (TextView) view.findViewById(R.id.textViewUkuran);
        tvUkuran.setText(getItem(position));
        TextView tvBentuk = (TextView) view.findViewById(R.id.textViewBentuk);
        tvBentuk.setText(mBentuk);

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCostumerView(position, convertView, parent);

    }
}

