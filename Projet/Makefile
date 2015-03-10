CLASSPATH=libclass/:../antlr/antlr-3.5.jar
CLASS=libclass/
WW=ww
CC=javac -cp $(CLASSPATH) -d $(CLASS)
JAVA=java -cp $(CLASSPATH)

all: projet build

projet: projet.tokens
	$(CC) *.java

%.tokens: %.g
	$(JAVA) org.antlr.Tool $<

build: $(WW)/simple.gen $(WW)/exempcond.gen

$(WW)/%.gen: $(WW)/%.pro
	echo -ne "$(basename $<)\n\n" | $(JAVA) projet

$(WW)/%.utf8.gen: $(WW)/%.gen
	iconv -f ISO-8859-1 -t UTF-8 $< | tr -d '\r' > $@

test: simple.test exempcond.test

%.test: $(WW)/%.test.gen $(WW)/%.utf8.gen
	diff $^ > /dev/null && echo "[ OK ]" || echo "!! FAIL !!"

%.diff: $(WW)/%.test.gen $(WW)/%.utf8.gen
	vimdiff $^

$(WW)/%.test.gen: $(WW)/%.pro
	python3 test_builder.py $<

.PHONY: projet build gen test %.test %.diff clean

clean:
	rm -f $(WW)/*.gen
	rm -f $(WW)/*.obj
	rm -f *.tokens

