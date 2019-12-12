mkdir -p build
cp CodeGenerator.jjt build
cp PrintVisitor.java build
cd build
jjtree CodeGenerator.jjt
javacc CodeGenerator.jj
javac *.java
