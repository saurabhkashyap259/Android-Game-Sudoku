package saurabh.play.sudoku1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//setup click listeners for all buttons
		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		View newButton = findViewById(R.id.new_game_button);
		newButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.about_button:
			Intent i = new Intent(this, AboutActivity.class);
			startActivity(i);
			break;
		
		case R.id.new_game_button:
			openNewGameDialog();
			break;
			
		case R.id.exit_button:
			finish();
			break;
		}
		
	}
	private static final String TAG = "Sudoku";
	private void openNewGameDialog() 
	{
		// TODO Auto-generated method stub
		new AlertDialog.Builder(this).setItems(R.array.difficulty, new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialoginterface,int i)
			{
				startgame(i);
			}
		})
		.show();
	}

	protected void startgame(int i) {
		// TODO Auto-generated method stub
		Log.d(TAG,"clicked on"+i);
		Intent intent = new Intent(this,GameActivity.class);
		intent.putExtra(GameActivity.KEY_DIFFICULTY, i);
		startActivity(intent);
	}

	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case R.id.action_settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
		}
		return false;
		
	}

}
