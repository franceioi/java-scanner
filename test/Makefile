all:
	gcj --encoding=utf8 --main=Main -o Main Main.java ../src/Scanner.java
	./Main < 01.in
	gcj --encoding=utf8 --main=Main -o Main Main2.java ../src/Scanner.java
	./Main < 02.NoEnd.in

speed:
	bash EstimateSpeed.sh

clean:
	rm -rf Main
