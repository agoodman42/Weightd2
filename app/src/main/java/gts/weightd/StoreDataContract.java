package gts.weightd;

import android.provider.BaseColumns;

public final class StoreDataContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private StoreDataContract() {}

    /* Inner class that defines the table contents */
    public static class StoreEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
