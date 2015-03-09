CLASSPATH=libclass/:../antlr/antlr-3.5.jar
CLASS=libclass/
WW=ww
CC=javac -cp $(CLASSPATH) -d $(CLASS)
JAVA=java -cp $(CLASSPATH)

all: projet gen

projet: projet.tokens
	$(CC) *.java

%.tokens: %.g
	$(JAVA) org.antlr.Tool $<

gen: $(WW)/simple.gen $(WW)/exempcond.gen

$(WW)/%.gen: $(WW)/%.pro
	echo -ne "$(basename $<)\n\n" | $(JAVA) projet

$(WW)/%.utf8.gen: $(WW)/%.gen
	iconv -o $@ -f ISO-8859-1 -t UTF-8 $<

test: testgen

testgen: simple.test exempcond.gen

%.test: $(WW)/%.gentest $(WW)/%.utf8.gen
	diff $^ && echo "OK" || echo "FAIL"

.PHONY: projet gen test testgen %.test clean

clean:
	rm -f $(WW)/*.gen
	rm -f $(WW)/*.obj
	rm -f *.tokens
