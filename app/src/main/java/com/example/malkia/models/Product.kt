package com.example.malkia.models

//class Product internal constructor(
//    productName: String,
//    productQuantity: String,
//    productPrice: String,
//    id: String,
//    val price: String,
//    val quantity: String,
//    val name: String
//) {
    class Product{
        var name:String=""
        var quantity:String=""
        var price:String=""
        var id:String=""

        constructor(name:String,quantity:String,price:String,id:String){
            this.name=name
            this.quantity=quantity
            this.price=price
            this.id=id

        }
        constructor()
    }
