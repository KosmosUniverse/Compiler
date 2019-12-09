mkdir -p build
cp CodeGenerator.jjt build
cp Print.java build
cd build
jjtree CodeGenerator.jjt
javacc CodeGenerator.jj
javac *.java
