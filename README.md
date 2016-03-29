XBUP Java Catalog Web Application
=================================

TODO

This is web application for accessing XBUP catalog content.

XBUP: eXtensible Binary Universal Protocol
==========================================

The goal of this project is to design and to provide an open-source support for unified general binary data representation format.

This should provide following advantages:

 * Advanced Data Structures - Unified structure should allow to combine various types of data together
 * Efficiency - Optional compression and encryption on multiple levels should allow effective representation of binary data
 * Flexibility - General framework should provide data transformations/processing and compatibility issues solving capability
 * Comprehensibility - Catalog of data types, metadata, relations and abstraction should allow better understanding of data

Homepage: http://xbup.exbin.org  

This repository contains Java implementation of the protocol and support tools and sample files.

Compiling
---------

Java Development Kit (JDK) version 7 or later is required to build this project.

For project compiling Gradle 2.0 build system is used. You can either download and install gradle and run "gradle build" command in project folder or gradlew or gradlew.bat scripts to download separate copy of gradle to perform the project build.

Build system website: http://gradle.org

Development
-----------

 * NetBeans 8.0 or later was used

Althought project can be opened using gradle plugin, it doesn't support code completition in web pages. As an alternative way, you can generate pom.xml using following command:

gradle createPom

Also copy xbup-core and xbup-catalog jar files in local maven repository.

It can deployed using gradle publish or copied manually to .m2/repository/xbcatalogweb/modules/xbup-$project_name/$version in your user home directory or Local Settings folder.
To open project using pom.xml, you might need to temporary disable gradle plugin or even clear NetBeans cache.

License
-------

Project uses various libraries with specific licenses and some tools are licensed with multiple licenses with exceptions for specific modules to cover license requirements for used libraries.

Main license is: GNU/LGPL (see gpl-3.0.txt AND lgpl-3.0.txt)  
License for documentation: GNU/FDL (see doc/fdl-1.3.txt)  
