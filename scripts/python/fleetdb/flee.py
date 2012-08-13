import fleetdb

db = fleetdb.FleetDBClient("localhost", 3400)
companies = db.select("companies")
print companies

db.insert("companies", [ { 'id' : 1, 'name' : 'Yield Idea'}, { 'id' : 2, 'name' : 'GitHub'} ])
companies = db.select("companies")
print companies
