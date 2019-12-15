rm -rf build
mkdir -p build
cp src/* build
cd build
jjtree CodeGenerator.jjt
javacc CodeGenerator.jj
javac *.java
