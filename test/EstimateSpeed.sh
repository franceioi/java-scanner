cmdJava="cat tmp.in | ./Speed java"
cmdAlgorea="cat tmp.in | ./Speed algorea"


firstMemJava=-1
firstMemAlgorea=-1

echo "Comparison of Java's Scanner / our Scanner"
echo ""

for nb in 10 5000 10000 25000 50000 75000 100000 150000 200000
do
   echo "For $nb integers :"
   
   # Generation of test file and compilation
   echo "$nb" | python3 GenerateTest.py > tmp.in
   gcj --encoding=utf8 --main=Speed -o Speed Speed.java ../src/Scanner.java

   # Java version
   cmd=$cmdJava
   timeMaxJava=$(/usr/bin/time -f "%E" bash -c "$cmd" 2>&1 > /dev/null | sed 's/:/*60+/' | bc)
   ./memusg bash -c "$cmd" >/dev/null
   sleep 0.1
   memMaxJava=$(cat memusg.out)

   # Algorea version
   cmd=$cmdAlgorea
   timeMaxAlgorea=$(/usr/bin/time -f "%E" bash -c "$cmd" 2>&1 > /dev/null | sed 's/:/*60+/' | bc)
   ./memusg bash -c "$cmd" >/dev/null
   sleep 0.1
   memMaxAlgorea=$(cat memusg.out)

   # Remove initial memory usage
   if [ $firstMemJava -eq -1 ]
   then
      firstMemJava=$(($memMaxJava - 100))
      firstMemAlgorea=$(($memMaxAlgorea - 100))
   fi;

   #memMaxJava=$(($memMaxJava - $firstMemJava))
   #memMaxAlgorea=$(($memMaxAlgorea - $firstMemAlgorea))

   # Compute ratios and plot results
   ratioTime=$(echo "scale=1;$timeMaxJava / $timeMaxAlgorea" | bc)
   ratioMem=$(echo "scale=1;$memMaxJava / $memMaxAlgorea" | bc)

   echo -e "Time : ${timeMaxJava}s vs ${timeMaxAlgorea}s"
   echo -e "Memory : ${memMaxJava}K vs ${memMaxAlgorea}K"
   echo -e "Ratios (time/mem) : $ratioTime and $ratioMem"
   echo ""

done;

# Cleanup
rm -f memusg.out tmp.in Speed







# Does not work as intended, why ??
#mem=$(valgrind --tool=massif --pages-as-heap=yes --massif-out-file=massif.out bash -c "$cmd" > /dev/null 2>&1; cat massif.out | grep mem_heap_B | sed -e 's/mem_heap_B=\(.*\)/\1/' | sort -g | tail -n 1)
#echo "Max memory : ${mem}K"

