get("/profile/cooker/:cookerID") {
    render "profile.html", [id: urlparams.cookerID]
}

