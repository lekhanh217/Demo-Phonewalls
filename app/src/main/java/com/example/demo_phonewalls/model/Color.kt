package com.example.demo_phonewalls.model

class Color {
    private var id : String
    private var picture_id : String
    private var hex_code : String
    private var create_at : String
    private var update_at : String

    constructor(
        id: String,
        picture_id: String,
        hex_code: String,
        create_at: String,
        update_at: String
    ) {
        this.id = id
        this.picture_id = picture_id
        this.hex_code = hex_code
        this.create_at = create_at
        this.update_at = update_at
    }
}