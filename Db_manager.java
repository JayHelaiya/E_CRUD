package nichetech.com.employeecrudproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Db_manager extends SQLiteOpenHelper {

    private static final int database_VERSION = 1;
    private static final String database_NAME = "employeeDB1";
    private static final String table_EMP = "employee";
    private static final String emp_ID = "emp_Id";
    private static final String emp_NAME = "emp_Name";
    private static final String emp_SIR_NAME = "emp_Sir_Name";
    private static final String emp_ADDRESS = "emp_Address";
    private static final String emp_MOBILE = "emp_Mobile";
    private static final String emp_EMAIL = "emp_Email";
    private static final String emp_PASSWORD = "emp_Password";


    public Db_manager(Context context) {

        super(context, database_NAME, null, database_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + table_EMP + "("
                + emp_ID + " INTEGER PRIMARY KEY," + emp_NAME + " TEXT,"
                + emp_SIR_NAME + " TEXT," + emp_ADDRESS + " TEXT,"
                + emp_MOBILE + " TEXT," + emp_EMAIL + " TEXT,"
                + emp_PASSWORD + " TEXT" + ")";

        Log.e("HELLO", "table Created");

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_EMP);
        onCreate(db);
    }

    public void addEmployee(EmployeePojo pojo) {

        Log.e("msg", "dao have pojo");

        Log.e("msge", pojo.getName());
        Log.e("msge", pojo.getSir_name());
        Log.e("msge", pojo.getAddress());
        Log.e("msge", pojo.getMobile());
        Log.e("msge", pojo.getEmail());
        Log.e("msge", pojo.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(emp_NAME, pojo.getName());
        values.put(emp_SIR_NAME, pojo.getSir_name());
        values.put(emp_ADDRESS, pojo.getAddress());
        values.put(emp_MOBILE, pojo.getMobile());
        values.put(emp_EMAIL, pojo.getEmail());
        values.put(emp_PASSWORD, pojo.getPassword());


        db.insert(table_EMP, null, values);
        Log.e("HELLO", "VALUE INSERTED");
        db.close();
    }

    public List<EmployeePojo> displayAll() {

        List<EmployeePojo> empList = new ArrayList<EmployeePojo>();
        String selectQuery = "SELECT  * FROM " + table_EMP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                EmployeePojo pojo = new EmployeePojo();

                pojo.setId(Integer.parseInt(cursor.getString(0)));
                pojo.setName(cursor.getString(1));
                pojo.setSir_name(cursor.getString(2));
                pojo.setAddress(cursor.getString(3));
                pojo.setMobile(cursor.getString(4));
                pojo.setEmail(cursor.getString(5));

                empList.add(pojo);
            } while (cursor.moveToNext());
        }

        return empList;

    }

    public EmployeePojo displayById(int idForUpdate) {
        EmployeePojo pojo = new EmployeePojo();
        List<EmployeePojo> empList = new ArrayList<EmployeePojo>();
        String selectQuery = "SELECT  * FROM " + table_EMP + " WHERE " + emp_ID + "=" + idForUpdate;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                pojo.setName(cursor.getString(1));
                pojo.setSir_name(cursor.getString(2));
                pojo.setAddress(cursor.getString(3));
                pojo.setMobile(cursor.getString(4));
                pojo.setEmail(cursor.getString(5));
                pojo.setPassword(cursor.getString(6));

            } while (cursor.moveToNext());
        }

        return pojo;
    }

    public void deleteById(int idFordelete)
    {
        Integer v = new Integer(idFordelete);
        Log.e("DB", v.toString());
        SQLiteDatabase db = this.getWritableDatabase();

        String deleteQuery = " DELETE FROM " + table_EMP + " WHERE " + emp_ID + " = " + idFordelete;
        db.execSQL(deleteQuery);
        Log.e("HELLO", "VALUE DELETED");
        db.close();

    }
    public boolean updateAll(EmployeePojo pojo, int idForUpdate) {

        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("Dao","pojo in Dao");

        Log.e("Dao",pojo.getName());
        Log.e("Dao",pojo.getSir_name());
        Log.e("Dao",pojo.getAddress());
        Log.e("Dao",pojo.getMobile());
        Log.e("Dao",pojo.getEmail());
        Log.e("Dao",pojo.getPassword());

        ContentValues values = new ContentValues();
        values.put(emp_NAME, pojo.getName());
        values.put(emp_SIR_NAME, pojo.getSir_name());
        values.put(emp_ADDRESS, pojo.getAddress());
        values.put(emp_MOBILE, pojo.getMobile());
        values.put(emp_EMAIL, pojo.getEmail());
        values.put(emp_PASSWORD, pojo.getPassword());

        return db.update(table_EMP, values, emp_ID + "=" + idForUpdate, null) > 0;
    }
}
