package course.examples.ui.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		// Get a reference to the Spinner
		Spinner spinner = (Spinner) findViewById(R.id.spinner);

		// Create an Adapter that holds a list of colors
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//				this, R.array.colors, R.layout.dropdown_item);

		String[] colors = getResources().getStringArray(R.array.colors);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.dropdown_item,colors);
		// Set the Adapter for the spinner
		spinner.setAdapter(adapter);

		// Set an setOnItemSelectedListener on the spinner
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {

				// Display a Toast message indicating the currently selected
				// item
				Toast.makeText(
						parent.getContext(),
						"The color is "
								+ parent.getItemAtPosition(pos).toString(),
						Toast.LENGTH_LONG).show();
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
}