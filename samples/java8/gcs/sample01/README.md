# java8 - gcs - sample01

## env
```
$ mvn -v
Apache Maven 3.5.0
Maven home: /usr/share/maven
Java version: 1.8.0_181, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: ja_JP, platform encoding: UTF-8
OS name: "linux", version: "4.13.0-46-generic", arch: "amd64", family: "unix"
```

## create project
```
$ mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.example -DartifactId=sample01
```

## create and setting backet
```
$ gsutil mb gs://test01
Creating gs://test01/...
ServiceException: 409 Bucket test01 already exists.

$ gsutil mb gs://sky0621_test01
Creating gs://sky0621_test01/...

$ gsutil defacl set public-read gs://sky0621_test01
Setting default object ACL on gs://sky0621_test01/...

$ gsutil list
gs://sky0621_test01/

$ gsutil ls -a
gs://sky0621_test01/
```
