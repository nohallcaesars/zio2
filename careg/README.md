# car-registration
- [blog by adam warski](https://softwaremill.com/structuring-zio-2-applications/)
  - [his other post concerning scala](https://blog.softwaremill.com/managing-dependencies-using-zio-8acc1539e276)
- [sample code](https://github.com/softwaremill/zio2-structure/tree/master/core/src/main/scala)

- write an application that allows us to register cars
- There will be a couple of components that, which try to mimic how a business application might be structured:
  - api: parses user requests and passes control to the service 
  - service: implements the business logic of registering a car: checking in the repository if there's already an entry for the given license plate, and if not, inserting a new one 
  - repository: implements the logic of querying and writing to the database. Our example code will only pretend to implement access to a relational database, though 
  - database: contains methods that allow running a set of database-interacting code in a transaction, using a connection obtained from the connection pool 
  - connection pool: contains methods to obtain & release a connection
