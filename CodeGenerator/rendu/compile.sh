mkdir -p build
cp CodeGenerator.jjt build
cd build
jjtree CodeGenerator.jjt
javacc CodeGenerator.jj
javac *.java
