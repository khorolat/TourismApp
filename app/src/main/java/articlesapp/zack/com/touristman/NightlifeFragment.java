package articlesapp.zack.com.touristman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.

 */
public class NightlifeFragment extends Fragment {

    public static final String NAME = "Nightlife";
    private ListAdapter nightlifeAdapter;

    EditText editTextName;
    EditText editTextAddress;
    Button buttonAdd;

    DatabaseReference databaseNightlife;

    ListView listViewNightlife;

    ArrayList<Nightlife> nightlifeList;


    public NightlifeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nightlife, container, false);
        databaseNightlife = FirebaseDatabase.getInstance().getReference("nightlife");

        editTextName = (EditText) v.findViewById(R.id.editTextName);
        editTextAddress = (EditText) v.findViewById(R.id.editTextAdress);
        buttonAdd = (Button) v.findViewById(R.id.buttonAdd);

        listViewNightlife = (ListView) v.findViewById(R.id.listViewNightlife);

        nightlifeList = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNightlifeFragment();

            }
        });
        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseNightlife.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                nightlifeList.clear();


                for (DataSnapshot nightlifeSnapshot : dataSnapshot.getChildren()){
                    Nightlife night = nightlifeSnapshot.getValue(Nightlife.class);

                    nightlifeList.add(night);
                }

                NightlifeAdapter adapter = new NightlifeAdapter(getActivity(),nightlifeList);
                listViewNightlife.setAdapter(adapter);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addNightlifeFragment() {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            databaseNightlife.push().getKey();

            String id = databaseNightlife.push().getKey();

            Restaurant restaurant = new Restaurant(id, name, address);
            databaseNightlife.child(id).setValue(restaurant);

            Toast.makeText(getActivity(), "Nightlife added", Toast.LENGTH_LONG);

        }else {
            Toast.makeText(getActivity(), "You should enter a name", Toast.LENGTH_SHORT);
        }

    }

}
