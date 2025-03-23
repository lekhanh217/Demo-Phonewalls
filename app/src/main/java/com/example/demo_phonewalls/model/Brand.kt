package com.example.demo_phonewalls.model

class Brand {
    private var id : String
    private var name : String
    private var create_at : String
    private var update_at : String?

    constructor(id: String, name: String, create_at: String, update_at: String?) {
        this.id = id
        this.name = name
        this.create_at = create_at
        this.update_at = update_at
    }
}