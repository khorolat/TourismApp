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

public class TourAdapter extends ArrayAdapter{


    private Activity context;
    private List<Malls> mallList;

    public TourAdapter(Activity context, List<Malls> mallList) {
        super(context,R.layout.list_layout,mallList);

        this.context = context;
        this.mallList = mallList;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Malls mall = mallList.get(position);


        titleTextView.setText(mall.getMallName());
        descTextView.setText(mall.getMallAddress());
        locTextView.setText(mall.getMallId());



        return listViewItem;

    }
}




