package com.cs50.electron3d.autocalc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AutoCostCalcActivity extends AppCompatActivity {
    /* TODO
    *   1) добавить комментарии к коду */

    String[] yesOrNo = {" ", "yes", "no"};
    String item;

    private int isIntNull(String s) {
        if (TextUtils.isEmpty(s)) {
            return 0;
        } else {
            return Integer.parseInt(s);
        }
    }

    private int isIntEmpty(String s) {
        if (TextUtils.isEmpty(s)) {
            return 1;
        } else {
            return Integer.parseInt(s);
        }
    }

    private float isFloatNull(String s) {
        if (TextUtils.isEmpty(s)) {
            return 0;
        } else {
            return Float.parseFloat(s);
        }
    }

    private float isFloatEmpty(String s) {
        if (TextUtils.isEmpty(s)) {
            return 1;
        } else {
            return Float.parseFloat(s);
        }
    }

    private int round(float f) {
        return Math.round(f);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocostcalc);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        Button calculateButton = findViewById(R.id.CalculateButton);
        Button clearButton = findViewById(R.id.ClearButton);
        Button lostProfitHelpButton = findViewById(R.id.lostProfitHelpButton);
        Button lossOfValueHelpButton = findViewById(R.id.lossOfValueHelpButton);

        EditText carPriceEditText = findViewById(R.id.CarPrice);
        EditText timeOfOwnershipEditText = findViewById(R.id.TimeOfOwnership);
        EditText annualMileageEditText = findViewById(R.id.AnnualMileage);
        EditText lostProfitEditText = findViewById(R.id.LostProfit);
        EditText lossOfValueEditText = findViewById(R.id.LossOfValue);
        EditText amountOfCreditEditText = findViewById(R.id.AmountOfCredit);
        EditText creditTermEditText = findViewById(R.id.CreditTerm);
        EditText interestRateEditText = findViewById(R.id.InterestRate);
        EditText vehiclePowerEditText = findViewById(R.id.VehiclePower);
        EditText fuelConsumptionEditText = findViewById(R.id.FuelConsumption);
        EditText fuelPriceEditText = findViewById(R.id.FuelPrice);
        EditText repairEditText = findViewById(R.id.repair);
        CheckBox checkBox = findViewById(R.id.checkBox);

        Spinner spinnerCredit = findViewById(R.id.Credit);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yesOrNo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCredit.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = (String)parent.getItemAtPosition(position);
                if (item.equals("yes")) {
                    amountOfCreditEditText.setVisibility(View.VISIBLE);
                    creditTermEditText.setVisibility(View.VISIBLE);
                    interestRateEditText.setVisibility(View.VISIBLE);
                } else {
                    amountOfCreditEditText.setVisibility(View.GONE);
                    creditTermEditText.setVisibility(View.GONE);
                    interestRateEditText.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                item = "no";
            }
        };
        spinnerCredit.setOnItemSelectedListener(itemSelectedListener);

        TextView resultText = findViewById(R.id.ResultText);
        TextView costPerKmText = findViewById(R.id.PerKmText);
        TextView costPerKm = findViewById(R.id.PerKm);
        TextView costPerMonthText = findViewById(R.id.PerMonthText);
        TextView costPerMonth = findViewById(R.id.PerMonth);
        TextView costPerYearText = findViewById(R.id.PerYearText);
        TextView costPerYear = findViewById(R.id.PerYear);
        TextView costTotalText = findViewById(R.id.TotalText);
        TextView costTotal = findViewById(R.id.Total);
        TextView lostProfitT = findViewById(R.id.LostProfitText);
        TextView lostProfit = findViewById(R.id.LostProfitResult);
        TextView lossOfValueT = findViewById(R.id.LossOfValueText);
        TextView lossOfValue = findViewById(R.id.LossOfValueResult);
        TextView fuelPerYearText = findViewById(R.id.fuelPerYearText);
        TextView fuelPerYear = findViewById(R.id.fuelPerYear);
        TextView fuelTotalText = findViewById(R.id.fuelTotalText);
        TextView fuelTotal = findViewById(R.id.fuelTotal);
        TextView taxPerYearText = findViewById(R.id.taxPerYearText);
        TextView taxPerYear = findViewById(R.id.taxPerYear);
        TextView taxText = findViewById(R.id.taxText);
        TextView tax = findViewById(R.id.tax);
        TextView mtplText = findViewById(R.id.mtplText);
        TextView mtpl = findViewById(R.id.mtpl);
        TextView mtplTotalText = findViewById(R.id.mtplTotalText);
        TextView mtplTotal = findViewById(R.id.mtplTotal);
        TextView insuranceText = findViewById(R.id.insuranceText);
        TextView insurance = findViewById(R.id.insurance);
        TextView insuranceTotalText = findViewById(R.id.insuranceTotalText);
        TextView insuranceTotal = findViewById(R.id.insuranceTotal);
        TextView credit = findViewById(R.id.credit);
        TextView creditText = findViewById(R.id.creditText);
        ScrollView scrollView = findViewById(R.id.scroll);

        calculateButton.setOnClickListener(v -> {
            String carPriceText = carPriceEditText.getText().toString();
            String timeOfOwnershipText = timeOfOwnershipEditText.getText().toString();
            String annualMileageText = annualMileageEditText.getText().toString();
            String lostProfitText = lostProfitEditText.getText().toString();
            String lossOfValueText = lossOfValueEditText.getText().toString();
            String amountOfCreditText = amountOfCreditEditText.getText().toString();
            String creditTermText = creditTermEditText.getText().toString();
            String interestRateText = interestRateEditText.getText().toString();
            String vehiclePowerText = vehiclePowerEditText.getText().toString();
            String fuelConsumptionText = fuelConsumptionEditText.getText().toString();
            String fuelPriceText = fuelPriceEditText.getText().toString();
            String repairText = repairEditText.getText().toString();

            AutoCalculator calculator = new AutoCalculator(isIntNull(carPriceText),
                            isIntEmpty(timeOfOwnershipText), isIntEmpty(annualMileageText),
                            isFloatNull(lostProfitText), isFloatNull(lossOfValueText),
                            item.equals("yes"), item.equals("no")? 0 : isIntEmpty(amountOfCreditText),
                            item.equals("no")? 0 : isIntEmpty(creditTermText),
                            item.equals("no")? 0 : isFloatEmpty(interestRateText), checkBox.isChecked(),
                            isIntEmpty(vehiclePowerText), isFloatEmpty(fuelConsumptionText),
                            isFloatNull(fuelPriceText), isIntNull(repairText));

            resultText.setVisibility(View.VISIBLE);
            costPerKmText.setVisibility(View.VISIBLE);
            costPerKm.setVisibility(View.VISIBLE);
            costPerMonthText.setVisibility(View.VISIBLE);
            costPerMonth.setVisibility(View.VISIBLE);
            costPerYearText.setVisibility(View.VISIBLE);
            costPerYear.setVisibility(View.VISIBLE);
            costTotalText.setVisibility(View.VISIBLE);
            costTotal.setVisibility(View.VISIBLE);
            lostProfitT.setVisibility(View.VISIBLE);
            lostProfit.setVisibility(View.VISIBLE);
            lossOfValueT.setVisibility(View.VISIBLE);
            lossOfValue.setVisibility(View.VISIBLE);
            fuelPerYearText.setVisibility(View.VISIBLE);
            fuelPerYear.setVisibility(View.VISIBLE);
            fuelTotalText.setVisibility(View.VISIBLE);
            fuelTotal.setVisibility(View.VISIBLE);
            taxPerYearText.setVisibility(View.VISIBLE);
            taxPerYear.setVisibility(View.VISIBLE);
            taxText.setVisibility(View.VISIBLE);
            tax.setVisibility(View.VISIBLE);
            mtplText.setVisibility(View.VISIBLE);
            mtpl.setVisibility(View.VISIBLE);
            mtplTotalText.setVisibility(View.VISIBLE);
            mtplTotal.setVisibility(View.VISIBLE);
            clearButton.setVisibility(View.VISIBLE);

            costPerKm.setText(String.format("%.2f", calculator.carCostPerKm()) + " ₽");
            costPerMonth.setText(round(calculator.carCostPerMonth()) + " ₽");
            costPerYear.setText(round(calculator.carCostPerYear()) + " ₽");
            costTotal.setText(round(calculator.carCostTotal()) + " ₽");
            lostProfit.setText(round(calculator.lostProfitCalc()) + " ₽");
            lossOfValue.setText(round(calculator.lossOfValueCalc()) + " ₽");
            fuelPerYear.setText(round(calculator.fuelCostPerYear()) + " ₽");
            fuelTotal.setText(round(calculator.fuelCostTotal()) + " ₽");
            taxPerYear.setText(round(calculator.taxPerYear()) + " ₽");
            tax.setText(round(calculator.taxTotal()) + " ₽");
            mtpl.setText(round(calculator.MTPL) + " ₽");
            mtplTotal.setText(round(calculator.mtplTotal()) + " ₽");

            if (checkBox.isChecked()) {
                insuranceText.setVisibility(View.VISIBLE);
                insurance.setVisibility(View.VISIBLE);
                insuranceTotalText.setVisibility(View.VISIBLE);
                insuranceTotal.setVisibility(View.VISIBLE);
                insurance.setText(round(calculator.HULL_INSURANCE) + " ₽");
                insuranceTotal.setText(round(calculator.insuranceTotal()) + " ₽");
            } else {
                insuranceText.setVisibility(View.GONE);
                insurance.setVisibility(View.GONE);
                insuranceTotalText.setVisibility(View.GONE);
                insuranceTotal.setVisibility(View.GONE);
            }

            if (item.equals("yes")) {
                creditText.setVisibility(View.VISIBLE);
                credit.setVisibility(View.VISIBLE);
                credit.setText(round(calculator.credit())  + " ₽");
            } else {
                creditText.setVisibility(View.GONE);
                credit.setVisibility(View.GONE);
            }
            scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
        });

        clearButton.setOnClickListener(v -> {
            carPriceEditText.setText(null);
            timeOfOwnershipEditText.setText(null);
            annualMileageEditText.setText(null);
            lostProfitEditText.setText(null);
            lossOfValueEditText.setText(null);
            amountOfCreditEditText.setText(null);
            creditTermEditText.setText(null);
            interestRateEditText.setText(null);
            vehiclePowerEditText.setText(null);
            fuelConsumptionEditText.setText(null);
            fuelPriceEditText.setText(null);
            repairEditText.setText(null);
            checkBox.setChecked(false);
            spinnerCredit.setSelection(0);

            resultText.setVisibility(View.GONE);
            costPerKmText.setVisibility(View.GONE);
            costPerKm.setVisibility(View.GONE);
            costPerMonthText.setVisibility(View.GONE);
            costPerMonth.setVisibility(View.GONE);
            costPerYearText.setVisibility(View.GONE);
            costPerYear.setVisibility(View.GONE);
            costTotalText.setVisibility(View.GONE);
            costTotal.setVisibility(View.GONE);
            lostProfitT.setVisibility(View.GONE);
            lostProfit.setVisibility(View.GONE);
            lossOfValueT.setVisibility(View.GONE);
            lossOfValue.setVisibility(View.GONE);
            fuelPerYearText.setVisibility(View.GONE);
            fuelPerYear.setVisibility(View.GONE);
            fuelTotalText.setVisibility(View.GONE);
            fuelTotal.setVisibility(View.GONE);
            taxPerYearText.setVisibility(View.GONE);
            taxPerYear.setVisibility(View.GONE);
            taxText.setVisibility(View.GONE);
            tax.setVisibility(View.GONE);
            mtplText.setVisibility(View.GONE);
            mtpl.setVisibility(View.GONE);
            mtplTotalText.setVisibility(View.GONE);
            mtplTotal.setVisibility(View.GONE);
            clearButton.setVisibility(View.GONE);
            insuranceText.setVisibility(View.GONE);
            insurance.setVisibility(View.GONE);
            insuranceTotalText.setVisibility(View.GONE);
            insuranceTotal.setVisibility(View.GONE);
            creditText.setVisibility(View.GONE);
            credit.setVisibility(View.GONE);
            scrollView.post(() -> scrollView.fullScroll(View.FOCUS_UP));
        });

        lossOfValueHelpButton.setOnClickListener(v -> {
            startActivity(new Intent(AutoCostCalcActivity.this, LossOfValueHelpActivity.class));
        });

        lostProfitHelpButton.setOnClickListener(v -> {
            startActivity(new Intent(AutoCostCalcActivity.this, LostProfitHelpActivity.class));
        });
    }
}