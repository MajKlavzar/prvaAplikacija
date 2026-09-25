package com.example.prvaaplikacija;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Nastavitev poslušalcev za gumb in Floating Action Button
        Button button = findViewById(R.id.button);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        CheckBox checkBox = findViewById(R.id.checkBox);

        // 1. Ob kliku na gumb se prikaže Toast z besedilom
        button.setOnClickListener(v ->
            Toast.makeText(MainActivity.this, "My first Android Studio application!", Toast.LENGTH_SHORT).show()
        );

        // 2. Ob kliku na FAB se prikaže Snackbar (privzeti ali prilagojeni Toast-like)
        fab.setOnClickListener(v -> {
            if (checkBox != null && checkBox.isChecked()) {
                // b) Prilagojeni Snackbar na sredini zaslona
                showCustomToastLikeSnackbar(v);
            } else {
                // a) Privzeti Snackbar
                showDefaultSnackbar(v);
            }
        });
    }

    /**
     * a) Privzeta različica gradnika Snackbar z besedilom "Just another option for button."
     */
    private void showDefaultSnackbar(View view) {
        Snackbar.make(view, "Just another option for button.", Snackbar.LENGTH_SHORT).show();
    }

    /**
     * b) Prilagojena različica gradnika Snackbar, postavljena na sredino celotnega zaslona
     * po vodoravni in navpični osi z obliko, barvo ozadja in pisavo, podobno gradniku Toast.
     */
    private void showCustomToastLikeSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Just another option for button.", Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();

        // Postavitev na sredino celotnega zaslona po vodoravni in navpični osi ter širina po vsebini (wrap_content)
        ViewGroup.LayoutParams params = snackbarView.getLayoutParams();
        if (params instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams flParams = (FrameLayout.LayoutParams) params;
            flParams.gravity = Gravity.CENTER;
            flParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            snackbarView.setLayoutParams(flParams);
        } else if (params instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams clParams = (CoordinatorLayout.LayoutParams) params;
            clParams.gravity = Gravity.CENTER;
            clParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            snackbarView.setLayoutParams(clParams);
        }

        // Oblika ozadja, barva in senčenje, podobni gradniku Toast
        GradientDrawable toastShape = new GradientDrawable();
        toastShape.setShape(GradientDrawable.RECTANGLE);
        toastShape.setCornerRadius(dpToPx(24)); // Zaobljeni robovi kot pri Toastu
        toastShape.setColor(Color.parseColor("#323232")); // Temno siva barva ozadja Toasta
        
        snackbarView.setBackground(toastShape);
        snackbarView.setElevation(dpToPx(6)); // Senčenje

        // Prilagoditev pisave in poravnave besedila na sredino
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        if (textView != null) {
            textView.setTextColor(Color.WHITE);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setGravity(Gravity.CENTER);
        }

        snackbar.show();
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}