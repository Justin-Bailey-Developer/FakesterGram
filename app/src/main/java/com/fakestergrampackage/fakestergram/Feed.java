package com.fakestergrampackage.fakestergram;

import java.util.List;


/*class Singleton
{
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // variable of type String
    public String s;

    public List<Post> posts;

    // private constructor restricted to this class itself
    private Singleton()
    {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}*/

public class Feed {

    private List<Post> posts;

    public Feed(){

    }
}
