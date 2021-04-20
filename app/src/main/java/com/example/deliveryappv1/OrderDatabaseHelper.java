package com.example.deliveryappv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class OrderDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "coffeeOrdersDB";
    private static final int DB_VERSION = 1;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
//     * @param name    of the database file, or null for an in-memory database
//     * @param factory to use for creating cursor objects, or null for the default
//     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public OrderDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE COFFEE_DATA ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "TYPE TEXT,"
                + "PRICE INTEGER);");
        insertCoffee(db, "Plain black", 2);
        insertCoffee(db, "Caffè Americano", 3);
        insertCoffee(db, "Cappuccino", 3);
        insertCoffee(db, "Cortado", 3);
        insertCoffee(db, "Flat white", 3);
        insertCoffee(db, "Caffè macchiato", 3);
        insertCoffee(db, "Latte", 3);
        insertCoffee(db, "Ristretto", 4);
        insertCoffee(db, "Café au lait", 4);
        insertCoffee(db, "Caffè mocha", 4);
        insertCoffee(db, "Cold brew coffee", 4);
        insertCoffee(db, "Affogato", 5);
        insertCoffee(db, "Iced coffee", 5);
        insertCoffee(db, "Irish coffee", 5);


    }

    private static void insertCoffee(SQLiteDatabase db,
                                     String type,
                                     double price) {
        ContentValues coffeeValues = new ContentValues();
        coffeeValues.put("TYPE", type);
        coffeeValues.put("PRICE", price);
        db.insert("COFFEE", null, coffeeValues);
    }


    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
