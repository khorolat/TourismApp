package articlesapp.zack.com.touristman;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 7/31/2017.
 */

public class NightlifeAdapter extends ArrayAdapter {


    private Activity context;
    private List<Nightlife> nightlifeList;

    public NightlifeAdapter(Activity context, List<Nightlife> nightlifeList) {
        super(context,R.layout.list_layout,nightlifeList);

        this.context = context;
        this.nightlifeList = nightlifeList;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Nightlife nightlife = nightlifeList.get(position);


        titleTextView.setText(nightlife.getNightlifeName());
        descTextView.setText(nightlife.getNightlifeAddress());
        locTextView.setText(nightlife.getNightlifeId());



        return listViewItem;

    }
}