# api docs generator

javadoc [options] [packagenames] [sourcefiles] [@files]

in javadoc-command

	> javac JavaDocumentation.java
	> javadoc -d ./javadoc JavaDocumentation.java
	
#  run javadoc in gradle / maven


Windows: For example, if you want to document com.mypackage, whose source files reside in the directory \user\src\com\mypackage, and if this package relies on a library in \user\lib, then you would use the following command:

    javadoc -sourcepath \user\lib -classpath \user\src com.mypackage

Similar to other tools, if you don't specify -classpath, then the javadoc command uses the CLASSPATH environment variable when it's set. If both aren't set, then the javadoc command searches for classes from the current directory.