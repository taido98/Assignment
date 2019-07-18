package gst.trainingcourse.lesson3_ex2_dont7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {

    ArrayList<String> arrayListB = new ArrayList<String>();
    private String mOutput = "";
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        initView();
        getData();

    }

    private void getData() {
        arrayListB = getIntent().getExtras().getStringArrayList("arrayListA");
        for (int i = 0; i < arrayListB.size(); i++) {
            mOutput += arrayListB.get(i) + "\n";
            Log.d("#" + i, " " + arrayListB.get(i));
        }
        mResult.setText(mOutput);
    }

    private void initView() {
        mResult = findViewById(R.id.textView4);
    }
}
