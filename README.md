# spring-gracefulshutdown

## build and push docker image

``` bash
docker build -t mkaio/spring-gracefulshutdown:1.0 .
docker push mkaio/spring-gracefulshutdown:1.0 .
```

## deploy to kubernetes (minikube)

- Modify datasource host, port and DB name.

``` yml
# deploy/development/configmap.yml
datasource.url: "jdbc:mysql://<HOST>:<PORT>/<DB_NAME>"
```

- create deploy/development/secret.yml and add key-value as follows

``` yml
# deploy/development/secret.yml
apiVersion: v1
kind: Secret
metadata:
  name: sample-app-db-secret
type: Opaque
data:
  password: <DB_PASSWORD_ENCODED_TO_BASE64>
```

- start minikube

``` bash
minikube start --vm-driver=virtualbox --memory='4g'
```

- deploy

``` bash
kubectl apply -f deploy/development/namespace.yml
kubectl apply -f deploy/development
```