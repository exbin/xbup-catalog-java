eXtensible Binary Universal Protocol - Catalog Web Service
==========================================================

This is web application for accessing XBUP catalog content via web browser.

Homepage: https://xbup.exbin.org  

Compiling
---------

Java Development Kit (JDK) version 8 or later is required to build this project.

For project compiling Gradle 6.0 build system is used: https://gradle.org

You can either download and install gradle or use gradlew or gradlew.bat scripts to download separate copy of gradle to perform the project build.

Build commands: "gradle build" and "gradle distZip"

Dependencies are either downloaded or loaded from local maven repository. 

Althought project can be opened using gradle plugin, it doesn't support code completition in web pages. As an alternative way, you can generate pom.xml using following command:

gradle createPom

Also copy xbup-core and xbup-catalog jar files in local maven repository.

It can deployed using gradle publish or copied manually to .m2/repository/xbcatalogweb/modules/xbup-$project_name/$version in your user home directory or Local Settings folder.
To open project using pom.xml, you might need to temporary disable gradle plugin or even clear NetBeans cache.

License
-------

Project uses various libraries with specific licenses and some tools are licensed with multiple licenses with exceptions for specific modules to cover license requirements for used libraries.

Primary license: Apache License, Version 2.0 - see LICENSE.txt
