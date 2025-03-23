package com.example.demo_phonewalls.model

class Picture {
    private var id : String
    private var brand_id : String
    private var name : String
    private var resolution : String
    private var url : String
    private var create_at : String
    private var update_at : String?
    private var colorList : List<Color>
    constructor(
        id: String,
        name: String,
        brand_id: String,
        resolution: String,
        url: String,
        create_at: String,
        update_at: String ?,
        colorList: List<Color>
    ) {
        this.id = id
        this.name = name
        this.brand_id = brand_id
        this.resolution = resolution
        this.url = url
        this.create_at = create_at
        this.update_at = update_at
        this.colorList = colorList
    }

    override fun toString(): String {
        return "$id $brand_id $name $resolution $url $create_at $update_at sizeColor ${colorList.size}";
    }
}