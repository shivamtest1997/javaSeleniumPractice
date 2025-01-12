# Docker

## What is Docker
: Docker is a platform designed to make it easy to create,deploy and run applications using `containers`
  Containers allow user to package up the applications with all its requirements such as dependencies libraries etc.

: Docker is mainly useful for-
    `Application Deployment`
    `Microservices Architecture`
    `DevOps and Continious integration`
    `scalability`

## Why Docker
   : Consistency:   Ensure tests run consistently across different systems. 
   : Efficiency:    Lightweight containers enable efficient resource utilization
   : Isolation:    Encapsulate dependencies within containers for seamless test execution.

## Docker Terminologies
1. DockerHub : Docker hub is cloud based registry service where we can store/create docker images
   it serves as central repository for dicker images

2. Images : Docker images are blueprint for containers it contains application code,libraries,dependencies and other
   settings required for an application to run

3. Containerization : Containers are lightweight and standalone ensuring consistency across various environments
   They encapsulate the application and its dependencies at runtime in isolated container.

4. Docker Engine : Docker Engine is a core component that manages containers it consists of server, Rest API and Command line

5. Docker File : A docker file is a script that contains instructions for building an docker image
    It specifies base Image,application code,dependencies and Other configuration settings

6. Volume Mapping : volume mapping is a process to map particular data from container with folder of local machine
   The data from container is dynamic which is being mapped with static folder
           `docker run -it -v <path of local folder> :<path of container> ubuntu`

7. Port Mapping : A port mapping is a process to map port of container with local machine si that we will be able to execute 
    it on local machine through container machine
        `docker run -p <port of local>:<port of container> imageName`
        `docker run -p 8080:8080 jenkins/jenkins`


## Docker Commands
1. `docker images` --used to check images present on system
2. `docker pull <image>`--used to pull image from docker hub
3. `docker ps`--shows all running container
4. `docker ps -a`--shows all containers including stopped container
5. `docker run image`--creates container from image
6. `docker stop <containerId>`--stops running container
7. `docker system prune -f`--to remove all stopped containers
8. `docker system prune -a`-- to remove containers + images
9. `docker rmi <image name>`--to remove image from system
10. `docket rm <containerId>`--to remove container
11. `docker run -it <image name>`--to run container in interactive mode
12. `docker run -it entrypoint=/bin/bash <image name>` --entrypoint is command to executed once container is created
13. `docker run -name <container name> <image name>` -- to give name to container
14. `docker run -p <port of host> : <port of container> imageName` --This command is used for port mapping
15. `docker run -it -v <path of host dir>: <path of conatainer> imageName`--This command is used for volume mapping
16. `docker network create <name>`--This command is used to create network
17. `docker build -t username/imagename .`--This command is used to create docker image
18. `docker-compose up` --this command is used to execute docker-compose.yaml file
