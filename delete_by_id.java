package nichetech.com.employeecrudproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class delete_by_id extends AppCompatActivity {

    Db_manager db_manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_by_id);

        ListView listView=(ListView)findViewById(R.id.lv_emp_list_delete);
        Button back=(Button)findViewById(R.id.view_bt_back_delete);
        db_manager=new Db_manager(this);
        Bundle extras=getIntent().getExtras();
        final int idFordelete=Integer.parseInt(extras.getString("delete_Id"));
        Log.e("DEL", String.valueOf(Integer.parseInt(extras.getString("delete_Id"))));

        db_manager.deleteById(idFordelete);

        List<EmployeePojo> employeeList=db_manager.displayAll();
        ArrayList<StringBuilder> list=new ArrayList<StringBuilder>();

        StringBuilder empBuilder=new StringBuilder();
        Iterator i=employeeList.iterator();

        while (i.hasNext())
        {
            EmployeePojo pojo= (EmployeePojo) i.next();

            Integer iid=new Integer(pojo.getId());
            empBuilder.append(iid.toString()+" "+pojo.getName());
            list.add(empBuilder);

            Log.e("loop",pojo.getName());
        }
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),R.layout.views_spinner_style,R.id.tv_custome_spinner_style,list);
        listView.setAdapter(adapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                finish();
            }
        });

    }
}
