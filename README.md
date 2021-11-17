# Extia Fleet Manager Assignment
This project is my assignment for the recruiting process with Extia. I have to produce a REST API with Spring. This API will help to manage a fleet of tractors, their cargos and expeditions. 

***

# Execution
1. Right clic on the project in Eclipse : Run as -> Maven Build ... 
2. In Goals set : clean install -X
3. Click Apply. Click Run
4. You should see "Build Success" after a few seconds
5. Make sure that port 8080 is not already in use
6. In Eclipse run the class Accessingapplication as a Java Application. The last line in the console should be : 
com.extia.fleet.AccessingApplication     : Started AccessingApplication
7. You can now call the API with a REST client like POSTMAN or Advanced REST Client

***

# API
Here are some methods available. I didn't have enough time to fully describe them.

**GET /tracteurs/** return all tractors in json format

**GET /expeditions/** return all expeditions in json format

**GET /entrepots/** return all entrepots in json format

**GET /cargaisons/** return all cargaisons in json format

**GET /tracteurs/{id}** delete tractor with given id

**POST /tracteurs/new** Save a Tractor in Json format. charge is an integer between 1 and 3
`{`
  `"nom": "purpleOne",`
  `"charge": "3"`
`}`

**POST /tracteurs/edit/{id}** Edit the Tractor with given id with new data given in Json :
`{`
  `"nom": "GreenOne",`
  `"charge": "1"`
`}`

**GET /new/{tracId}/{cargId}** Create a new Expedition with status A("En Attente") and given tractor and cargo


