package graysone;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

import graysone.com.amazonservice.R;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions ( this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},1 );
        stringList = new ArrayList <> (  );


        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );
        stringList.add ( "Madhu" );

        recyclerView = findViewById ( R.id.rc );

        linearLayoutManager= new LinearLayoutManager ( getApplicationContext () );
        recyclerView.setLayoutManager ( linearLayoutManager );

        recyclerView.setAdapter ( new MyAdapter(stringList));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater ();

        menuInflater.inflate ( R.menu.menu,menu );
        return true;
    }
}
