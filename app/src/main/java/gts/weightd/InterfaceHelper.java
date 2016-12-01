package gts.weightd;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class InterfaceHelper {

    //handling potential null values being input for the entry button


    public static void blockNullText(EditText edt, Button btn) {
        final EditText mEditText = edt;
        final Button mButton = btn;

        if (mEditText.getText().toString().trim().length() == 0) {
            mButton.setEnabled(false);
            //handling potential null values being input for buttons
            edt.addTextChangedListener(new TextWatcher() {

                @Override

                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (mEditText.getText().toString().trim().length() == 0) {
                        mButton.setEnabled(false);
                    }
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (mEditText.getText().toString().trim().length() == 0) {
                        mButton.setEnabled(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (mEditText.getText().toString().trim().length() != 0) {
                        mButton.setEnabled(true);
                    }

                }
            });


        }
    }

}
