package com.example.malkia.data

import android.app.ProgressDialog
import android.widget.Toast
import com.example.malkia.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class AuthViewModel {
    var mAuth: FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth= FirebaseAuth.getInstance()
        progress=ProgressDialog(context)
        progress.setTittle("Loading")
        progress.setMessage("Please Wait.....")
    }
    fun signup(email:String,pass:String,confpass:String){
        //progress.show()

        if (email.isBlank()|| pass.isBlank() ||confpass.isBlank()){
           // progress.dismiss()
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                if (it.isSuccessful){
                    val userdata= User(email,pass,mAuth.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener{

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_REGISTER)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_LOGOUT)
                }
            }}
        }
        fun login(email: String,pass: String){
            progress.show()

            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText((context,"Successfully Logged In",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_REGISTER)
                }else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_LOGIN)
                }
            }
    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }
}