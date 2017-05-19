# spring-boot-docker
Simple Spring Boot Application With Docker PlugIn and Dockerfile

s
Docker 

What is docker?
Docker is a linux based program which runs on linux platform. It is software program to create container.
Using containers, everything required to make a piece of software run is packaged into isolated containers. Unlike VMs, containers do not bundle a full operating system - only libraries and settings required to make the software work are needed. This makes for efficient, lightweight, self-contained systems and guarantees that software will always run the same, regardless of where it’s deployed.

In simple words, if you want to run spring boot application,you need java runtime, some network functionality expose through IP and port. Basic terminal commands. You don’t need complete OS features like GUI and graphics libraries. We need to define the basic features in the Dockerfile (which is similar to pom.xml)  and build. Which created docker image.


Virtual Machine Vs Docker

Docker uses specific OS resources to run the desired software. Whereas VM requires full Guest OS on top of the main operating system.
Docker is designed to run specific process whereas VM can be used to run multiple processes inside the guest OS.





How does docker works?
Docker supports all Operating systems(OS-X) like windows and MacOS.
Docker works only on linux hence it requires virtualBox as shown in the below image.
From OS-X , the communication to docker happens through VirtualBox and Linux and to the Docker.
	OS-X
Docker client resides in OS-X
Docker Machine allows to connect docker client and docker and responsible for to communication exchange.


Docker software Components
Following are the software components to install docker
Docker ToolBox
Docker Engine

Docker ToolBox:  Following are the sub components inside the ToolBox

Docker Client: communication into docker through REST API
Docker Machine: Docker Machine is a tool that lets you install Docker Engine on virtual hosts, and manage the hosts with docker-machine commands
Docker Compose:  Compose is a tool for defining and running multi-container Docker applications.
Docker Kitematic: GUI to manage docker
VirtualBox:  Provides linux environment for docker 

Docker Engine: Docker Engine is a client-server application with these major components

A server which is a type of long-running program called a daemon process (the dockerd command).
A REST API which specifies interfaces that programs can use to talk to the daemon and instruct it what to do.
A command line interface (CLI) client (the docker command).




Docker Image and Container





Within the docker , initially we need to create docker image by own or pull from HUB.
Docker Image:   It is the read-only copy of the operating system libraries, the application and its libraries
NOTE: In typical cases, developer build docker images from available from trusted sources (Operating System, common libraries, JDK8 images).

Command to see available local images
$/> docker images 

Docker Container: Docker containers are the running instances of a docker image. Containers use the kernel of the host operating system when running. Hence, they share the host kernel with other containers running on the same host.

Command to see running containers
$/>docker ps -as

Docker Registry: Once you create docker image you push into your centralized repository. Or you can use existing images called docker registry.

Dockerfile: A dockerfile is a build or scripting file that contains instructions to build a docker image. There can be multiple steps documented in the Dockerfile, starting from getting a base image. Dockerfile is a text file that is generally named Dockerfile.
Execute below command in the same directory where you have Dockerfile
		$/>docker build
	
	To test this write simple Dockerfile like this
	
	FROM java:8
	ENTRYPOINT [“java”,”version”]


Understand docker Image structure
There are three layers 
BOOTFS: The first layer in the image is a boot file system called bootfs. Which is similar to kernel and the boot loader. The boot filesystem acts as a virtual filesystem for all images.
ROOTFS: On top of bootfs , operating system filesystem is placed, which is called rootfs.It adds the typical operating system directory structure to the container. It is in read-only mode.
OTHER IMAGES: on top of rootfs, other images are placed as per the requirements, In our case, these are JRE and the spring boot microservices JARS. 
WRITEABLE FILE SYSTEM: when a container initiated, a writable file system is placed on top of the all the other filesystem for the processes to run. This is volatile ,data is lost when container is stopped.

Docker Engine Vs Docker Machine
When we say “Docker” it is typically means “Docker Engine”,  the client-server application made up of the docker daemon, REST API and CLI client that talks to the daemon through REST API wrapper.


Image: Docker engine


Docker Machine:  it is a tool for provisioning and managing your dockerized hosts (hosts with docker engine on them). Typically you install docker machine on your local system. 
Docker machine has its own CLI client (called docker-machine) and the docker engine client(docker).

You can use docker machine to install docker engine on one or more virtual systems. 
These virtual systems two types
  Local( VirtualBox on Mac) 
  Cloud( AWS) 



Docker Machine
Using below commands to create docker machine
List all the machines
$/>docker-machine ls
Create default machine
$/>docker-machine create default


Running Docker image
Below command used to run the docker image

Gives list of images in local
$/>docker images  
Run docker container in background with given name 
$/>docker run -d -P --name THIRU  <image_name>
$/>docker run -it <image_name>  (interactive mode) 
$/>docker port THIRU
$/>docker-machine ip default
List all the running containers
$/>docker ps -as
Build docker image from Dockerfile
$/>docker build -t <tag_with_some_name>  .
$/>docker build -f <Dockerfile_path>  .
Stop the running container 
$/>docker stop <container_id>
$/>docker start <container_id>
Remove the container 
$/>docker rm <container_id>
Delete the Image
$/>docker rmi <image_id>
History of image
$/>docker history <image_name>
Docker information
$/>docker info
       
 Environment variables are supported by the following list of instructions in the Dockerfile:
ADD
COPY
ENV
EXPOSE
LABEL
USER
WORKDIR
VOLUME
STOPSIGNAL



Pushing Docker Image to Registry (HUB)

Login into hub from CLI  
	$/>docker login -utvajjala -pD0cker
Tag your local image with Docker ID
	$/>docker tag <image_repo_name>   tvajjala/some_name
Push docker image into Registry
	$/>docker push tvajjala/some_name
Check on HUB





