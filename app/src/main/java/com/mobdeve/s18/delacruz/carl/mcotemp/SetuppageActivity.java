//package com.mobdeve.s18.delacruz.carl.mcotemp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivitySetuppageBinding;
//
//public class SetuppageActivity extends AppCompatActivity {
//    private ActivitySetuppageBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySetuppageBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//
//        binding.btnSetuppageBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
//                startActivity(gotoHome);
//            }
//        });
//    }
//}
