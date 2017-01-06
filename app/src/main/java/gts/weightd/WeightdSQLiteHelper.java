package gts.weightd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class WeightdSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Weighted.db";
    private static final int DB_VERSION = 1;
    //entry table functionality
    public static final String ENTRY_TABLE = "ENTRIES";
    public static final String COLUMN_ENTRY_LABEL = "LABEL";
    public static final String COLUMN_ENTRY_VALUE = "VALUE";
    public static final String COLUMN_ENTRY_TIME = "TIME";
    public static final String COLUMN_ENTRY_UNITS = "UNITS";
    public static final String COLUMN_ENTRY_COLOR = "COLOR";
    public static final String COLUMN_ENTRY_USER = "USER";
    public static final String COLUMN_FOREIGN_KEY_INDICATOR = "INDICATORS_ID";


    private static String CREATE_ENTRY =
            "CREATE TABLE" + ENTRY_TABLE  + "("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_ENTRY_LABEL + " TEXT" +
                    COLUMN_ENTRY_VALUE + " INTEGER," +
                    COLUMN_ENTRY_TIME + " INTEGER" +
                    COLUMN_ENTRY_USER + " TEXT" +
                    COLUMN_FOREIGN_KEY_INDICATOR + " REFERENCES INDICATOR_TABLE(_ID))";

    //Indicator table functionality
    public static final String INDICATOR_TABLE = "INDICATORS";
    public static final String COLUMN_INDICATOR_NAME = "NAME";
    public static final String COLUMN_INDICATOR_UNITS = "UNITS";
    public static final String COLUMN_INDICATOR_COLOR = "COLOR";

    private static String CREATE_INDICATOR =
            "CREATE TABLE" + INDICATOR_TABLE  + "("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_INDICATOR_NAME + " TEXT)"+
                    COLUMN_INDICATOR_UNITS + " TEXT)"+
                    COLUMN_INDICATOR_COLOR + " TEXT))";







    public WeightdSQLiteHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);



    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ENTRY);
        sqLiteDatabase.execSQL(CREATE_INDICATOR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
