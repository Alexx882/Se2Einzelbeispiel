package at.aau.lercher.se2einzelbeispiel;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _editTextInput = null;
    private Button _buttonCheckPalindrome = null;
    private TextView _textViewOutput = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _editTextInput = (EditText) findViewById(R.id.editTextInput);
        _textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        _buttonCheckPalindrome = (Button) findViewById(R.id.buttonCheckPalindrome);
        _buttonCheckPalindrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonCheckPalindromeClick();
            }
        });

    }

    private void handleButtonCheckPalindromeClick() {
        if (_editTextInput == null) {
            showToast("fail");
            return;
        }

        Editable editable = _editTextInput.getText();
        String text = editable != null ? editable.toString() : null;

        // constraint 1: check for empty input
        if (text == null || text.trim().isEmpty())
            setErrorOutput("Please insert a string.");

        // constraint 2: # >= 5 chars
        else if (text.length() < 5)
            setErrorOutput("Please insert at least 5 characters.");

        // check for palindrome
        else if (isPalindrome(text))
            setOutput("Input is a palindrome.");
        else
            setOutput("Input is NOT a palindrome.");
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void setErrorOutput(String text) {
        _textViewOutput.setText(text);
        _textViewOutput.setTextColor(Color.RED);
    }

    private void setOutput(String text) {
        _textViewOutput.setText(text);
        _textViewOutput.setTextColor(Color.BLACK);
    }

    /**
     * Checks if a string is a palindrome. Adapted from task instructions.
     *
     * @param str string to check
     * @return true if palindrome
     */
    private boolean isPalindrome(String str) {
        // just throw if str == null
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
