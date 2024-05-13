package com.example.malkia.models

class Product {
    var name:String=""
    var stream:String=""
    var password:String=""
    var id:String=""
    
    constructor(name:String,stream:String,password:String,id:String){
        this.name=name
        this.stream=stream
        this.password=password
        this.id=id
    }
    constructor()
}