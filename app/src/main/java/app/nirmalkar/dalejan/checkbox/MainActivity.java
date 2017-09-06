package app.nirmalkar.dalejan.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> arrayList=new ArrayList<String>();
    Button button;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.checklist);
        button= (Button) findViewById(R.id.showselect);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        String[] items={"English","Hindi","Telgu","French","Italian"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.rowlayout,R.id.text_len,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecteditems=((TextView)view).getText().toString();
                if (arrayList.contains(selecteditems)){
                    arrayList.remove(selecteditems);
                }
                else {
                    arrayList.add(selecteditems);
                }
            }
        });
    }
    public void showselecteditem(View view){
        String item="";
        for (String item1:arrayList){
            item+=": :"+item1;
        }
        Toast.makeText(this, "Selected Items are"+item, Toast.LENGTH_SHORT).show();
    }
}
