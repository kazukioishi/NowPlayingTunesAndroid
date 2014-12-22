package net.kazukioishi.nowplayingtunes.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.kazukioishi.nowplayingtunes.R;
import net.kazukioishi.nowplayingtunes.Twit.AccountManager.TwitterOAuth;

import java.net.URL;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class OAtuhActivity extends ActionBarActivity {
    TextView URLTextVIiew;
    EditText PasswordEditText;
    Button AuthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oatuh);
        URLTextVIiew = (TextView)findViewById(R.id.URLtextView);
        URLTextVIiew.setOnClickListener(new URLTextViewOnClick());
        PasswordEditText = (EditText)findViewById(R.id.editTextPassword);
        AuthButton = (Button)findViewById(R.id.buttonAuthStart);
        AuthButton.setOnClickListener(new AuthButtonOnClick());
        //OAuth
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer(TwitterOAuth.CONSUMER_KEY,TwitterOAuth.CONSUMER_SECRET);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_oatuh, menu);
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

    class URLTextViewOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(((TextView)v).getText().toString()));
            startActivity(browser);
        }
    }

    class AuthButtonOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }
}
