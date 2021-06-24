package codeando.com

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
class Login : AppCompatActivity() {
    var e1: EditText1 = null
    var e2: EditText2 = null
    var b1: Button? = null
    var b2: Button? = null
    var db: DatabaseHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db = DatabaseHelper(this)
        e1 = findViewById<View>(R.id.usuario) as EditText
        e2 = findViewById<View>(R.id.password) as EditText
        b1 = findViewById<View>(R.id.loguear) as Button
        b2 = findViewById<View>(R.id.segunda) as Button
        b1.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                val email = e1!!.text.toString()
                val password = e2!!.text.toString()
                val Chkemailpass: Boolean = db.emailpassword(email, password)
                if (Chkemailpass == true) { //Añadimos llaves ya que va a haber más de una línea de código
                    Toast.makeText(applicationContext, "Ha iniciado sesión correctamente", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, OtraActividad::class.java) //Creamos el intent y le indicamos desde donde vamos (this) y a donde vamos (OtraActividad.class)
                    startActivity(intent) //Abrimos la otra actividad
                } else Toast.makeText(applicationContext, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
public void onClick(View v) {

    String email=e1.getText().toString();
    String password=e2.getText().toString();
    Boolean Chkemailpass=db.emailpassword(email,password);
    if(Chkemailpass==true)
        Toast.makeText(getApplicationContext(),"Ha iniciado sesión correctamente",Toast.LENGTH_SHORT).show();
    else
        Toast.makeText(getApplicationContext(),"Email o contraseña incorrectos",Toast.LENGTH_SHORT).show();
}
