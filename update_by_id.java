package nichetech.com.employeecrudproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class update_by_id extends AppCompatActivity {

    EditText fname,lname,address,mobile,email,password;
    Db_manager db_manager;
    Button update,back;
    EmployeePojo pojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_by_id);

        db_manager=new Db_manager(this);
        Bundle extras=getIntent().getExtras();
        final int idForUpdate=Integer.parseInt(extras.getString("update_Id"));

        Log.e("id come", String.valueOf(Integer.parseInt(extras.getString("update_Id"))));
        pojo=db_manager.displayById(idForUpdate);
        update=(Button)findViewById(R.id.bt_update_Raf);
        back=(Button)findViewById(R.id.bt_back_Raf);

        fname=(EditText)findViewById(R.id.et_fname_up);
        lname=(EditText)findViewById(R.id.et_lname_up);
        address=(EditText)findViewById(R.id.et_address_up);
        mobile=(EditText)findViewById(R.id.et_mo_up);
        email=(EditText)findViewById(R.id.et_email_up);
        password=(EditText)findViewById(R.id.et_password_up);


        fname.setText(pojo.getName());
        lname.setText(pojo.getSir_name());
        address.setText(pojo.getAddress());
        mobile.setText(pojo.getMobile());
        email.setText(pojo.getEmail());
        password.setText(pojo.getPassword());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                finish();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=fname.getText().toString();
                String s2=lname.getText().toString();
                String s3=address.getText().toString();
                String s4=mobile.getText().toString();
                String s5=email.getText().toString();
                String s6=password.getText().toString();

                Log.e("TEG",s1);
                Log.e("TEG",s2);
                Log.e("TEG",s3);
                Log.e("TEG",s4);
                Log.e("TEG",s5);
                Log.e("TEG", s6);

                pojo.setName(s1);
                pojo.setSir_name(s2);
                pojo.setAddress(s3);
                pojo.setMobile(s4);
                pojo.setEmail(s5);
                pojo.setPassword(s6);


                    boolean status=db_manager.updateAll(pojo,idForUpdate);

                    if (status)
                    {
                        fname.setText("");
                        lname.setText("");
                        address.setText("");
                        mobile.setText("");
                        email.setText("");
                        password.setText("");

                        Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();

                    }

            }
        });


    }
}
