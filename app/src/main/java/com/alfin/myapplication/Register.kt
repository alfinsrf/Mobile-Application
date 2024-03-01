package com.alfin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Register : AppCompatActivity() {

    private lateinit var etEmail : EditText;
    private lateinit var etPassword : EditText;
    private lateinit var etConfirmPassword : EditText;
    private lateinit var rgGender : RadioGroup;
    private lateinit var rbFemale : RadioButton;
    private lateinit var rbMale : RadioButton;
    private lateinit var sRoles : Switch;
    private lateinit var cbRules : CheckBox
    private lateinit var btnRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        rgGender = findViewById(R.id.rgGender);
        rbFemale = findViewById(R.id.rbFemale);
        rbMale = findViewById(R.id.rbMale);
        sRoles = findViewById(R.id.sRoles);
        cbRules = findViewById(R.id.cbRules);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString();
            val password = etPassword.text.toString();
            val confirmPassword = etConfirmPassword.text.toString();
            val selectedGender = rgGender.checkedRadioButtonId;
            val isAdmin = sRoles.isChecked;
            val isCheckbox = cbRules.isChecked;

            if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
            else if(!email.endsWith("@gmail.com")) {
                Toast.makeText(this, "Email invalid", Toast.LENGTH_SHORT).show()
            }
            else if(!password.equals(confirmPassword)) {
                Toast.makeText(this, "Password not same as confirm password", Toast.LENGTH_SHORT).show()
            }
            else if(!isAdmin || !isCheckbox) {
                Toast.makeText(this, "Please check the checkbox or the switch", Toast.LENGTH_SHORT).show()
            }
            else {
                val builder = AlertDialog.Builder(this);
                builder.setTitle("Confirmation")
                builder.setMessage("Are you sure all your data is valid?")
                builder.setPositiveButton("Yes") {dialog, which ->
                    dialog.dismiss();
                }
                builder.setNegativeButton("No") {dialog, which ->
                    dialog.dismiss();
                }
            }
        }
    }
}