# create and manages jar 

# create a jar file
in jar-command

	create file CreateAJarFile.java
	> javac CreateAJarFile.java
	> jar -cvf MyJarFile.jar CreateAJarFile.class
	> cd ..
	> java -cp ./jar-command/MyJarFile.jar CreateAJarFile

# display content of jar

    > jar -tvf MyJarFile.jar
