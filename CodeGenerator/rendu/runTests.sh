./compile.sh
cd build
rm -rf ../tests/output
mkdir ../tests/output
cp -r ../tests/input/* .
for file in *.txt; do
    java CodeGenerator $file > "../tests/output/output_$file"
done
cp *.ir ../tests/output/
rm *.txt
