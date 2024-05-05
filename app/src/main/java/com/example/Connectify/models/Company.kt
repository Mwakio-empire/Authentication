package com.example.Connectify.models

class Company {
    var JobTitle:String = ""
    var companydescription:String = ""
    var Jobsummary:String = ""
    var qualification:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(JobTitle:String,companydescription:String ,Jobsummary:String,qualification:String , imageUrl: String, id: String) {
        this.JobTitle = JobTitle
        this.companydescription =companydescription
        this.Jobsummary = Jobsummary
        this.qualification = qualification
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}