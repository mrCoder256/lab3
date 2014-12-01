package ua.stu.translator;

import ua.stu.translator.webservice.Languages;
import ua.stu.translator.webservice.Translator;
import ua.stu.translator.webservice.Word;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] langs = Languages.getArray();
				
		// адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
    		android.R.layout.simple_spinner_item, langs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
		final Spinner spinner_from = (Spinner) findViewById(R.id.spinner_from);
		spinner_from.setAdapter(adapter);
		spinner_from.setSelection(0);
        
        final Spinner spinner_to = (Spinner) findViewById(R.id.spinner_to);
        spinner_to.setAdapter(adapter);
        spinner_to.setSelection(2);
        
        final TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        final EditText editTextToTranslate = (EditText) findViewById(R.id.editTextToTranslate);
        Button btnTranslate = (Button)findViewById(R.id.buttonTranslate);
        
        btnTranslate.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if (TextUtils.isEmpty(editTextToTranslate.getText().toString()))
					return;
				Word answer = Translator.translate(editTextToTranslate.getText().toString(),
					Languages.valueOf(spinner_from.getSelectedItem().toString()),
					Languages.valueOf(spinner_to.getSelectedItem().toString()));
				textViewResult.setText(answer.translationList.get(0));
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
