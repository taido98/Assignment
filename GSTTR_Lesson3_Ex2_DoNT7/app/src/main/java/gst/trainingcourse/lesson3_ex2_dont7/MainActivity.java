package gst.trainingcourse.lesson3_ex2_dont7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private final View.OnClickListener mOnClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ActivityB.class);
            intent.putStringArrayListExtra("arrayListA", arrayListA);
            startActivity(intent);
        }
    };

    private Button mBtnCallActivityB;
    String[] listA = new String[]{"Hello!", "Hi!", "Salut!", "Hallo!",
            "Ciao!", "Ahoj!", "YAH sahs!", "Bog!", "Hej!", "Czesc!", "Ní hảo!",
            "Kon’nichiwa!", "Annyeonghaseyo!", "Shalom!", "Sah-wahd-dee-kah!",
            "Merhaba!", "Hujambo!", "Olá!"};
    ArrayList<String> arrayListA = new ArrayList<String>(Arrays.asList(listA));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initActions();

    }

    private void initActions() {
        mBtnCallActivityB.setOnClickListener(mOnClicklistener);
    }

    private void initView() {
        mBtnCallActivityB = findViewById(R.id.Btn_CallActivityB);
    }
}
