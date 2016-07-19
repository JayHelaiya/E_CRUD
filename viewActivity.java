package nichetech.com.employeecrudproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class viewActivity extends AppCompatActivity {

    EmployeePojo pojo;
    Db_manager db_manager;
    ListView listView;
    TableRow tr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TableLayout tl = (TableLayout) findViewById(R.id.main_table);

        TableRow tr_head = new TableRow(this);
        tr_head.setBackgroundColor(Color.GRAY);
        tr_head.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        TextView label_Name = new TextView(this);
        label_Name.setText("Name");
        label_Name.setId(label_Name.getId());
        label_Name.setTextColor(Color.WHITE);
        label_Name.setPadding(5, 5, 5, 5);
        tr_head.addView(label_Name);// add the column to the table row here

        TextView label_SirName = new TextView(this);
        label_SirName.setId(label_SirName.getId());
        label_SirName.setText("Sir_name");
        label_SirName.setTextColor(Color.WHITE);
        label_SirName.setPadding(5, 5, 5, 5);
        tr_head.addView(label_SirName);
        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for (int current = 1; current < 3; current++) {


            tr= new TableRow(this);
            TextView labelName1 = new TextView(this);
            labelName1.setText("jay");
            labelName1.setId(current);
            labelName1.setPadding(2, 0, 5, 0);
            labelName1.setTextColor(Color.RED);
            tr.addView(labelName1);

            tr= new TableRow(this);
            TextView labelName2 = new TextView(this);
            labelName2.setText("Helaiya");
            labelName2.setId(current);
            labelName2.setPadding(2, 0, 5, 0);
            labelName2.setTextColor(Color.RED);
            tr.addView(labelName2);

            tl.addView(tr);
        }
/*

        TextView label_sir_name = new TextView(this);
        label_sir_name.setText("Sir Name"); // set the text for the header
        label_sir_name.setTextColor(Color.WHITE); // set the color
        label_sir_name.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(label_sir_name); // add the column to the table row here


        TextView label_Address = new TextView(this);
        label_Address.setText("address");
        label_Address.setTextColor(Color.WHITE);
        label_Address.setPadding(5, 5, 5, 5);
        tr_head.addView(label_Address);// add the column to the table row here
*/



        db_manager=new Db_manager(this);

        List<EmployeePojo> employeeList=db_manager.displayAll();
        ArrayList list=new ArrayList();

        Iterator i=employeeList.iterator();

        while (i.hasNext())
        {

          pojo=(EmployeePojo) i.next();

            Log.e("LOOP",pojo.getName());


/*            tr= new TableRow(this);
            TextView labelName1 = new TextView(this);
            labelName1.setText(pojo.getName());
            labelName1.setPadding(2, 0, 5, 0);
            labelName1.setTextColor(Color.RED);
            tr.addView(labelName1);


            TextView labelsirName1 = new TextView(this);
            labelsirName1.setText(pojo.getSir_name());
            labelsirName1.setPadding(2, 0, 5, 0);
            labelsirName1.setTextColor(Color.BLUE);
            tr.addView(labelsirName1);


            TextView labelAddress1 = new TextView(this);
            labelAddress1.setText(pojo.getAddress());
            labelAddress1.setPadding(2, 0, 5, 0);
            labelAddress1.setTextColor(Color.BLACK);
            tr.addView(labelAddress1);*/
        }

/*
        Button back=(Button)findViewById(R.id.view_bt_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                finish();
            }
        });*/

    }





}
