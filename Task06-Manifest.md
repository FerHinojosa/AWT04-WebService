##Understanding the Manifest File
source: https://www.baeldung.com/java-jar-manifest

#1. Introduction
A Java Archive (JAR) is described by its manifest file. This article explores its many capabilities, including adding attribution, making the JAR executable, and embedding versioning information.

Let's begin, though, with a quick review of what a manifest file is.

#2. The Manifest File
The manifest file is named MANIFEST.MF and is located under the META-INF directory in the JAR. It's simply a list of key and value pairs, called headers or attributes, grouped into sections.

These headers supply metadata that help us describe aspects of our JAR such as the versions of packages, what application class to execute, the classpath, signature material and much more.

#3. Adding a Manifest File
3.1. The Default Manifest
A manifest file is added automatically whenever we create a JAR.

For example, Maven adds some extra headers:

Manifest-Version: 1.0
Archiver-Version: Plexus Archiver
Created-By: Apache Maven 3.3.9
Built-By: baeldung
Build-Jdk: 11.0.3


Say, for example, that we want to indicate who the JAR was created by and the package:
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.1.2</version>
    <configuration>
        <archive>
            <manifest>
                <packageName>com.baeldung.java</packageName>
            </manifest>
            <manifestEntries>
                <Created-By>baeldung</Created-By>
            </manifestEntries>
        </archive>
    </configuration>
</plugin>
This produces a manifest file with a custom package and created-by headers:

