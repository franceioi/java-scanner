all:
	gcj --encoding=utf8 --main=Main -o Main Main.java ../src/Scanner.java
	./Main < 01.in

speed:
	bash EstimateSpeed.sh

clean:
	rm -rf Main
