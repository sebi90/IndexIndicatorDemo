package sebi.indexindicatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import sebi.mylibrary.IndexIndicator;

public class MainActivity extends Activity {

    private IndexIndicator indexIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexIndicator = (IndexIndicator) findViewById(R.id.indexIndicator);

        indexIndicator.setMaximum(10);


    }


    public void onButtonClick(View view)
    {
        switch (view.getId())
        {
            case R.id.first:
                indexIndicator.setValue(0);
                break;
            case R.id.previous:
                indexIndicator.setValue(indexIndicator.getValue()-1);
                break;
            case R.id.next:
                indexIndicator.setValue(indexIndicator.getValue()+1);
                break;
            case R.id.last:
                indexIndicator.setValue(indexIndicator.getMaximum());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
