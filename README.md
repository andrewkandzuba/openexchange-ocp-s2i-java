# Deploy Java Spring Boot web service with OpenShift Source-to-Image tool

## Pre-requisites

- Active RedHat Enterprise Subscription.
- Active RedHat OpenShift Container Platform (RHOCP) Subscription.
- Virtual Machine (VM) running RHEL 8.

## Prepare the environment 

### Register the VM with RedHat Enterprise Subscription.
```bash
/> sudo subscription-manager register 
```

### Install containers tools
```bash
/> sudo yum install -y container-tools
/> podman --version
```

### Install OCP CLI tool

Please follow the instructions to get `oc` command installed to your VM.

### Install Github command line
```bash
/> sudo yum install -y git
```

## Deploy Java Spring Boot application with OCP command
```bash
/> oc new-app registry.redhat.io/ubi8/openjdk-11~https://github.com/andrewkandzuba/openexchange-ocp-s2i-java.git --name=rest-api-app
/> oc get all -o wide
/> oc expose service rest-api-app
/> curl -v <ROUTE_URL>/greetings?name=John
```
## Limitations

- The final fat jar should be located under `target` folder under the root of the project.
- No modules in Maven project. 
- No multi-tenant microservices deployment. 

