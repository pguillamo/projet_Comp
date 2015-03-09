CLASSPATH=libclass/:../antlr/antlr-3.5.jar
CLASS=libclass/

all: projet obj

projet: projet.tokens
	javac -cp $(CLASSPATH) -d $(CLASS) *.java

%.tokens: %.g
	java -cp $(CLASSPATH) org.antlr.Tool $<

obj: ww/simple.obj 

ww/%.obj: ww/%.pro
	$(shell pushd ww)
	echo -e "$(basename $<)\n" | java projet
	$(shell popd)

.PHONY:

clean:
	rm ww/*.gen
	rm ww/*.obj
	rm *.tokens
