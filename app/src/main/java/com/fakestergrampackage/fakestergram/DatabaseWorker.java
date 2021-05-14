package com.fakestergrampackage.fakestergram;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseWorker {

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    // Write a message to the database
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("message");

    private String TAG;
    private User user;

    public DatabaseWorker(){
        //empty constructor
    }

    //pull user from Firebase
    public User pullUser(){

        TAG = "pullUser: ";

        user = null;

        // Read from the database
        myRef.child("users").child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);

                user = dataSnapshot.getValue(User.class);
                Log.d(TAG, "Value is: " + user.getUserHandle());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return user;
    }

    public void pushUser(User user){

    }

}
