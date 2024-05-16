package com.example.malkia.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.malkia.models.Product
import com.example.malkia.models.Upload
import com.example.malkia.navigation.ROUTE_LOGIN_SCREEN
//import com.google.android.gms.analytics.ecommerce.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


//class ProductViewModel(var navController: NavHostController, var context: Context) {
//    var authRepository: AuthViewModel
//    var progress: ProgressDialog
//
//    init {
//        authRepository = AuthViewModel(navController, context)
//        if (!authRepository.isloggedin()){
//            navController.navigate(ROUTE_LOGIN)
//        }
//        progress = ProgressDialog(context)
//        progress.setTitle("Loading")
//        progress.setMessage("Please wait....")
//    }
//
//    @OptIn(ExperimentalComposeUiApi::class)
//    fun saveProduct(productName: String, productQuantity:String, productPrice: String){
//        var id = System.currentTimeMillis().toString()
//        var productData = Product(Navigator.Name, Stream, AutofillType.Password, id)
//        var productRef = FirebaseDatabase.getInstance().getReference()
//            .child("Products/$id")
//        progress.show()
//        productRef.setValue(productData).addOnCompleteListener{
//            progress.dismiss()
//            if (it.isSuccessful){
//                Toast.makeText(context, "Saving successful",Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//    fun viewProducts(
//        product: MutableState<Product>,
//        products: SnapshotStateList<Product>
//    ): SnapshotStateList<Product>{
//        var ref = FirebaseDatabase.getInstance().getReference().child("Products")
//        progress.show()
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                progress.dismiss()
//                products.clear()
//                for (snap in snapshot.children) {
//                    val value = snap.getValue(Product::class.java)
//                    product.value = value!!
//                    products.add(value)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//            fun <DatabaseError> onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//        return products
//    }
//
//    fun deleteProduct(id: String) {
//        val delRef = FirebaseDatabase.getInstance().getReference()
//            .child("Products/$id")
//        progress.show()
//        delRef.removeValue().addOnCompleteListener {
//            progress.dismiss()
//            if (it.isSuccessful) {
//                Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    fun updateProduct(name: String, quantity: String, price: String, id: String) {
//        var updateRef = FirebaseDatabase.getInstance().getReference()
//            .child("Products/$id")
//        progress.show()
//        var updateData = Product(name, quantity, price, id)
//        updateRef.setValue(updateData).addOnCompleteListener {
//            progress.dismiss()
//            if (it.isSuccessful) {
//                Toast.makeText(context, "Update successful",Toast.LENGTH_SHORT).show()
//            }else {
//                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
class productviewmodel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel = AuthViewModel(navController, context)
    var progress: ProgressDialog

    init {
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN_SCREEN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveProduct(productName: String, productQuantity: String, productPrice: String) {
        val id = System.currentTimeMillis().toString()
        val productData = Product(productName, productQuantity, productPrice, id,)
        val productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewProducts(
        product: MutableState<Product>,
        products: SnapshotStateList<Product>
    ): SnapshotStateList<Product> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Products")

        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                products.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Product::class.java)
                    product.value = value!!
                    products.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }

    fun deleteProduct(id: String) {
        val delRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateProduct(name: String, quantity: String, price: String, id: String) {
        val updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        val updateData = Product(name, quantity, price, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

//    fun saveProductWithImage(
//        productName: String,
//        productQuantity: String,
//        productPrice: String,
//        filePath: Uri
//    ) {
//        var id = System.currentTimeMillis().toString()
//        var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
//        progress.show()
//
//        storageReference.putFile(filePath).addOnCompleteListener {
//            progress.dismiss()
//            if (it.isSuccessful) {
//                // Proceed to store other data into the db
//                storageReference.downloadUrl.addOnSuccessListener {
//                    val imageUrl = it.toString()
//                    val houseData = Upload(
//                        productName, productQuantity,
//                        productPrice, imageUrl, id
//                    )
//                    var dbRef = FirebaseDatabase.getInstance()
//                        .getReference().child("Uploads/$id")
//                    dbRef.setValue(houseData)
//                    Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//

    fun viewUploads(
        upload: MutableState<Upload>,
        uploads: SnapshotStateList<Upload>
    ): SnapshotStateList<Upload> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Uploads")

        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                uploads.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Upload::class.java)
                    upload.value = value!!
                    uploads.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return uploads
    }
}