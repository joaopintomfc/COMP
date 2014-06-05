for f in $(pwd)/examples/*;
do
if [[ ${f: -4} != ".txt" ]];
then java -jar dsl.jar $f
fi
echo ""
done
rm -r $(pwd)/temp/
