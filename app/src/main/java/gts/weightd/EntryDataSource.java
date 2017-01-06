package gts.weightd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EntryDataSource {


    private Context mContext;
    private WeightdSQLiteHelper mEntrySqliteHelper;

    public EntryDataSource(Context context){

        mContext = context;
        mEntrySqliteHelper = new WeightdSQLiteHelper(context);
        SQLiteDatabase database = mEntrySqliteHelper.getReadableDatabase();
        database.close();
    }
    private SQLiteDatabase open(){
        return mEntrySqliteHelper.getWritableDatabase();
    }

    private void close(SQLiteDatabase database){
        database.close();
    }



    public void create(Entry entry){
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues entryValues = new ContentValues();
        entryValues.put(WeightdSQLiteHelper.COLUMN_ENTRY_LABEL, entry.getLabel());
        entryValues.put(WeightdSQLiteHelper.COLUMN_ENTRY_VALUE, entry.getValue());
        long entryID = database.insert(WeightdSQLiteHelper.ENTRY_TABLE,null,entryValues);


        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);



    }
}
