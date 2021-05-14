package com.fakestergrampackage.fakestergram;

import android.provider.ContactsContract;
import android.util.Log;

import java.util.List;

class Singleton
{
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    public List<Post> posts;

    public String userHandle;
    public DatabaseWorker worker;

    // private constructor restricted to this class itself
    private Singleton()
    {
        worker = new DatabaseWorker();
        userHandle = worker.pullUser().getUserHandle();
        Log.i("Singleton constructor: ", "user = " + userHandle);
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }


}
