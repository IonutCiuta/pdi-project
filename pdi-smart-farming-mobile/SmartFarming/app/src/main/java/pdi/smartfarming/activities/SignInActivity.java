package pdi.smartfarming.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import pdi.smartfarming.R;
import pdi.smartfarming.dto.User;
import pdi.smartfarming.rest.UserRepository;
import pdi.smartfarming.tools.RetrofitClient;
import pdi.smartfarming.tools.Storage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ionutciuta24@gmail.com on 07.05.2017.
 */
public class SignInActivity extends AbstractActivity{
    public SignInActivity() {
        super(R.layout.activity_sign_in);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.btn_signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText)findViewById(R.id.in_username)).getText().toString();
                String password = ((EditText)findViewById(R.id.in_password)).getText().toString();

                if(username.isEmpty() || password.isEmpty()) {
                    final Snackbar errorSnackbar = Snackbar.make(findViewById(R.id.btn_signin), "Complete both fields!", 5000);
                    errorSnackbar
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    errorSnackbar.dismiss();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorAccent, null));
                    errorSnackbar.show();
                } else {
                    Log.i(TAG, "Signing in...");
                    UserRepository userRepo = RetrofitClient.instance.create(UserRepository.class);

                    userRepo.authenticateUser(new User(username, password)).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if(response.code() == 200) {
                                Log.i(TAG, "Sign in was successful: " + response.body());
                                saveUser(response.body());
                                next(MainActivity.class);
                            } else {
                                final Snackbar errorSnackbar = Snackbar.make(findViewById(R.id.btn_signin), "Wrong credentials!", 5000);
                                errorSnackbar
                                        .setAction("DISMISS", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                errorSnackbar.dismiss();
                                            }
                                        })
                                        .setActionTextColor(getResources().getColor(R.color.colorAccent, null));
                                errorSnackbar.show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Log.e(TAG, t.getMessage());
                        }
                    });
                }
            }
        });
    }

    private void saveUser(User user) {
        Storage.saveCurrentUser(user, this);
    }
}
