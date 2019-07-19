package gst.trainingcourse.lesson3_ex3_dont7_a;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCallAppByIntent;
    private Button mBtnCallAppByBroadcast;

    private final View.OnClickListener mStartAppByIntent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("gst.trainingcourse.lesson3_ex3_dont7_b", "gst.trainingcourse.lesson3_ex3_dont7_b.MainActivity"));
            startActivity(intent);
        }
    };

    private final View.OnClickListener mStartAppByBroadcast = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent();
            intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            intent1.setAction("action.open.app");
            sendBroadcast(intent1);
            // send BroadcastReceiver to all app
            List<ResolveInfo> list = getPackageManager().queryBroadcastReceivers(intent1, 0);
            for (ResolveInfo r : list) {
                String packageName = r.activityInfo.packageName;
                String className = r.activityInfo.name;
                intent1.setComponent(new ComponentName(packageName, className));
                sendBroadcast(intent1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initActions();
    }

    private void initActions() {
        mBtnCallAppByIntent.setOnClickListener(mStartAppByIntent);
        mBtnCallAppByBroadcast.setOnClickListener(mStartAppByBroadcast);
    }

    private void initView() {
        mBtnCallAppByIntent = findViewById(R.id.btn_call_app_by_intent);
        mBtnCallAppByBroadcast = findViewById(R.id.btn_call_app_by_broadcast);
    }

}
