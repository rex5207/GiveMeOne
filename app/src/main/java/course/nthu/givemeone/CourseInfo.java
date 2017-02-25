package course.nthu.givemeone;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;

import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class CourseInfo extends ActionBarActivity {

    ArrayList<CourseModel> results = new ArrayList<CourseModel>();
    ListView mylist ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        mylist = (ListView) findViewById(R.id.courseList);

        new Thread() {
            @Override
            public void run() {
                try {
                    results.clear();
                    getData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    void getData() throws IOException {
        String url = "https://www.ccxp.nthu.edu.tw/ccxp/COURSE/JH/7/7.2/7.2.7/JH727002.php";
        Document doc = Jsoup.connect(url)
                .data("ACIXSTORE", "las7upc4chjdmejsv82fv8nlr5")
                .data("select", "ANTH")
                .data("act", "1")
                .userAgent("Mozilla")
                .post();


        Elements elements = doc.getElementsByClass("word");

        for(int i=0 ; i<elements.size();i++) {
            CourseModel newsData = new CourseModel();
            newsData.setCourseNum(elements.get(i).child(0).text());
            newsData.setCourseName(elements.get(i).child(1).text());
            newsData.setCourseTeacher(elements.get(i).child(2).text());
            newsData.setCourseTime(elements.get(i).child(3).text());
            newsData.setCourseQuota(elements.get(i).child(6).text());
            results.add(newsData);
        }

        runOnUiThread(new Runnable() {
            public void run() {
                CourseAdapter myAdapter = new CourseAdapter(CourseInfo.this, results);
//                ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(myAdapter);
//                animationAdapter.setAbsListView(mylist);
                mylist.setAdapter(myAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
