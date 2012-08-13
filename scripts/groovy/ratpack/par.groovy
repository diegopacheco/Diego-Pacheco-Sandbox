
get("/coocker/:cid"){
   cookers = [ "25": "Jose: The Dark Night Rises", 
			   "29": "Poletto: Little Dozer Strickes Again", 
			   "30": "Toff: Mimic like a Boss" ]
   coocker =  (cookers[urlparams.cid] == null ) ? "Cozinhador..." : cookers[urlparams.cid]
   "This is a master cooker of: ${coocker}"
}

get("/"){
   
   """
List of Services:
=================

1. Get Cooker --> List coocker speaciality
	Path: /coocker/:ID --> String
   """
   
}

