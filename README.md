## Protocol Buffer demo using Java

## Getting started

- Install `Maven`
https://maven.apache.org/download.cgi

- Generate Proto Java from `.proto` file

    Protobuf file look like this
    
```protobuf
syntax="proto3";

package product;

option java_package = "com.telkomdev.protodemo";
option java_outer_classname = "ProductProtos";

message Product {
    string ID = 1;
    string Name = 2;
    uint64 Quantity = 3;
    repeated string Images = 4;
}

message ProductList {
    repeated Product Products = 1;
}
```

```shell
$ make gen
```


- Build `jar`
```shell
$ mvn clean package
```

- Run `jar`
```shell
$ java -jar target/JavaProtobufDemo-1.0-SNAPSHOT.jar
```