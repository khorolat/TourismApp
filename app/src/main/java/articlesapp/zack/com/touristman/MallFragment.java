package articlesapp.zack.com.touristman;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import java.util.List;


/**
 * A simple {@link Fragment} subclass.

 */
public class MallFragment extends Fragment {

    public static final String NAME = "Mall";
    private ListAdapter tourAdapter;
    EditText editTextName;
    EditText editTextAddress;
    Button buttonAdd;

    DatabaseReference databaseMalls;

    ListView listViewMall;

    List<Malls> mallList;


    public MallFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mall, container, false);
        databaseMalls = FirebaseDatabase.getInstance().getReference("mall");

        editTextName = (EditText) v.findViewById(R.id.editTextName);
        editTextAddress = (EditText) v.findViewById(R.id.editTextAdress);
        buttonAdd = (Button) v.findViewById(R.id.buttonAdd);

        listViewMall = (ListView) v.findViewById(R.id.listViewMall);

        mallList = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMall();

            }
        });
        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseMalls.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mallList.clear();


                for (DataSnapshot mallSnapshot : dataSnapshot.getChildren()){
                    Malls mall = mallSnapshot.getValue(Malls.class);

                    mallList.add(mall );
                }

                TourAdapter adapter = new TourAdapter(getActivity(), mallList);
                listViewMall.setAdapter(adapter);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addMall() {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            databaseMalls.push().getKey();
            String id = databaseMalls.push().getKey();

            Malls mall = new Malls(id, name, address);
            databaseMalls.child(id).setValue(mall);

            Toast.makeText(getActivity(), "Mall added", Toast.LENGTH_LONG);

        }else {
            Toast.makeText(getActivity(), "You should enter a name", Toast.LENGTH_SHORT);
        }

    }

}
