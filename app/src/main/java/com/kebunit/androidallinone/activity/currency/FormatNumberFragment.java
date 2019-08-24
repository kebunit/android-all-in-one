package com.kebunit.androidallinone.activity.currency;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.helper.NumberHelper;

public class FormatNumberFragment extends Fragment {
    private TextInputEditText inputNumber;
    private TextView code, header, body;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.format_number_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputNumber = view.findViewById(R.id.input_number);
        code = view.findViewById(R.id.currency_code);
        header = view.findViewById(R.id.currency_header);
        body = view.findViewById(R.id.currency_body);

        code.setText("Rp");

        inputNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 3) {
                    String currency[] = NumberHelper.currencyFormat(s.toString(), "#").split("#");
                    header.setText(currency[0]);
                    body.setText(currency[1]);
                } else {
                    header.setText(s.toString());
                    body.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
