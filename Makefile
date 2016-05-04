# 201120441 204616031 
# bennoam benshan2
compile: bin
	javac -cp src -d bin src/*.java

run:
	java -cp bin ExpressionsTest
	
bin:
	mkdir bin
	
check:
	java -cp src -jar checkstyle-5.7-all.jar -c biuoop.xml src/*.java