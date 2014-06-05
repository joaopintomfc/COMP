for f in $(pwd)/testsuite/*;
do
if [[ ${f: -4} != ".txt" ]];
then java -jar dsl.jar $f
fi
echo ""
done
rm -r $(pwd)/temp/
