package com.example.unhee.sustentavel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unhee.sustentavel.views.HomePageActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailLogin;
    private EditText senhaLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        emailLogin = (EditText) findViewById(R.id.emailLogin);
        senhaLogin = (EditText) findViewById(R.id.senhaLogin);
    }

    public void fazLogin(View view) {
        String email = emailLogin.getText().toString();
        String senha = senhaLogin.getText().toString();
        mAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Sign", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent myIntent = new Intent(MainActivity.this, HomePageActivity.class);
                            //Ira mandar por parametro o objeto do usario autenticado.
                            myIntent.putExtra("usuario", "usuario");
                            startActivity(myIntent);                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Sign", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        //TODO: mandar para funçao que ira autenticar!
    }
}
