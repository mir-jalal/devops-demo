# Demo Application for DevOps

## Task Description
Create a simple hello world HTTP service, e.g. a Java Spring Boot app or whatever is easiest to quickly setup. Can be
Java or Python or whatever is most convenient and quick to set up, may also use an existing app from Docker Hub as the
assignment is more about docker configuration than the service itself.

The application should read in a configuration property file of some sorts with two keys whose values it displays on the
only page it serves. For Java that would be an application.properties file, probably.

Create a Dockerfile and any required entrypoint script(s) that:
* builds the application (if a build is required);
* allows to provide the two configuration properties to the application;
* one of the properties is a secret so needs to be handled as such (no plaintext storage in conf files);
* runs the service.

## Solution
To handle sensitive information securely, I used Docker Swarm environment. 
The process involved creating Docker secrets to manage sensitive data within the Swarm. 
Below are the steps taken to establish the environment and manage the secrets.

* To initialize the Docker Swarm environment, the following command was executed:
```shell
docker swarm init
```

* A Docker secret was created for pg_password using the command:
```shell
echo "my_secret_pass" | docker secret create pg_password -
```

* The containers were orchestrated and managed using Docker Compose:
```shell
docker-compose up -d
```

> PS: I created a basic Spring Application to create and store messages, and print them
